package dadm.jramrib.kotlinsentences.ui.favourites

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import dadm.jramrib.kotlinsentences.R

class DeleteAllDialogFragment: DialogFragment() {

    private val viewModel: FavouritesViewModel by activityViewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle(getString(R.string.deleteFavouriteQuotationsAlertTitle))
        alertDialog.setMessage(getString(R.string.deleteFavouriteQuotationsAlertMessage))
        alertDialog.setPositiveButton(getString(R.string.delete)) { _, _ ->
            viewModel.deleteAllQuotations()
        }
        alertDialog.setNegativeButton(getString(R.string.cancel)) { _, _ ->
            dismiss()
        }
        return alertDialog.create()
    }
}