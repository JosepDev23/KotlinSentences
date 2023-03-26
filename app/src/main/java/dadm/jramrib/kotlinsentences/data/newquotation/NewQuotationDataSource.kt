package dadm.jramrib.kotlinsentences.data.newquotation

import dadm.jramrib.kotlinsentences.data.newquotation.model.QuotationDto
import retrofit2.Response

interface NewQuotationDataSource {
    suspend fun getQuotation(language: String): Response<QuotationDto>
}