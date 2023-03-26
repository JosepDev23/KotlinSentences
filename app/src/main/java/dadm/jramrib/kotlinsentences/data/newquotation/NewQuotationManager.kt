package dadm.jramrib.kotlinsentences.data.newquotation

import dadm.jramrib.kotlinsentences.domain.model.Quotation

interface NewQuotationManager {
    suspend fun getNewQuotation(): Result<Quotation>
}