package kr.ac.hallym.prac09

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.ac.hallym.prac09.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding:ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail)


        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //연습문제1
        val message = intent.getStringExtra("data3")
        binding.textView.text = message

        val data1 = intent.getStringExtra("data1")
        val data2 = intent.getIntExtra("data2",0)
        Toast.makeText(this,"Received: data1: $data1, data2: $data2",Toast.LENGTH_SHORT).show()

        binding.detailButton.setOnClickListener {

            //연습문제2
            val name1 = binding.name.text.toString()
            intent.putExtra("data4",name1)
            setResult(RESULT_OK, intent)
            val number1 = binding.number.text.toString()
            intent.putExtra("data5",number1)
            setResult(RESULT_OK, intent)


            intent.putExtra("result","world")
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}