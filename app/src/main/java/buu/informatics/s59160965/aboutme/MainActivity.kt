package buu.informatics.s59160965.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160965.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Phitchaya Krobphet")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            doneButton.setOnClickListener {
                addNickname(it)
            }
            nicknameText.setOnClickListener {
                updateNickname(it)
            }
            this.myName = this@MainActivity.myName
        }
    }

    private fun addNickname(view: View) {

        binding.apply {

            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
            doneButton.visibility = View.GONE

            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
        }
    }

    private fun updateNickname (view: View) {
       binding.apply {
           nicknameEdit.visibility = View.VISIBLE
           doneButton.visibility = View.VISIBLE
           nicknameText.visibility = View.GONE
           nicknameEdit.requestFocus()

           val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
           imm.showSoftInput(nicknameEdit, 0)
       }
    }
}
