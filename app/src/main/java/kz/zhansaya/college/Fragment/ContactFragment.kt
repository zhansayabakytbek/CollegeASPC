package kz.zhansaya.college.Fragment


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_college.*
import kotlinx.android.synthetic.main.fragment_contact.*
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
class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        whatsup_btn.setOnClickListener {
            Toast.makeText(context, "Basyldy2", Toast.LENGTH_LONG).show()
//             String url = "https:api.whatsapp.com/send?phone="+number;
//            Intent i = new Intent(Intent.ACTION_VIEW);
//            i.setData(Uri.parse(url));
//            startActivity(i);
            val url: String =  "https://api.whatsapp.com/send?phone=77757054525"
            val i: Intent = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)

        }
        phone_btn.setOnClickListener {
            val intent= Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"87273933952"));
            startActivity(intent)
        }
        callphone_btn.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"87273934191"));
            startActivity(intent)
        }

    }
}
