package dadm.jramrib.kotlinsentences.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dadm.jramrib.kotlinsentences.R
import dadm.jramrib.kotlinsentences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}