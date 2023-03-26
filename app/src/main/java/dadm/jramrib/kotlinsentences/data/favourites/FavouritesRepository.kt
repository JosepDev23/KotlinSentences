package dadm.jramrib.kotlinsentences.data.favourites

import dadm.jramrib.kotlinsentences.domain.model.Quotation
import kotlinx.coroutines.flow.Flow

interface FavouritesRepository {

    suspend fun postFavouriteQuotation(quotation: Quotation)

    suspend fun deleteFavouriteQuotation(quotation: Quotation)

    fun getAllFavouriteQuotations(): Flow<List<Quotation>>

    fun getFavouriteQuotationById(id: String): Flow<Quotation?>

    suspend fun deleteAllFavouriteQuotations()

}