package jp.ac.it_college.std.s22002.fragmentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.ac.it_college.std.s22002.fragmentsample.databinding.FragmentMenuListBinding
import jp.ac.it_college.std.s22002.fragmentsample.databinding.FragmentMenuThanksBinding
import kotlinx.coroutines.supervisorScope

internal const val ARG_NAME = "menuName"
internal const val ARG_PRICE = "menuPrice"

/**
 *
 */
class MenuThanksFragment : Fragment() {
    private var _binding: FragmentMenuThanksBinding? = null
    private  val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuThanksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuName = arguments?.getString(ARG_NAME) ?: ""
        val menuPrice = arguments?. getInt(ARG_PRICE) ?: 0

        //binding.tvMenuName.text = menuName
        binding.tvThxMenu.text = menuName
        //binding.tvMenuPrice.text = "%,d".format(menuPrice)
        binding.tvMenuPrice.text = "%,d".format(menuPrice)

        //binding.btThxBack.setonClickListener(::onBackButtonClick)
        binding.btThxBack.setOnClickListener(::onBackButtonClick)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onBackButtonClick(v: View){
        parentFragmentManager.popBackStack()

    }
}
