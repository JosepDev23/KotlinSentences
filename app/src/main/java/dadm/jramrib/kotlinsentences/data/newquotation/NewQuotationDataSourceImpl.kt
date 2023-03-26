package dadm.jramrib.kotlinsentences.data.newquotation

import dadm.jramrib.kotlinsentences.domain.model.Quotation
import javax.inject.Inject

class NewQuotationDataSourceImpl @Inject constructor(): NewQuotationDataSource {
    override suspend fun getQuotation(): Result<Quotation> {
        val num = (0..9).random();
        return if (num < 9) {
            Result.success(Quotation(num.toString(), "Quotation text #$num", "Author #$num"))
        } else {
            Result.failure(Exception("Cumlord"))
        }
    }
}