package dadm.jramrib.kotlinsentences.ui.newquotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import dadm.jramrib.kotlinsentences.domain.model.Quotation

class NewQuotationViewModel: ViewModel() {
    private val _userName = MutableLiveData(getUserName())
    val userName: LiveData<String>
        get() = _userName

    private val _quotation = MutableLiveData<Quotation>()
    val quotation: LiveData<Quotation>
        get() = _quotation

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _isAddButtonVisible = MutableLiveData(false)
    val isAddButtonVisible: LiveData<Boolean>
        get() = _isAddButtonVisible

    val isGreetingsVisible = quotation.map { it.id.isEmpty() }

    private fun getUserName(): String {
        return setOf("Alice", "Bob", "Charlie", "David", "Emma").random()
    }

    fun getNewQuotation() {
        _isLoading.value = true
        val num = (0..99).random().toString();
        _quotation.value = Quotation(num, "Quotation text #$num", "Author #$num")
        _isAddButtonVisible.value = true
        _isLoading.value = false
    }

    fun addToFavourites() {
        _isAddButtonVisible.value = false
    }
}