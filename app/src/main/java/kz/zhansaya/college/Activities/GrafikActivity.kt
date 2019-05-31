package kz.zhansaya.college.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_grafik.*
import kz.zhansaya.college.R

class GrafikActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_grafik)
        val draw = resources.getDrawable(R.drawable.grafik)
        photo_grafik.setImageDrawable(draw)


    }
}
