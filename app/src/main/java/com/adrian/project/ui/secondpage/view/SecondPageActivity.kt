package com.adrian.project.ui.secondpage.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.adrian.project.BR
import com.adrian.project.R
import com.adrian.project.databinding.ActivitySecondPageBinding
import com.adrian.project.ui.secondpage.viewmodel.SecondPageViewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class SecondPageActivity : AppCompatActivity(), HasSupportFragmentInjector {

    companion object {
        val TAG = SecondPageActivity::class.java.simpleName
    }

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var secondPageViewModel: SecondPageViewModel

    lateinit var binding: ActivitySecondPageBinding

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        bind()

//        secondPageViewModel.editText.value = "asdasd"
//
//        secondPageViewModel.editText.observe(this, Observer {
//            it.let { secondPageViewModel.text.value = it.toString() }
//        })
    }

    fun bind() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding?.viewModel = this.secondPageViewModel
        binding?.executePendingBindings()
    }

    fun getLayoutId() = R.layout.activity_second_page

    fun getVariableId(): Int {
        return BR.viewModel
    }
}
