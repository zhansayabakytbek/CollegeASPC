package kz.zhansaya.college.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_teacher.*
import kz.zhansaya.college.MainActivity
import kz.zhansaya.college.R
import kz.zhansaya.college.model.Rating
import java.util.*

class TeacherActivity : AppCompatActivity() {
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }

        return super.onOptionsItemSelected(item)

    }
    var sum_rating: Float = 0.0f;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)

        val intent = intent
        val extras = intent.extras
        var nameTeacher = extras?.getString("nameTeacher", "nonName")
        var photoTeacher= extras?.getString("phototeacher","photo")
        name.text = nameTeacher

        getRatings()

        Picasso.get().load(photoTeacher).into(teacher_imrating)
        teacer_button.setOnClickListener {
            val uuid = UUID.randomUUID()
            val UUIDString = uuid.toString()
            var group = teacher_edittext.text.toString() + "-" + UUIDString
            val rating = Rating(name.text.toString(), ratingBar.rating, group)
            saveTeacherToDatabase(rating)
        }
    }

    private fun getRatings(){
        var fio = name.text.toString()
        fio = fio.replace(".","_")
        val ref = FirebaseDatabase.getInstance().getReference("/Teachers/$fio")

        val ratings: ArrayList<Rating> = ArrayList()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                ratings.clear()
                for (postSnapshot in snapshot.children) {
                    val teacher_rating = postSnapshot.getValue<Rating>(Rating::class.java)
                    ratings.add(teacher_rating!!)
                    sum_rating += teacher_rating.rating
                }
                rating_textview.text = "Рейтинг данного учителя: " + sum_rating.toString()
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }


    private fun saveTeacherToDatabase(rating: Rating) {
        val uuid = UUID.randomUUID()
        val UUIDString = uuid.toString()
        var fio = rating.name
        fio = fio.replace(".","_")
        var group = teacher_edittext.text.toString() + "-" + UUIDString

        val ref = FirebaseDatabase.getInstance().getReference("/Teachers/$fio/$group")


        ref.setValue(rating)
            .addOnSuccessListener {

                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)

            }
            .addOnFailureListener {

            }
    }
}
