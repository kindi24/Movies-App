package net.arx.helloworldarx.ui

import dagger.hilt.android.AndroidEntryPoint
import net.arx.helloworldarx.databinding.ActivityAppBinding
import net.arx.helloworldarx.ui.base.BaseActivity

@AndroidEntryPoint
class AppActivity : BaseActivity<ActivityAppBinding>() {

    override fun getViewBinding(): ActivityAppBinding = ActivityAppBinding.inflate(layoutInflater)
}