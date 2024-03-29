package dadm.jramrib.kotlinsentences.data.newquotation

import dadm.jramrib.kotlinsentences.domain.model.Quotation

interface NewQuotationRepository {
    suspend fun getNewQuotation(language: String): Result<Quotation>
}