package dadm.jramrib.kotlinsentences.di

import dadm.jramrib.kotlinsentences.data.settings.SettingsDataSource
import dadm.jramrib.kotlinsentences.data.settings.SettingsDataSourceImpl
import dadm.jramrib.kotlinsentences.data.settings.SettingsRepository
import dadm.jramrib.kotlinsentences.data.settings.SettingsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsBinderModule {

    @Binds
    abstract fun bindSettingsDataSource(settingsDataSourceImpl: SettingsDataSourceImpl) : SettingsDataSource

    @Binds
    abstract fun bindSettingsRepository(settingsRepositoryImpl: SettingsRepositoryImpl) : SettingsRepository
}