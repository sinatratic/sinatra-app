package co.listdetail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import co.listdetail.R
import co.listdetail.viewmodel.ContactViewModel

/**
 * A simple [Fragment] subclass.
 */
class high_line : Fragment() {

    private lateinit var model: ContactViewModel
    private lateinit var nameView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.high_line, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameView = view.findViewById(R.id.name_text)
        model = ViewModelProvider(requireActivity()).get(ContactViewModel::class.java)
        observeLiveData()
    }

    private fun observeLiveData() {
        model.getSelected().observe(viewLifecycleOwner, { contact ->
            val fullName = "Su nombre es: \n${contact.firstName} ${contact.lastName}"
            nameView.text = fullName
        })
    }
}
