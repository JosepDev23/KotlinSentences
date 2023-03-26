package dadm.jramrib.kotlinsentences.data.settings

import kotlinx.coroutines.flow.Flow


interface SettingsDataSource {
    fun getUserName(): Flow<String>
}