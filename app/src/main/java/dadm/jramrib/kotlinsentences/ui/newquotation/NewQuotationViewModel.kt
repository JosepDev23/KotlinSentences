package dadm.jramrib.kotlinsentences.ui.newquotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewQuotationViewModel: ViewModel() {
    private val _mutableUserName = MutableLiveData(getUserName())
    val userName: LiveData<String>
        get() = _mutableUserName

    private fun getUserName(): String {
        return setOf("Alice", "Bob", "Charlie", "David", "Emma").random()
    }
}