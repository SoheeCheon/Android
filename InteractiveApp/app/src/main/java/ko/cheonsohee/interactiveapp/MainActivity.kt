package ko.cheonsohee.interactiveapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRoll: Button = findViewById(R.id.btnRoll)

        var tvDice: TextView = findViewById(R.id.tvNumber)
        tvDice.text = "Dice Rolled!"

        var tvCount: TextView = findViewById(R.id.tvCount)
        if (tvCount.text == "Hello World!") {
            tvCount.text = "1"
        }


        btnRoll.setOnClickListener {
            if (tvCount.text == "6") {
                Toast.makeText(this, "클릭 횟수를 넘어갔습니다.", Toast.LENGTH_SHORT).show()
            } else {
                rollDice()
                val randomInt = (1..6).random()
                tvDice.text = randomInt.toString()
                val cnt = tvCount.text.toString().toInt() + 1
                // Integer.parseInt(tvCount.text.toString())
                tvCount.text = cnt.toString()
            }
        }
    }

    private fun rollDice() {
        Toast.makeText(this, "버튼을 클릭하였습니다.", Toast.LENGTH_SHORT).show()
    }
}