package dadm.jramrib.kotlinsentences.ui.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dadm.jramrib.kotlinsentences.domain.model.Quotation

class FavouritesViewModel: ViewModel() {

    private val _favList = MutableLiveData(getFavouriteQuotations())
    val favList: LiveData<List<Quotation>>
        get() = _favList

    private fun getFavouriteQuotations(): List<Quotation> {
        val favouriteQuotations = mutableListOf<Quotation>()
        for (i in 0..19) {
            val randNumber = (0..99).random().toString()
            favouriteQuotations.add(Quotation(randNumber, "Quotation text #$randNumber", "Author #$randNumber"))
        }
        return favouriteQuotations
    }
}