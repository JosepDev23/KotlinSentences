package dadm.jramrib.kotlinsentences.data.favourites.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dadm.jramrib.kotlinsentences.data.favourites.FavouritesContract.entries.COLUMN_AUTHOR
import dadm.jramrib.kotlinsentences.data.favourites.FavouritesContract.entries.COLUMN_ID
import dadm.jramrib.kotlinsentences.data.favourites.FavouritesContract.entries.COLUMN_TEXT
import dadm.jramrib.kotlinsentences.data.favourites.FavouritesContract.entries.TABLE_FAVOURITES

@Entity(tableName = TABLE_FAVOURITES)
data class QuotationDto(
    @PrimaryKey
    @ColumnInfo(name = COLUMN_ID)
    val id: String,

    @ColumnInfo(name = COLUMN_TEXT)
    val text: String,

    @ColumnInfo(name = COLUMN_AUTHOR)
    val author: String
)
