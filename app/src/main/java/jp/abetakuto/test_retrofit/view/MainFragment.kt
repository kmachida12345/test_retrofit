package jp.abetakuto.test_retrofit.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import jp.abetakuto.test_retrofit.MainViewAdapter
import jp.abetakuto.test_retrofit.R
import jp.abetakuto.test_retrofit.viewmodel.MainViewModel
import timber.log.Timber

@AndroidEntryPoint
class MainFragment : Fragment() {
    val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView: start")
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        Timber.d("onCreateView: set channelInfoApi")

        Timber.d("onCreateView: set listData")

        Timber.d("onCreateView: set recyclerView")
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        Timber.d("onCreateView: set layoutManager")
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        Timber.d("onCreateView: set MainViewAdapter")
        val adapter = MainViewAdapter()
        recyclerView.adapter = adapter

        viewModel.fetchChannels()

        viewModel.channels.observe(viewLifecycleOwner, {
            adapter.addData(it)
        })

        Timber.d("onCreateView: end")
        return view
    }

}