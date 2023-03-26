package dadm.jramrib.kotlinsentences.data.favourites

import dadm.jramrib.kotlinsentences.data.favourites.model.toDomain
import dadm.jramrib.kotlinsentences.data.favourites.model.toDto
import dadm.jramrib.kotlinsentences.domain.model.Quotation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavouritesRepositoryImpl @Inject constructor(
    private val favouritesDataSource: FavouritesDataSource
): FavouritesRepository {

    override suspend fun postFavouriteQuotation(quotation: Quotation) {
        favouritesDataSource.postFavouriteQuotation(quotation.toDto())
    }

    override suspend fun deleteFavouriteQuotation(quotation: Quotation) {
        favouritesDataSource.deleteFavouriteQuotation(quotation.toDto())
    }

    override fun getAllFavouriteQuotations(): Flow<List<Quotation>> {
        return favouritesDataSource.getAllFavouriteQuotations().map { dtos ->
            dtos.map { dto -> dto.toDomain() }
        }
    }

    override fun getFavouriteQuotationById(id: String): Flow<Quotation?> {
        return favouritesDataSource.getFavouriteQuotationById(id).map {
            it?.toDomain()
        }
    }

    override suspend fun deleteAllFavouriteQuotations() {
        favouritesDataSource.deleteAllFavouriteQuotations()
    }
}