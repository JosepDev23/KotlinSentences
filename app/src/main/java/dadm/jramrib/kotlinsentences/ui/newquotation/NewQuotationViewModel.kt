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

    val isAddButtonVisible: LiveData<Boolean> = quotation.switchMap() { quotation ->
        favouritesRepository.getFavouriteQuotationById(quotation.id).asLiveData()
    }.map() { favourite -> favourite == null }

    private val _repositoryError = MutableLiveData<Throwable?>()
    val repositoryError: LiveData<Throwable?>
        get() = _repositoryError

    val isGreetingsVisible = quotation.map { it.id.isEmpty() }

    fun getNewQuotation() {
        _isLoading.value = true

        viewModelScope.launch {
            newQuotationManager.getNewQuotation().fold(
                onSuccess = { _quotation.value = it },
                onFailure = { _repositoryError.value = it }
            )
        }

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