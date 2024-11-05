package com.example.moodtracker
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // connecting the id-s with seekbars in activity main xml
        val moodSeekBar = findViewById<SeekBar>(R.id.moodSeekBar)
        val energySeekBar = findViewById<SeekBar>(R.id.energySeekBar)
        val stressSeekBar = findViewById<SeekBar>(R.id.stressSeekBar)
        val confidenceSeekBar = findViewById<SeekBar>(R.id.confidenceSeekBar)
        val healthSeekBar = findViewById<SeekBar>(R.id.healthSeekBar)
        val socialSeekBar = findViewById<SeekBar>(R.id.socialSeekBar)
        val averageTextView = findViewById<TextView>(R.id.averageTextView)
        val submitButton = findViewById<Button>(R.id.submitButton)
        // for setting the colors based on value
        setupScale(moodSeekBar)
        setupScale(energySeekBar)
        setupScale(stressSeekBar)
        setupScale(confidenceSeekBar)
        setupScale(healthSeekBar)
        setupScale(socialSeekBar)
        // after submitting then calculation score of mood
        submitButton.setOnClickListener {
            val mood = moodSeekBar.progress
            val energy = energySeekBar.progress
            val stress = stressSeekBar.progress
            val confidence = confidenceSeekBar.progress
            val health = healthSeekBar.progress
            val social = socialSeekBar.progress
        // calculating the average mood
            val average = (mood + energy + stress + confidence + health + social) / 6.0
            averageTextView.text = "Your mood today: ${"%.2f".format(average)}"

            Toast.makeText(this, "Your mood is saved!", Toast.LENGTH_SHORT).show()
        }
    }
        // live listener of when user is touching the scale
  private fun setupScale(seekBar: SeekBar){
      seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
          override fun onProgressChanged(seekbar: SeekBar, progress: Int, fromUser: Boolean) {
              updateSeekbarColor(seekbar, progress)
          }

          override fun onStartTrackingTouch(seekbar: SeekBar) {}
          override fun onStopTrackingTouch(seekbar: SeekBar) {}
      })
  }
    // 0 until 3 red, 4 until 7 yellow, else green
    private fun updateSeekbarColor(seekbar: SeekBar, value: Int) {
        val color = when (value){
            in 0..3 ->Color.RED
            in 4..7-> Color.YELLOW
            else -> Color.GREEN
        }
        val progressDrawable = seekbar.progressDrawable as LayerDrawable
        val progressLayer = progressDrawable.findDrawableByLayerId(android.R.id.progress)
        progressLayer.setTint(color)

    }
}
