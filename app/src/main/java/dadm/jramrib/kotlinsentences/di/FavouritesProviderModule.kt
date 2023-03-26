package dadm.jramrib.kotlinsentences.di

import android.content.Context
import androidx.room.Room
import dadm.jramrib.kotlinsentences.data.favourites.FavouritesContract
import dadm.jramrib.kotlinsentences.data.favourites.FavouritesDao
import dadm.jramrib.kotlinsentences.data.favourites.FavouritesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FavouritesProviderModule {

    @Provides
    @Singleton
    fun provideFavouritesDatabase(@ApplicationContext context: Context): FavouritesDatabase {
        return Room.databaseBuilder(
            context,
            FavouritesDatabase::class.java,
            FavouritesContract.DATABASE
        ).build()
    }

    @Provides
    fun provideFavouritesDao(favouritesDatabase: FavouritesDatabase): FavouritesDao =
        favouritesDatabase.favouritesDao()
}