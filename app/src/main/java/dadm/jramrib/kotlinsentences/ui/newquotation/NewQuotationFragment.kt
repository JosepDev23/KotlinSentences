package dadm.jramrib.kotlinsentences.ui.newquotation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dadm.jramrib.kotlinsentences.R
import dadm.jramrib.kotlinsentences.databinding.FragmentNewQuotationBinding

class NewQuotationFragment:  Fragment(R.layout.fragment_new_quotation){
    var _binding: FragmentNewQuotationBinding? = null
    val binding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewQuotationBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}