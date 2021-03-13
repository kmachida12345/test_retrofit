package jp.abetakuto.test_retrofit.view

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import jp.abetakuto.test_retrofit.R
import jp.abetakuto.test_retrofit.TimeOutJobService
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

        val adapter = MainViewAdapter()
        view.findViewById<RecyclerView>(R.id.recyclerView).also {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = adapter
        }

        viewModel.channels.observe(viewLifecycleOwner, {
            adapter.updateData(it)
        })

        viewModel.statusFlow.observe(viewLifecycleOwner, {
            Timber.d("hogeeeeee $it")
            when (it) {
                "uninitialized" -> viewModel.fetchChannels()
                "initialized" -> Timber.d("hoge database has already been initialized")
                else -> Timber.e("an error occurred")
            }
        })

        Timber.d("onCreateView: end")
        return view
    }

    override fun onStop() {
        super.onStop()

        val jobScheduler =
            requireContext().getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        val job = JobInfo.Builder(
            0,
            ComponentName(requireContext(), TimeOutJobService::class.java)
        )
            .setMinimumLatency(5000)
            .setOverrideDeadline(10000)
            .build()
        jobScheduler.schedule(job)
    }
}