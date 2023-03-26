package dadm.jramrib.kotlinsentences.data.newquotation

import dadm.jramrib.kotlinsentences.data.settings.SettingsRepository
import dadm.jramrib.kotlinsentences.domain.model.Quotation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewQuotationManagerImpl @Inject constructor(
    private val settingsRepository: SettingsRepository,
    private val newQuotationRepository: NewQuotationRepository
): NewQuotationManager {
    private lateinit var language: String

    init {
        CoroutineScope(SupervisorJob()).launch {
            settingsRepository.getLanguage().collect { languageCode ->
                language = languageCode
            }
        }
    }

    override suspend fun getNewQuotation(): Result<Quotation> {
        return newQuotationRepository.getNewQuotation(language)
    }
}