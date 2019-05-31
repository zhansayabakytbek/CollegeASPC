package kz.zhansaya.college.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_grafik.*
import kotlinx.android.synthetic.main.activity_schedule_first.*
import kotlinx.android.synthetic.main.fragment_schedule.*
import kz.zhansaya.college.R

class ScheduleFirstActivity : AppCompatActivity() {

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }

        return super.onOptionsItemSelected(item)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_first)
        val draw = resources.getDrawable(R.drawable.scedule1)
        photo_schedule_first_photo_view.setImageDrawable(draw)
    }
}
