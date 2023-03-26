package dadm.jramrib.kotlinsentences.data.newquotation

import dadm.jramrib.kotlinsentences.data.newquotation.model.toDomain
import dadm.jramrib.kotlinsentences.domain.model.Quotation
import dadm.jramrib.kotlinsentences.utils.NoInternetException
import javax.inject.Inject

class NewQuotationRepositoryImpl @Inject constructor(
    var newQuotationDataSource: NewQuotationDataSource,
    var connectivityChecker: ConnectivityChecker
): NewQuotationRepository {
    override suspend fun getNewQuotation(): Result<Quotation> {
        return if (connectivityChecker.isConnectionAvailable()) {
            newQuotationDataSource.getQuotation(arrayOf("en", "ru", "xx").random()).toDomain()
        } else {
            Result.failure(NoInternetException())
        }
    }
}