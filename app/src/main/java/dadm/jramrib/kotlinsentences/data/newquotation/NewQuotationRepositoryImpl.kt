package dadm.jramrib.kotlinsentences.data.newquotation

import dadm.jramrib.kotlinsentences.domain.model.Quotation
import javax.inject.Inject

class NewQuotationRepositoryImpl @Inject constructor(): NewQuotationRepository {
    override suspend fun getNewQuotation(): Result<Quotation> {
        val num = (0..9).random();
        return if (num < 9) {
            Result.success(Quotation(num.toString(), "Quotation text #$num", "Author #$num"))
        } else {
            Result.failure(Exception("Cumlord"))
        }
    }
}