package dadm.jramrib.kotlinsentences.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import dadm.jramrib.kotlinsentences.R
import dadm.jramrib.kotlinsentences.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MenuProvider {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val navController = binding.fragmentContainerView.getFragment<NavHostFragment>().navController

        binding.bottomNavigationView as NavigationBarView
        binding.bottomNavigationView.setupWithNavController(navController)

        setSupportActionBar(binding.materialToolBar)

        var appBarConfiguration = AppBarConfiguration(setOf(R.id.newQuotationFragment, R.id.favouritesFragment, R.id.settingsFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)

        addMenuProvider(this)
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_about, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.aboutDialogFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.aboutDialogFragment)
                true
            }
            else -> false
        }
    }

}