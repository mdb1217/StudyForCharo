package co.kr.studyforcharo

import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import co.kr.studyforcharo.databinding.BottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetFragment : BottomSheetDialogFragment() {
    lateinit var binding: BottomSheetDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomSheetDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //이부분임
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            binding.clBds.layoutParams.height =
                requireActivity().windowManager.currentWindowMetrics.bounds.height()
        }
        else
            binding.clBds.layoutParams.height = resources.displayMetrics.heightPixels

        (dialog as BottomSheetDialog).behavior.apply {
            isFitToContents = false
            state = BottomSheetBehavior.STATE_HALF_EXPANDED
        }
    }
}