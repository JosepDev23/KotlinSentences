package dadm.jramrib.kotlinsentences.di

import dadm.jramrib.kotlinsentences.data.newquotation.NewQuotationDataSource
import dadm.jramrib.kotlinsentences.data.newquotation.NewQuotationDataSourceImpl
import dadm.jramrib.kotlinsentences.data.newquotation.NewQuotationRepository
import dadm.jramrib.kotlinsentences.data.newquotation.NewQuotationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NewQuotationBinderModule {

    @Binds
    abstract fun bindNewQuotationRepository(
        newQuotationRepositoryImpl: NewQuotationRepositoryImpl
    ): NewQuotationRepository

    @Binds
    abstract fun bindNewQuotationDataSource(
        newQuotationDataSourceImpl: NewQuotationDataSourceImpl
    ): NewQuotationDataSource

}