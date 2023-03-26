package dadm.jramrib.kotlinsentences.data.newquotation

import dadm.jramrib.kotlinsentences.data.newquotation.model.toDomain
import dadm.jramrib.kotlinsentences.domain.model.Quotation
import dadm.jramrib.kotlinsentences.utils.NoInternetException
import javax.inject.Inject

class NewQuotationRepositoryImpl @Inject constructor(
    var newQuotationDataSource: NewQuotationDataSource,
    var connectivityChecker: ConnectivityChecker
): NewQuotationRepository {
    override suspend fun getNewQuotation(language: String): Result<Quotation> {
        return if (connectivityChecker.isConnectionAvailable()) {
            newQuotationDataSource.getQuotation(language).toDomain()
        } else {
            Result.failure(NoInternetException())
        }
    }
}