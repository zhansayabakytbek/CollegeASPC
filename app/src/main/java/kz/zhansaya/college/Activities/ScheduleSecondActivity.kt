package kz.zhansaya.college.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_schedule_second.*
import kotlinx.android.synthetic.main.fragment_schedule.*
import kz.zhansaya.college.R

class ScheduleSecondActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_schedule_second)
        val draw = resources.getDrawable(R.drawable.schedulesecond)
        photo_schedule_second_photo.setImageDrawable(draw)



    }

}
