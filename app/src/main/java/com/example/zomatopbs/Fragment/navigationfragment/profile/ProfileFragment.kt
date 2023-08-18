package com.example.zomatopbs.Fragment.navigationfragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.zomatopbs.Fragment.navigationfragment.delivery.FeedingIndiaFragment
import com.example.zomatopbs.MainActivity
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentProfileBinding
import com.example.zomatopbs.objects.Allfun
import com.example.zomatopbs.objects.MyConstant


class ProfileFragment : Fragment() {
    private  lateinit var binding : FragmentProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backBtnProfile.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.likeBtn.setOnClickListener {
            findNavController().navigate(R.id.likesFragment)
        }
        binding.paymentBtn.setOnClickListener {
            findNavController().navigate(R.id.paymentMethodFragment)

        }
        binding.settingBtn.setOnClickListener {
            findNavController().navigate(R.id.settingsFragment)

        }
        binding.yourrating.setOnClickListener {
            findNavController().navigate(R.id.addReviewFragment)

        }
        binding.viewActivity.setOnClickListener {
            findNavController().navigate(R.id.viewActivityFragment)
        }
        binding.editprofile.setOnClickListener {
            findNavController().navigate(R.id.editYourProfileFragment)
        }
        binding.yourorders.setOnClickListener {
            findNavController().navigate(R.id.orderHistoryFragment)
        }
        binding.addressbook.setOnClickListener {
            findNavController().navigate(R.id.selectLocationFragment)
        }
        binding.foodorderinghelp.setOnClickListener {
            findNavController().navigate(R.id.supportMessengerFragment)
        }
        binding.editionWallet.setOnClickListener {
            findNavController().navigate(R.id.editionWalletFragment)
        }
        binding.editionfaqs.setOnClickListener {
            findNavController().navigate(R.id.editionWalletFaqsFragment)
        }
        binding.possibilityGold.setOnClickListener {
            findNavController().navigate(R.id.possibilityGoldFragment)
//            Toast.makeText(requireContext(), "underdevelopment", Toast.LENGTH_SHORT).show()
        }
         binding.yourOrders1.setOnClickListener {
            findNavController().navigate(R.id.orderHistory1Fragment)
            Toast.makeText(requireContext(), "underdevelopment", Toast.LENGTH_SHORT).show()
        }
         binding.groceryOrderingHelp.setOnClickListener {
//            findNavController().navigate(R.id.editionWalletFaqsFragment)
            Toast.makeText(requireContext(), "underdevelopment", Toast.LENGTH_SHORT).show()
        }
         binding.yourTransaction.setOnClickListener {
            findNavController().navigate(R.id.yourTransactionsFragment)

        }
         binding.diningReward.setOnClickListener {
            findNavController().navigate(R.id.yourDiningRewardFragment)
            Toast.makeText(requireContext(), "underdevelopment", Toast.LENGTH_SHORT).show()
        }
         binding.tableReservation.setOnClickListener {
            findNavController().navigate(R.id.tableBookingFragment)
            Toast.makeText(requireContext(), "underdevelopment", Toast.LENGTH_SHORT).show()
        }
        binding.sendingFeedback.setOnClickListener {
            findNavController().navigate(R.id.feedBackFragment)
            Toast.makeText(requireContext(), "underdevelopment", Toast.LENGTH_SHORT).show()
        }
        binding.aboutfr.setOnClickListener {
            findNavController().navigate(R.id.aboutFragment)
        }

        binding.reportsafetyfragment.setOnClickListener {
            findNavController().navigate(R.id.reportSafetyEmergencyFragment)
            Toast.makeText(requireContext(), "underdevelopment", Toast.LENGTH_SHORT).show()
        }
         binding.feedingIndiaReceipt.setOnClickListener {
//            findNavController().navigate(R.id.editionWalletFaqsFragment)
             FeedingIndiaFragment().show(requireFragmentManager(),MyConstant.tag)
            Toast.makeText(requireContext(), "underdevelopment", Toast.LENGTH_SHORT).show()
        }
         binding.logoutuser.setOnClickListener {
            LogOutFragment().show(requireFragmentManager(),MyConstant.tag)

            Toast.makeText(requireContext(), "underdevelopment", Toast.LENGTH_SHORT).show()
        }

        binding.Creditzomato.setOnClickListener {

            findNavController().navigate(R.id.zomatoCreditsFragment)

            Toast.makeText(requireContext(), "underdevelopment", Toast.LENGTH_SHORT).show()
        }
        binding.claimGiftCard.setOnClickListener {

            findNavController().navigate(R.id.claimGiftCardFragment)

            Toast.makeText(requireContext(), "underdevelopment", Toast.LENGTH_SHORT).show()
        }


    }


}