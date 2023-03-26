package dadm.jramrib.kotlinsentences.data.favourites

import dadm.jramrib.kotlinsentences.data.favourites.model.QuotationDto
import kotlinx.coroutines.flow.Flow

interface FavouritesDataSource {

    suspend fun postFavouriteQuotation(quotationDto: QuotationDto)

    suspend fun deleteFavouriteQuotation(quotationDto: QuotationDto)

    fun getAllFavouriteQuotations(): Flow<List<QuotationDto>>

    fun getFavouriteQuotationById(id: String): Flow<QuotationDto?>

    suspend fun deleteAllFavouriteQuotations()

}