package dadm.jramrib.kotlinsentences.ui.favourites

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import dadm.jramrib.kotlinsentences.R
import dadm.jramrib.kotlinsentences.databinding.FragmentFavouritesBinding

class FavouritesFragment: Fragment(R.layout.fragment_favourites), MenuProvider {
    private var _binding: FragmentFavouritesBinding? = null
    val binding
        get() = _binding!!

    private val viewModel: FavouritesViewModel by activityViewModels()

    private val itemTouchHelper =
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.END) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun isLongPressDragEnabled(): Boolean {
                return false
            }

            override fun isItemViewSwipeEnabled(): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel.deleteQuotationAtPosition(viewHolder.adapterPosition)
            }
        })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavouritesBinding.bind(view)

        val adapter = QuotationListAdapter()

        binding.recyclerView.adapter = adapter

        viewModel.favouriteQuotations.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        viewModel.isDeleteAllVisible.observe(viewLifecycleOwner) {
            requireActivity().invalidateMenu()
        }

        itemTouchHelper.attachToRecyclerView(binding.recyclerView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_favourites, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.deleteItem -> {
                DeleteAllDialogFragment().show(childFragmentManager, null)
                true
            } else -> {
                false
            }
        }
    }

    override fun onPrepareMenu(menu: Menu) {
        menu.findItem(R.id.deleteItem).isVisible = viewModel.isDeleteAllVisible.value ?: false
        super.onPrepareMenu(menu)
    }
}