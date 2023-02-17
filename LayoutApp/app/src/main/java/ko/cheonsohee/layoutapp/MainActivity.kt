package ko.cheonsohee.layoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var btnDone : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDone = findViewById(R.id.done_button)

        btnDone.setOnClickListener {
            addNickName(it)
        }
    }

    private fun clickHandlerFunction(viewThatIsClicked: View) {

    }

    private fun addNickName(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        nicknameTextView.text = editText.text

        editText.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
    }
}