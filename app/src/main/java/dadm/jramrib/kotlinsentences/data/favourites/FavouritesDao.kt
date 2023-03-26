package dadm.jramrib.kotlinsentences.data.favourites

import androidx.room.*
import dadm.jramrib.kotlinsentences.data.favourites.FavouritesContract.entries.COLUMN_ID
import dadm.jramrib.kotlinsentences.data.favourites.FavouritesContract.entries.TABLE_FAVOURITES
import dadm.jramrib.kotlinsentences.data.favourites.model.QuotationDto
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun postFavouriteQuotation(quotationDto: QuotationDto)

    @Delete
    suspend fun deleteFavouriteQuotation(quotationDto: QuotationDto)

    @Query("SELECT * FROM $TABLE_FAVOURITES")
    fun getAllFavouriteQuotations(): Flow<List<QuotationDto>>

    @Query("SELECT * FROM $TABLE_FAVOURITES WHERE $COLUMN_ID = :id")
    fun getFavouriteQuotationById(id: String): Flow<QuotationDto?>

    @Query("DELETE FROM $TABLE_FAVOURITES")
    suspend fun deleteAllFavouriteQuotations()
}