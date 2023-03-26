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
        viewModelScope.launch {
            favouritesRepository.deleteAllFavouriteQuotations()
        }
    }

    fun deleteQuotationAtPosition(position: Int) {
        viewModelScope.launch {
            favouriteQuotations.value?.toMutableList()?.get(position)?.let {
                favouritesRepository.deleteFavouriteQuotation(it)
            }
        }
    }
}