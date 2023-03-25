package dadm.jramrib.kotlinsentences.ui.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import dadm.jramrib.kotlinsentences.domain.model.Quotation

class FavouritesViewModel: ViewModel() {

    private val _favouriteQuotations = MutableLiveData(getFavouriteQuotations())
    val favouriteQuotations: LiveData<List<Quotation>>
        get() = _favouriteQuotations

    val isDeleteAllVisible = favouriteQuotations.map() { it.isNotEmpty() }

    private fun getFavouriteQuotations(): List<Quotation> {
        val favouriteQuotations = mutableListOf<Quotation>()
        for (i in 0..19) {
            val randNumber = (0..99).random().toString()
            favouriteQuotations.add(Quotation(randNumber, "Quotation text #$randNumber", "Author #$randNumber"))
        }
        return favouriteQuotations
    }

    fun deleteAllQuotations() {
        _favouriteQuotations.value = emptyList()
    }

    fun deleteQuotationAtPosition(position: Int) {
        val newFafouriteQuotations = _favouriteQuotations.value?.toMutableList()
        newFafouriteQuotations?.removeAt(position)
        _favouriteQuotations.value = newFafouriteQuotations!!
    }
}