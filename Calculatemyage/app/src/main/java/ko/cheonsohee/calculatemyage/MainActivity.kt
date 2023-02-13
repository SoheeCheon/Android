package ko.cheonsohee.calculatemyage

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import ko.cheonsohee.calculatemyage.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    private var tvSelectedDate: TextView? = null
    private var tvAgeInMinutes: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvAgeInMinutes = findViewById(R.id.tvAgeInMinutes)

        btnDatePicker.setOnClickListener {
            clickDatePicker()

        }
    }

    private fun clickDatePicker() {
        // 캘린터 인스턴스를 가져옴
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        // 년도, 월, 일이 필요하다
        val dpd = DatePickerDialog(this,
            /* DatePicker가 전달한 매개 변수
               DatePickerDialog.OnDateSetListener은 삭제해도 된다.
               코드 내부적으로 해당 코드가 어떤 내용인지 알고 있다. */
            DatePickerDialog.OnDateSetListener{ _, selectedYear, selectedMonth, selectedDayOfMonth ->
                // 날짜를 선택한 경우에만 표시됨
                Toast.makeText(this, "Year was $selectedYear, Month was ${selectedMonth + 1}, day of month was $selectedDayOfMonth", Toast.LENGTH_LONG).show()

                // 텍스트 뷰의 날짜 설정
                val selectedDate = "$selectedYear/${selectedMonth+1}/$selectedDayOfMonth"
                tvSelectedDate?.setText(selectedDate)

                // SimpleDateFormat: 날짜에 사용할 패턴을 지정
                val sdf = SimpleDateFormat("yyyy/MM/dd", Locale.KOREA)
                // 날짜를 형식으로 전환
                val theDate = sdf.parse(selectedDate)

                // null 안정성: let은 날짜 선택여부를 확인하고 코드가 실행된다.
                theDate?.let{
                    // 시간계산
                    // time은 1970.01.01부터 지난 시간을 ms 단위로 알려준다.
                    val selectedDateInMinutes = theDate.time / 60000
                    // 현재 시간을 계산
                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    currentDate?.let{
                        val currentDateInMinutes = currentDate.time / 60000

                        val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes
                        // 시간 차이를 넣어준다.
                        tvAgeInMinutes?.text = differenceInMinutes.toString()
                    }
                }
            },
            year,
            month,
            day
        )
        // 최대 날짜는 현재시간에서 하루치를 빼준다.
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()
    }
}