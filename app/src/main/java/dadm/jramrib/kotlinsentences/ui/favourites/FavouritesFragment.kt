package dadm.jramrib.kotlinsentences.ui.favourites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import dadm.jramrib.kotlinsentences.R
import dadm.jramrib.kotlinsentences.databinding.FragmentFavouritesBinding
import dadm.jramrib.kotlinsentences.databinding.FragmentNewQuotationBinding

class FavouritesFragment: Fragment(R.layout.fragment_favourites){
    private var _binding: FragmentFavouritesBinding? = null
    val binding
        get() = _binding!!

    private val viewModel: FavouritesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavouritesBinding.bind(view)

        val adapter = QuotationListAdapter()

        binding.recyclerView.adapter = adapter

        viewModel.favList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}