package kz.zhansaya.college.Fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import  kotlinx.android.synthetic.main.fragment_college.*
import kz.zhansaya.college.Activities.ContactsActivity
import kz.zhansaya.college.Activities.MapsActivity
import kz.zhansaya.college.Activities.VirtualActivity

import kz.zhansaya.college.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class CollegeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_college, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        korpus_cardview.setOnClickListener {
            val intent=Intent(context, MapsActivity::class.java)
            startActivity(intent)


        }

        vitual_cardview.setOnClickListener {
            val intent= Intent(context, VirtualActivity::class.java)
            startActivity(intent)
        }
    }

}
