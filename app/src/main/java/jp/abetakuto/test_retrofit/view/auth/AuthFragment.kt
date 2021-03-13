package jp.abetakuto.test_retrofit.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import jp.abetakuto.test_retrofit.R
import jp.abetakuto.test_retrofit.viewmodel.MainViewModel

@AndroidEntryPoint
class AuthFragment : Fragment() {
    val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_auth, container, false)
        viewModel.statusFlow.observe(viewLifecycleOwner, {
            when (it) {
                "initialized" -> findNavController().navigate(R.id.action_authFragment_to_firstFragment)
                "uninitialized" ->
                    view.findViewById<Button>(R.id.submit).setOnClickListener {
                        findNavController().navigate(R.id.action_authFragment_to_firstFragment)
                    }
            }
        })

        return view
    }
}