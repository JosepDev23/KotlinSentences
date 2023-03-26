package dadm.jramrib.kotlinsentences.data.newquotation

import dadm.jramrib.kotlinsentences.domain.model.Quotation

interface NewQuotationDataSource {
    suspend fun getQuotation(): Result<Quotation>
}