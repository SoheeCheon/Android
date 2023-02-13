package ko.cheonsohee.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

// 화면을 구성하는 한 요소
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // xml에 있는 button를 코틀린 코드에 가져온다.
        val btnClickme = findViewById<Button>(R.id.mybutton)
        val txtMytext = findViewById<TextView>(R.id.mytextview)
        var timesClicked = 0
        // 실행되기 바라는 액션
        btnClickme.setOnClickListener {
            timesClicked += 1

            // string으로 변환한다.
            txtMytext.text = timesClicked.toString()
            Toast.makeText(this, "Hey I'm a toast!", Toast.LENGTH_LONG).show()
        }
    }
}