package kr.ac.hallym.prac09_cardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.prac09_cardview.databinding.ActivityCardViewBinding

class CardViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityCardViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_card_view)

        binding = ActivityCardViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contents1 = mutableListOf<Int>(R.drawable.baseball,R.drawable.lake,R.drawable.train)
        val contents2 = mutableListOf<String>("야구장", "호수", "등산열차")
        val contents3 = mutableListOf<String>("야구장은..","호수는..","등산열차는..")

        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = MyAdapter(contents1,contents2, contents3)
        binding.recycleView.addItemDecoration(
            DividerItemDecoration(this,LinearLayoutManager.VERTICAL)
        )
    }
}