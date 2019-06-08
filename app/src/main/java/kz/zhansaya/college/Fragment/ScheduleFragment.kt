package kz.zhansaya.college.Fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_schedule.*
import kz.zhansaya.college.Activities.GrafikActivity
import kz.zhansaya.college.Activities.ScheduleFirstActivity
import kz.zhansaya.college.Activities.ScheduleSecondActivity

import kz.zhansaya.college.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ScheduleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        grafik_button.setOnClickListener {
            val intent = Intent(context, GrafikActivity::class.java)
            startActivity(intent)


        }

        photo_scedulfirst.setOnClickListener {
            val intent = Intent(context, ScheduleFirstActivity::class.java)
            startActivity(intent)
        }
        photo_schedul.setOnClickListener {
            val intent = Intent(context, ScheduleSecondActivity::class.java)
            startActivity(intent)
        }
    }
}
