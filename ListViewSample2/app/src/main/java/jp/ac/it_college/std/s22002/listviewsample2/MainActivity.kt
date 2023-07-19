package jp.ac.it_college.std.s22002.listviewsample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import jp.ac.it_college.std.s22002.listviewsample2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var menuList = mutableListOf(
            "から揚げ定食",
            "ハンバーグ定食",
            "生姜焼き定食",
            "ステーキ定食",
            "野菜炒め定食",
            "とんかつ定食",
            "ミンチカツ定食",
            "チキンカツ定食",
            "コロッケ定食",
            "回鍋肉定食",
            "麻婆豆腐定食",
            "青椒肉絲定食",
            "八宝菜定食",
            "酢豚定食",
            "豚の角煮定食",
            "焼き鳥定食",
            "焼き魚定食",
            "焼肉定食",
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, menuList)
        binding.lvMenu.adapter = adapter

    }
}