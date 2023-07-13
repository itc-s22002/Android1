package jp.ac.it_college.std.s22002.hellosample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ボタンを取ってくる
        val btClick = findViewById<Button>(R.id.btClick)
        // リスナクラスのインスタンスを作る
        val listener = HelloListener()
        // ボタンにリスナを設定する
        btClick.setOnClickListener(listener)
    }

    private inner class HelloListener: View.OnClickListener{
        override fun onClick(v: View?) {
            // 名前が入力されるであろうEditTextを取ってくる
            val input = findViewById<EditText>(R.id.etName)

            //メッセージを表示するTextviewオブジェクトを取得
            val output = findViewById<TextView>(R.id.tvOutput)

            //入力された名前文字列を取得
            val inputStr = input.text.toString()

            //メッセージを表示
            output.text = "${inputStr}さん、こんにちは！"
        }


    }
}