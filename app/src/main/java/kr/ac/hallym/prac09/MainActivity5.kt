package kr.ac.hallym.prac09

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kr.ac.hallym.prac09.databinding.ActivityMain5Binding
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

class MainActivity5 : AppCompatActivity() {
    lateinit var binding: ActivityMain5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main5)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
//            var sum = 0L
//            var time = measureTimeMillis {
//                for (i in 1..2_000_000_000){
//                    sum += i
//                }
//            }
//            Log.d("kkang", "time: $time")
//            binding.resultView.text = "sum: $sum"
//            val handler = object: Handler(){
//                override fun handleMessage(msg: Message) {
//                    super.handleMessage(msg)
//                    binding.resultView.text = "sum: ${msg.arg1}"
//                }
//            }
//
//            thread{
//                var sum = 0L
//                var time = measureTimeMillis {
//                    for(i in 1..2_000_000_000){
//                        sum += i
//                    }
//                    val message = Message()
//                    message.arg1 = sum.toInt()
//                    handler.sendMessage(message)
//                }
//                Log.d("kkang", "time: $time")

//            }
            val channel = Channel<Int>()
            val backgroundScope = CoroutineScope(Dispatchers.Default + Job())
            backgroundScope.launch {
                var sum = 0L
                var time = measureTimeMillis {
                    for (i in 1..2_000_000_000) {
                        sum += i
                    }
                }
                Log.d("kkang", "time: $time")
                channel.send(sum.toInt())
            }
            val mainScope = GlobalScope.launch(Dispatchers.Main) {
                channel.consumeEach {
                    binding.resultView.text = "sum: $it"
                }
            }
        }
    }
}