package com.binar.challange3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_third.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arguments?.getParcelable<DataPerson>("DATA")
        txtNama.text = "Halo, " + data?.nama
        if (data!!.usia.equals(0)){

        }else{
            txtUsia.visibility = View.VISIBLE
            txtAlamat.visibility = View.VISIBLE
            txtPekerjaan.visibility = View.VISIBLE
            val ganjilGenap = data.usia % 2
            if (ganjilGenap.equals(0)){
                txtUsia.text = "Usia anda " + data.usia.toString() + ", Umur anda Genap"
            }else{
                txtUsia.text = "Usia anda " + data.usia.toString() + ", Umur anda Ganjil"

            }

            txtAlamat.text = "Alamat anda " + data.alamat.toString()
            txtPekerjaan.text = "Pekerjaan anda " + data.pekerjaan.toString()
        }

        goto4.setOnClickListener {
            val data1 = bundleOf("DATA" to data.nama)

            Navigation.findNavController(view).navigate(R.id.action_thirdFragment_to_fourthFragment, data1)

        }


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ThirdFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}