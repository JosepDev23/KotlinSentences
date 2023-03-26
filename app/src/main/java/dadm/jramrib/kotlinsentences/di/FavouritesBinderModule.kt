package dadm.jramrib.kotlinsentences.di

import dadm.jramrib.kotlinsentences.data.favourites.FavouritesDataSource
import dadm.jramrib.kotlinsentences.data.favourites.FavouritesDataSourceImpl
import dadm.jramrib.kotlinsentences.data.favourites.FavouritesRepository
import dadm.jramrib.kotlinsentences.data.favourites.FavouritesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FavouritesBinderModule {

    @Binds
    abstract fun bindFavouritesDataSource(favouritesDataSourceImpl: FavouritesDataSourceImpl): FavouritesDataSource

    @Binds
    abstract fun bindFavouritesRepository(favouritesRepositoryImpl: FavouritesRepositoryImpl): FavouritesRepository

}