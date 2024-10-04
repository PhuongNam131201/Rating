package com.example.rating

import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.app.AlertDialog
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val button = findViewById<Button>(R.id.button)
        val ratingScale = findViewById<TextView>(R.id.textView)
        
        ratingBar.setOnRatingBarChangeListener { rBar, fl, b ->
            ratingScale.text= fl.toString()
            when(rBar.rating.toInt()){
                0 -> ratingScale.text = "Rất Tệ"
                1 -> ratingScale.text = "Rất thất vọng"
                2 -> ratingScale.text = "Không hài lòng"
                3 -> ratingScale.text = "Tạm được"
                4 -> ratingScale.text = "Hài lòng"
                5 -> ratingScale.text = "Rất hài lòng"
                else -> ratingScale.text = " "
            }
        }
        button.setOnClickListener{
            val message = ratingBar.rating.toString()
            showAlert("Cảm ơn bạn đã đánh giá $message/5.0 ")
        }

    }
    private fun showAlert(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Đánh giá thành công!!")
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        val dialog = builder.create()
        dialog.show()
    }
}