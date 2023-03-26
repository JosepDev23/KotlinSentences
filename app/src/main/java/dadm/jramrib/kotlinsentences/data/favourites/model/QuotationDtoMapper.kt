package dadm.jramrib.kotlinsentences.data.favourites.model

import dadm.jramrib.kotlinsentences.domain.model.Quotation

fun QuotationDto.toDomain(): Quotation = Quotation(
    id = id,
    text = text,
    author = author
)

fun Quotation.toDto(): QuotationDto = QuotationDto(
    id = id,
    text = text,
    author = author
)