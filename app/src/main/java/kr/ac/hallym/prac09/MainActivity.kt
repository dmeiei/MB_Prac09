package kr.ac.hallym.prac09

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kr.ac.hallym.prac09.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            val resultData = it.data?.getStringExtra("result")
            binding.mainResultText.text = "result: $resultData"

            //연습문제2
            val name1 = it.data?.getStringExtra("data4")
            binding.mainResultText2.text = "이름: $name1"
            val number1 = it.data?.getStringExtra("data5")
            binding.mainResultText3.text = "학번: $number1"

        }

        binding.button1.setOnClickListener {

            val intent: Intent = Intent(this,DetailActivity::class.java)
            //연습문제1
            val message = binding.editView.text.toString()
            intent.putExtra("data3",message)

            intent.putExtra("data1","hello")
            intent.putExtra("data2",10)
//            startActivityForResult(intent,11)
            requestLauncher.launch(intent)

        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == 11 && resultCode == Activity.RESULT_OK){
//            val result = data?.getStringExtra("result")
//            Toast.makeText(this, "Received: result: $result", Toast.LENGTH_SHORT).show()
//        }
//    }
}