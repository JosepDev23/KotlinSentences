package dadm.jramrib.kotlinsentences.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dadm.jramrib.kotlinsentences.R
import dadm.jramrib.kotlinsentences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val navController = binding.fragmentContainerView.getFragment<NavHostFragment>().navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }



}