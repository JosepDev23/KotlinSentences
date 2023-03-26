package dadm.jramrib.kotlinsentences.data.favourites

import dadm.jramrib.kotlinsentences.data.favourites.model.QuotationDto
import dadm.jramrib.kotlinsentences.domain.model.Quotation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavouritesDataSourceImpl @Inject constructor(
    private val favouritesDao: FavouritesDao
): FavouritesDataSource {

    override suspend fun postFavouriteQuotation(quotationDto: QuotationDto) {
        favouritesDao.postFavouriteQuotation(quotationDto)
    }

    override suspend fun deleteFavouriteQuotation(quotationDto: QuotationDto) {
        favouritesDao.deleteFavouriteQuotation(quotationDto)
    }

    override fun getAllFavouriteQuotations(): Flow<List<QuotationDto>> {
        return favouritesDao.getAllFavouriteQuotations()
    }

    override fun getFavouriteQuotationById(id: String): Flow<QuotationDto?> {
        return favouritesDao.getFavouriteQuotationById(id)
    }

    override suspend fun deleteAllFavouriteQuotations() {
        favouritesDao.deleteAllFavouriteQuotations()
    }
}