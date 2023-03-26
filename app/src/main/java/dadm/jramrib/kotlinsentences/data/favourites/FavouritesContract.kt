package dadm.jramrib.kotlinsentences.data.favourites

object FavouritesContract {
    const val DATABASE = "favourites.db"

    object entries {
        const val TABLE_FAVOURITES = "favourites"
        const val COLUMN_ID = "id"
        const val COLUMN_TEXT = "text"
        const val COLUMN_AUTHOR = "author"
    }
}