package jp.ac.it_college.std.s22002.hellosample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import jp.ac.it_college.std.s22002.hellosample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /*
    ViewBinding 機会を使って画面を作る方法
    activity_main.xml ファイルに対してActivityMainBinding クラスが
    自動生成されます。(レイアウトファイル名　+ Binding)
    */
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding クラスのインスタンスを生成してもらう
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Binding クラスが管理しているビューを使う
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        // ボタンを取ってくる
//        val btClick = findViewById<Button>(R.id.btClick)
        // findViewByID出とってくるとかしません

        // リスナクラスのインスタンスを作る
        val listener = HelloListener()
        // ボタンにリスナを設定する
        binding.btClick.setOnClickListener(listener)
    }

    private inner class HelloListener: View.OnClickListener{
        override fun onClick(v: View?) {
            // 名前が入力されるであろうEditTextを取ってくる
            //val input = findViewById<EditText>(R.id.etName)
//            val input = binding.etName

            //メッセージを表示するTextviewオブジェクトを取得
//            val output = findViewById<TextView>(R.id.tvOutput)
//            val output = binding.tvOutput

            //入力された名前文字列を取得
            val inputStr = binding.etName.text.toString()

            //メッセージを表示
//            output.text = "${inputStr}さん、こんにちは！"
            binding.tvOutput.text = "${inputStr}さん、こんにちは！"
        }


    }
}