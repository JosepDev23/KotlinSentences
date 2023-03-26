package dadm.jramrib.kotlinsentences.ui.newquotation

import androidx.lifecycle.*
import dadm.jramrib.kotlinsentences.data.favourites.FavouritesRepository
import dadm.jramrib.kotlinsentences.data.newquotation.NewQuotationManager
import dadm.jramrib.kotlinsentences.data.newquotation.NewQuotationRepository
import dadm.jramrib.kotlinsentences.data.settings.SettingsRepository
import dadm.jramrib.kotlinsentences.domain.model.Quotation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewQuotationViewModel @Inject constructor(
    settingsRepository: SettingsRepository,
    var newQuotationManager: NewQuotationManager,
    var favouritesRepository: FavouritesRepository
): ViewModel() {
    val userName: LiveData<String> = settingsRepository.getUsername().asLiveData()

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
            newQuotationManager.getNewQuotation().fold(
                onSuccess = { _quotation.value = it },
                onFailure = { _repositoryError.value = it }
            )
        }

        _isAddButtonVisible.value = true
        _isLoading.value = false
    }

    fun addToFavourites() {
        viewModelScope.launch {
            try {
                favouritesRepository.postFavouriteQuotation(quotation.value!!)
            } catch (e: Exception) {
                _repositoryError.value = e
            }
        }
    }

    fun resetError() {
        _repositoryError.value = null
    }
}