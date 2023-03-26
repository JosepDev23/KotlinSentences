package dadm.jramrib.kotlinsentences.data.newquotation

import dadm.jramrib.kotlinsentences.domain.model.Quotation
import javax.inject.Inject

class NewQuotationRepositoryImpl @Inject constructor(
    var newQuotationDataSource: NewQuotationDataSource
): NewQuotationRepository {
    override suspend fun getNewQuotation(): Result<Quotation> {
        return newQuotationDataSource.getQuotation()
    }
}