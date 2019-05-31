package kz.zhansaya.college

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.FirebaseApp
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kz.zhansaya.college.Fragment.CollegeFragment
import kz.zhansaya.college.Fragment.ContactFragment
import kz.zhansaya.college.Fragment.ScheduleFragment
import kz.zhansaya.college.Fragment.TeacherFragment
import android.content.Intent
import android.content.ActivityNotFoundException
import android.net.Uri


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    internal val fragment1: Fragment = CollegeFragment()
    internal val fragment2: Fragment = ContactFragment()
    internal val fragment3: Fragment= TeacherFragment()
    internal val fragment4: Fragment= ScheduleFragment()
    internal val fm = supportFragmentManager
    internal var active = fragment1
    lateinit var mContext: Context



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //for teacherge
        FirebaseApp.initializeApp(this)
        fm.beginTransaction().add(R.id.container, fragment1, "1").commit()
        fm.beginTransaction().add(R.id.container, fragment2, "2").hide(fragment2).commit()
        fm.beginTransaction().add(R.id.container, fragment3, "3").hide(fragment3).commit()
        fm.beginTransaction().add(R.id.container, fragment4, "4").hide(fragment4).commit()

        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_schedule -> {
                fm.beginTransaction().hide(active).show(fragment4).commit()
                active = fragment4

                // Handle the camera action
            }
            R.id.nav_bally -> {

                fm.beginTransaction().hide(active).show(fragment3).commit()
                active = fragment3
            }
            R.id.nav_Contact -> {
                fm.beginTransaction().hide(active).show(fragment2).commit()
                active = fragment2

            }
            R.id.nav_college -> {
                fm.beginTransaction().hide(active).show(fragment1).commit()
                active = fragment1

            }
            R.id.nav_website -> {
                val uri = Uri.parse("http://agpk.kz/")
                val likeIng = Intent(Intent.ACTION_VIEW, uri)



                try {
                    startActivity(likeIng)
                } catch (e: ActivityNotFoundException) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://agpk.kz/")
                        )
                    )
                }


            }
            R.id.nav_instagram -> {
                val uri = Uri.parse("https://www.instagram.com/polytechalmaty/")
                val likeIng = Intent(Intent.ACTION_VIEW, uri)

                likeIng.setPackage("com.instagram.android")

                try {
                    startActivity(likeIng)
                } catch (e: ActivityNotFoundException) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com/polytechalmaty/")
                        )
                    )
                }


            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
