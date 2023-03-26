package dadm.jramrib.kotlinsentences.ui.newquotation

import androidx.lifecycle.*
import dadm.jramrib.kotlinsentences.data.newquotation.NewQuotationRepository
import dadm.jramrib.kotlinsentences.domain.model.Quotation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewQuotationViewModel @Inject constructor(
    var newQuotationRepository: NewQuotationRepository
): ViewModel() {
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

    private val _repositoryError = MutableLiveData<Throwable?>()
    val repositoryError: LiveData<Throwable?>
        get() = _repositoryError

    val isGreetingsVisible = quotation.map { it.id.isEmpty() }

    private fun getUserName(): String {
        return setOf("Alice", "Bob", "Charlie", "David", "Emma").random()
    }

    fun getNewQuotation() {
        _isLoading.value = true

        viewModelScope.launch {
            newQuotationRepository.getNewQuotation().fold(
                onSuccess = { _quotation.value = it },
                onFailure = { _repositoryError.value = it }
            )
        }

        _isAddButtonVisible.value = true
        _isLoading.value = false
    }

    fun addToFavourites() {
        _isAddButtonVisible.value = false
    }

    fun resetError() {
        _repositoryError.value = null
    }
}