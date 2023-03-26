package dadm.jramrib.kotlinsentences.data.newquotation.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class QuotationDto(
    val quoteText: String,
    val quoteAuthor: String,
    val senderName: String,
    val quoteLink: String
) {
}