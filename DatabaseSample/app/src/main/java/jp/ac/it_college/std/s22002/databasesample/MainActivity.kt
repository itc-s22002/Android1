package jp.ac.it_college.std.s22002.databasesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jp.ac.it_college.std.s22002.databasesample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var _helper: DatabaseHelper

    private var _cocktailId :Long  = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        _helper = DatabaseHelper(this)

        initList(binding.lvCooktail)

        binding.btnSave.setOnClickListener(::onSaveButton)
    }

    override fun onDestroy() {
        _helper.close()
        super.onDestroy()
    }

    private fun initList(list: RecyclerView){
        val data = resources.getStringArray(R.array.tv_cooktail_list)
        val adapter = CocktailAdapter(data.toList()){ pos, name ->
            binding.tvCooktailName.text = name

            _cocktailId = pos.toLong()

            binding.etNote.setText(loadCocktailMemos())
        }
        val manager = LinearLayoutManager(this)
        list.adapter = adapter
        list.layoutManager = manager
        list.addItemDecoration(
            DividerItemDecoration(this, manager.orientation)
        )
    }

    private fun onSaveButton(view: View){
        val note = binding.etNote.text.toString()
        val db = _helper.writableDatabase
        val deleteSQL = """
            | DELETE FROM cocktail_memos
            | WHERE _id = ?
        """.trimMargin()

        db.compileStatement(deleteSQL).let {stmt ->
            stmt.bindLong(1, _cocktailId)
            stmt.executeUpdateDelete()
        }

        val insertSQL = """
            | INSERT INTO cocktail_memos (_id, name, note)
            | VALUES (?, ?, ?)
        """.trimMargin()

        db.compileStatement(insertSQL).let { stmt ->
            stmt.bindLong(1, _cocktailId)
            stmt.bindString(2,binding.tvCooktailName.text.toString())
            stmt.bindString(3, note)
            stmt.executeInsert()
        }

        binding.etNote.setText("")
        binding.tvCooktailName.text = ""
        _cocktailId = 0
    }

    private fun loadCocktailMemos(): String{
        val db = _helper.readableDatabase


        val select = """
            | SELECT * FROM cocktail_memos
            | WHERE _id = ?
            """.trimMargin()
        val cursor = db.rawQuery(select, arrayOf("$_cocktailId"))

        return cursor.use {
            if (cursor.moveToNext()){
                cursor.getString(cursor.getColumnIndexOrThrow("note"))
            }else{
                ""
            }
        }
    }
}