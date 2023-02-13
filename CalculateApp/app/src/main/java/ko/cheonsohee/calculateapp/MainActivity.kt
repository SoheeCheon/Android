package ko.cheonsohee.calculateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import ko.cheonsohee.calculateapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    // input을 미리 선언
    private var tvInput: TextView? = null
    // 소수점을 찍기위한 함수
    var lastNumeric : Boolean = false
    var lastDot : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Activity에서 사용할 바인딩 클래스 인스턴스 생성
        mBinding= ActivityMainBinding.inflate(layoutInflater)
        // 최상위 뷰를 가져온다.
        setContentView(binding.root)

        tvInput = findViewById(R.id.tvInput)

    }

    fun onDigit(view: View){
        // view는 실제 눌린 버튼의 정보가 들어가 있다.
        // view에는 text 속성이 없으니 button 타입으로 바꿔 가져온다.
        tvInput?.append((view as Button).text)
        lastNumeric = true
    }

    fun onClear(view: View){
        tvInput?.text = ""
    }

    fun onDecimalPoint(view: View){
        // 플래그
        if(lastNumeric && !lastDot){
            tvInput?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperator(view: View){
        // 연산자를 눌렀을 때 숫자가 있는지 확인
        tvInput?.text?.let {
            if (lastNumeric && !isOperatorAdded(it.toString())){
                tvInput?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }
        }
    }

    fun onEqual(view: View) {
        if (lastNumeric) {
            var tvValue = tvInput?.text.toString()
            var prefix = ""
            try {
                if (tvValue.startsWith("-")) {
                    prefix = "-"
                    // -99 이면 99만사용
                    tvValue = tvValue.substring(1)
                }
                if (tvValue.contains("-")) {
                    val splitValue = tvValue.split("-")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    // - 가 있었다면 붙어준다.
                    if(prefix.isNotEmpty()){
                        one = prefix + one
                    }

                    var result = one.toDouble() - two.toDouble()

                    tvInput?.text = removeZeroAfterDot(result.toString())
                }
                else if (tvValue.contains("+")) {
                    val splitValue = tvValue.split("+")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    // - 가 있었다면 붙어준다.
                    if(prefix.isNotEmpty()){
                        one = prefix + one
                    }

                    var result = one.toDouble() + two.toDouble()

                    tvInput?.text = removeZeroAfterDot(result.toString())
                }
                else if (tvValue.contains("*")) {
                    val splitValue = tvValue.split("*")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    // - 가 있었다면 붙어준다.
                    if(prefix.isNotEmpty()){
                        one = prefix + one
                    }

                    var result = one.toDouble() * two.toDouble()

                    tvInput?.text = removeZeroAfterDot(result.toString())
                }
                else if (tvValue.contains("/")) {
                    val splitValue = tvValue.split("/")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    // - 가 있었다면 붙어준다.
                    if(prefix.isNotEmpty()){
                        one = prefix + one
                    }

                    var result = one.toDouble() / two.toDouble()

                    tvInput?.text = removeZeroAfterDot(result.toString())
                }


            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }
        }
    }

    // 숫자 뒤에 소수점을 삭제
    private fun removeZeroAfterDot(result: String): String {
        var value = result
        if(value.contains(".0"))
            value = result.substring(0, result.length - 2)

        return value
    }

    // textView의 text
    private fun isOperatorAdded(value: String) : Boolean{
        return if(value.startsWith("-")){
            false
        }else{
            value.contains("/") || value.contains("*") || value.contains("+") || value.contains("-")
        }
    }
}