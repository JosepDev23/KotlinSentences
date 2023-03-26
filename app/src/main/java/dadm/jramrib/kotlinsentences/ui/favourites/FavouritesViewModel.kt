package dadm.jramrib.kotlinsentences.ui.favourites

import androidx.lifecycle.*
import dadm.jramrib.kotlinsentences.data.favourites.FavouritesRepository
import dadm.jramrib.kotlinsentences.domain.model.Quotation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(
    private val favouritesRepository: FavouritesRepository
): ViewModel() {

    val favouriteQuotations: LiveData<List<Quotation>>
        get() = favouritesRepository.getAllFavouriteQuotations().asLiveData()

    val isDeleteAllVisible = favouriteQuotations.map() { it.isNotEmpty() }

    fun deleteAllQuotations() {
    }

    fun deleteQuotationAtPosition(position: Int) {
    }
}