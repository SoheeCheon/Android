package ko.cheonsohee.interactiveapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
//    var diceImage: ImageView? = null
    lateinit var diceImage1: ImageView
    lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRoll: Button = findViewById(R.id.btnRoll)

        var tvCount: TextView = findViewById(R.id.tvCount)
        if (tvCount.text == "Hello World!") {
            tvCount.text = "1"
        }


        btnRoll.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        Toast.makeText(this, "버튼을 클릭하였습니다.", Toast.LENGTH_SHORT).show()

        val randomInt1 = getRandomDiceImage()
        val randomInt2 = getRandomDiceImage()

//        val resultText: TextView = findViewById(R.id.tvCount)
//        resultText.text = randomInt1.toString()

        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)

        val drawableResource1 = when (randomInt1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (randomInt2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }


        diceImage1.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)
    }

    private fun getRandomDiceImage() : Int {
        return (1..6).random()
    }
}