package dadm.jramrib.kotlinsentences.ui.newquotation

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import dadm.jramrib.kotlinsentences.R
import dadm.jramrib.kotlinsentences.databinding.FragmentNewQuotationBinding

class NewQuotationFragment: Fragment(R.layout.fragment_new_quotation), MenuProvider {
    private var _binding: FragmentNewQuotationBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel: NewQuotationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewQuotationBinding.bind(view)

        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        binding.swipeToRefresh.setOnRefreshListener { viewModel.getNewQuotation() }

        viewModel.userName.observe(viewLifecycleOwner) {
            binding.tvGreetings.text = getString(R.string.welcomeMsg, it)
        }

        viewModel.quotation.observe(viewLifecycleOwner) {
            binding.tvQuotationText.text = it.text
            if (it.author == "") {
                binding.tvQuotationAuthor.text = getString(R.string.anonymous)
            } else {
                binding.tvQuotationAuthor.text = it.author
            }
        }

        viewModel.isGreetingsVisible.observe(viewLifecycleOwner) {
            binding.tvGreetings.isVisible = it
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.swipeToRefresh.isRefreshing = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_new_quotation, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.refresh -> {
                viewModel.getNewQuotation()
                true
            } else -> {
                false
            }
        }
    }
}