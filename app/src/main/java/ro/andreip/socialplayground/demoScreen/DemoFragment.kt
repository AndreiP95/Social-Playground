package ro.andreip.socialplayground.demoScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import ro.andreip.socialplayground.R
import ro.andreip.socialplayground.databinding.LayoutDemoFragmentBinding

class DemoFragment : Fragment() {

    private val viewModel by lazy {
        DemoViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewDataBinding: LayoutDemoFragmentBinding = DataBindingUtil
            .inflate(layoutInflater, R.layout.layout_demo_fragment, container, false)
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        viewDataBinding.viewModel = viewModel
        return viewDataBinding.root
    }

}