package jp.abetakuto.test_retrofit.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.datastore.preferences.core.edit
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import jp.abetakuto.test_retrofit.R
import jp.abetakuto.test_retrofit.STATUS
import jp.abetakuto.test_retrofit.dataStore
import jp.abetakuto.test_retrofit.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
                "logged out" ->
                    view.findViewById<Button>(R.id.submit).setOnClickListener {
                        lifecycleScope.launch {
                            requireContext().dataStore.edit { status ->
                                status[STATUS] = "uninitialized"
                            }
                            launch(Dispatchers.Main) {
                                findNavController().navigate(R.id.action_authFragment_to_firstFragment)
                            }
                        }
                    }
                "initialized",
                "uninitialized" -> findNavController().navigate(R.id.action_authFragment_to_firstFragment)
            }
        })

        return view
    }
}