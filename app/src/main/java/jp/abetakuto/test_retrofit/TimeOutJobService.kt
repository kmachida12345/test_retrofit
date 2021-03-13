package jp.abetakuto.test_retrofit

import android.app.job.JobParameters
import android.app.job.JobService
import androidx.datastore.preferences.core.edit
import dagger.hilt.android.AndroidEntryPoint
import jp.abetakuto.test_retrofit.model.db.ChannelDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class TimeOutJobService : JobService() {

    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + job)

    @Inject
    lateinit var channelDb: ChannelDatabase

    override fun onStartJob(params: JobParameters?): Boolean {
        Timber.d("hogehogehoge onStartJob")
        scope.launch {
            applicationContext.dataStore.edit {
                it[STATUS] = "logged out"
                channelDb.channelDao().deleteAll()
            }
        }

        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        return false
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

}