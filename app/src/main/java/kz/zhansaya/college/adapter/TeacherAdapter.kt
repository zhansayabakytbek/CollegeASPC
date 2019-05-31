package kz.zhansaya.college.adapter

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.teach_item.view.*
import kz.zhansaya.college.Activities.TeacherActivity
import kz.zhansaya.college.R
import kz.zhansaya.college.model.Teacher


class TeacherAdapter(val items: ArrayList<Teacher>) :
    RecyclerView.Adapter<TeacherAdapter.TeacherAdapterViewHolder>() {


    fun addTeacherAdapter(itemss: List<Teacher>) {
        items.addAll(itemss)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TeacherAdapterViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.teach_item, p0, false)
        return TeacherAdapterViewHolder(view)
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(p0: TeacherAdapterViewHolder, p1: Int) {
        p0.name.text = items[p1].name
        Picasso.get().load(items[p1].photo).into(p0.image)
        //p0.card.setOnClickListener {
        p0.card.setOnClickListener {
            val intent = Intent(it.context, TeacherActivity::class.java)
            intent.putExtra("nameTeacher", items[p1].name)
            intent.putExtra("phototeacher", items[p1].photo)
            it.context.startActivity(intent)
        }


    }


    inner class TeacherAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.teacher_name
        val image = view.teacher_item
        val spec = view.teacher_spec
        val score = view.teacher_score
        val card = view.teacher_cardview
    }


}

