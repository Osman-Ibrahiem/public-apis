package com.fawry.publicapis.ui.phone

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.fawry.publicapis.databinding.DialogPhoneBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PhoneDialog : DialogFragment() {

    private var _binding: DialogPhoneBinding? = null
    private val binding get() = _binding!!

    private val args: PhoneDialogArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogPhoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnShare.setOnClickListener {
            if (binding.inputText.text.toString().isEmpty()) {
                binding.inputLayout.error = "Please enter mobile number"
                return@setOnClickListener
            }

            val phone = binding.inputText.text.toString()
            if (!Regex("^01[0125][0-9]{8}\$\n").matches(phone)) {
                binding.inputLayout.error = "Please enter a valid mobile number"
                return@setOnClickListener
            }

            shareToWhatsApp(phone)

        }
    }

    private fun shareToWhatsApp(phone: String) {
        val url =
            "https://api.whatsapp.com/send?phone=${phone}&text=${args.link}"

        val intent = Intent(Intent.ACTION_VIEW).apply {
            this.data = Uri.parse(url)
            this.`package` = "com.whatsapp"
        }

        try {
            startActivity(intent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(requireContext(), "Whatsapp have not been installed.", Toast.LENGTH_LONG)
                .show()
        } finally {
            findNavController().navigateUp()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}