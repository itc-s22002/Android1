package jp.ac.it_college.std.s22002.intentsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import jp.ac.it_college.std.s22002.intentsample.databinding.ActivityMenuThanksBinding

class MenuThanksActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuThanksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuThanksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val menuName = intent.getStringExtra("menuName") ?: ""
        val menuPrice = intent.getIntExtra("menuPrice", 0)

        binding.tvMenuName.text = menuName
        binding.tvMenuPrice.text = "%,d".format(menuPrice)

        binding.btThxBack.setOnClickListener {
            finish()
        }

    }
}