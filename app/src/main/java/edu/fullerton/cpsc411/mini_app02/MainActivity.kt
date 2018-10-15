package edu.fullerton.cpsc411.mini_app02

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

import java.util.Locale.US

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val defaultListener = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val notEmpty : TextView.() -> Boolean = { text.isNotEmpty() }

                if (notEmpty(FileSizeInput) and notEmpty(NetworkSpeedInput)) {
                    val speed= java.lang.Double.valueOf(NetworkSpeedInput.text.toString())
                    val size = java.lang.Double.valueOf(FileSizeInput.text.toString())

                    if (size == 0.0) Result.text = getString(R.string.invalid_input)
                    else {
                        val output = Result.toOneDec(Result.cal(speed, size)) + " seconds"
                        Result.text = output
                    }
                } else {
                    val time = Result.toOneDec(Result.cal(100.0, 100.0)) + " seconds"
                    Result.text = time
                }
            }

        }
        NetworkSpeedInput.addTextChangedListener(defaultListener)
        FileSizeInput.addTextChangedListener(defaultListener)
    }

    private fun TextView.cal(networkSpeed: Double?, fileSize: Double?): Double {
        return networkSpeed!! * Math.pow(2.0, 20.0) * 8.0 / (fileSize!! * Math.pow(10.0, 6.0))
    }

    private fun TextView.toOneDec(num: Double?): String {
        return String.format(US, "%.1f", num)
    }
}
