package dadm.jramrib.kotlinsentences.data.settings

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    fun getUsername(): Flow<String>

    fun getLanguage(): Flow<String>

}