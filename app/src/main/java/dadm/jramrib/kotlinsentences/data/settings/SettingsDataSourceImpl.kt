package dadm.jramrib.kotlinsentences.data.settings

import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

class SettingsDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
    ): SettingsDataSource {
    companion object {
        const val KEY_USERNAME = "username"
        const val KEY_LANGUAGE = "language"
    }

    override fun getUserName(): Flow<String> = callbackFlow {
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            launch(Dispatchers.IO) {
                if (KEY_USERNAME == key) {
                    trySend(getUsernamePreference())
                }
            }
        }
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
        trySend(getUsernamePreference())
        awaitClose {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener) }
    }.flowOn(Dispatchers.IO)

    private fun getLanguagePreference() = sharedPreferences.getString(KEY_LANGUAGE, "") ?: ""
    private fun getUsernamePreference() = sharedPreferences.getString(KEY_USERNAME, "") ?: ""
}