package kz.zhansaya.college.Fragment


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_teacher.*
import kotlinx.android.synthetic.main.teach_item.*
import kz.zhansaya.college.Activities.TeacherActivity

import kz.zhansaya.college.R
import kz.zhansaya.college.adapter.TeacherAdapter
import kz.zhansaya.college.model.Teacher

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class TeacherFragment : Fragment() {
    lateinit var mContext: Context
    var newsss: List<Teacher> = listOf()
    private val adapterr by lazy { TeacherAdapter(ArrayList()) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teacher, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContext= view.context


        val ll = arrayListOf<Teacher>(
            Teacher("Г.А.Аманова", 100.0, "Преподаватель спец дисциплин", "http://agpk.kz/wp-content/uploads/2018/04/imagepreppo-3.jpg" ),
            Teacher("Н.Камаладинкызы", 101.0, "Преподаватель спец дисциплин", "http://agpk.kz/wp-content/uploads/2018/04/imagepreppo-13.jpg" ),
            Teacher("Г.А.Омарбекова", 105.0, "Преподаватель спец дисциплин", "http://agpk.kz/wp-content/uploads/2018/10/po_kaf-7.jpg"),
            Teacher("Г.К. Алишева", 104.0, "Преподаватель", "http://agpk.kz/wp-content/uploads/2018/04/imageprepnvp-14.jpg"),
            Teacher("Н.Ж.Абылханова", 103.0, "Преподаватель", "http://agpk.kz/wp-content/uploads/2019/01/Abylhanova-1024x768.jpg"),
            Teacher("A.M.Абдуллина", 90.0, "Преподаватель", "http://agpk.kz/wp-content/uploads/2018/10/alma_makpal-1024x681.jpg"),
            Teacher("M.M.Акимов ", 100.0, "Преподаватель", "http://agpk.kz/wp-content/uploads/2018/04/imagekmie-1.jpg"),
            Teacher("А.Л.Алметова ", 100.0, "Преподаватель", "http://agpk.kz/wp-content/uploads/2018/04/imagepreppo-2.jpg"),
            Teacher("A.A.Амирбеков", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imageprepnvp-9.jpg"),
            Teacher("A.A.Ахметова", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imageprepkaz-1.jpg"),
            Teacher("Ж.Д.Байбалакова", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imagekmie-2.jpg"),
            Teacher("Ж.М.Байжанова", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imageprepkaz-6.jpg"),
            Teacher("М.Т.Балгазиева", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imagepreppo-5.jpg"),
            Teacher("А.Т.Бекбай ", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/10/vt-9.jpg"),
            Teacher("С.Д.Бердибаева ", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imagepreppo-7.jpg"),
            Teacher("М.А.Бикенова", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/10/vt-8.jpg"),
            Teacher("А.А.Карашева", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imageit-9-1024x682.jpg"),
            Teacher("Б.Т.Иманбекова", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/10/555.jpg"),
            Teacher("Г.К.Имангалиева", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imagepreppo-9.jpg"),
            Teacher("Г.К.Исабекова", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imageprepgum-1.jpg"),
            Teacher("М.Т.Исмагамбетова", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/01/IMG-20171120-WA0054-1.jpg"),
            Teacher("А.М.Исмаилова", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imagepreppo-11.jpg"),
            Teacher("Г.М.Исмаилова", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/01/gt-300x227.jpg"),
            Teacher("Л.Б.Ізғали", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imageprepgum-10.jpg"),
            Teacher("Д.М.Кабирова", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/10/kabirova-1024x768.jpg"),
            Teacher("А.Кабылбек", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imagepreppo-12.jpg"),
            Teacher("Г.А.Канабекова", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imagepreppo-14.jpg"),
            Teacher("С.Ы.Карабекова", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/estestvoimage-3.jpg"),
            Teacher("К.Т.Каржаубаева", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/10/vt-2.jpg"),
            Teacher("Т.Б.Касенов", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/10/vt-11.jpg"),
            Teacher("А.Б.Рахметова", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imagekmie-11.jpg"),
            Teacher("Р.С.Садыков", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/10/Sadykov-Rashid-1024x681.jpg"),
            Teacher("Н.М.Сейтов", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imagekmie-13.jpg"),
            Teacher("В.М.Сигаева", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imagepreppo-21.jpg"),
            Teacher("А.Ж.Сисенбаева", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imageprepgum-9.jpg"),
            Teacher("М.М.Сонурова", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imageprepgum-3.jpg"),
            Teacher("А.К.Тастамбекова", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/10/tastambekova.jpg"),
            Teacher("Д.Д.Токенова", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imagepreppo-23.jpg"),
            Teacher("А.А.Токтамуратова", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imageprepgum-6.jpg"),
            Teacher("А.H.Токтыманова ", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/10/vt-1.jpg"),
            Teacher("Г.У.Боранбаева ", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imageit-6-1024x682.jpg"),
            Teacher("А.А. Дуйсенбаева",100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/dyisenbaeva-1024x682.jpg"),
            Teacher("М.Е. Турсынбаева",100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imagekmie-14.jpg"),
            Teacher("М.Ә. Нүсіпбекова",100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imagekmie-9.jpg"),
            Teacher("А.С.Оразымбетова ", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/04/imagekmie-10.jpg"),
            Teacher("Т.Т.Шаратбеков", 100.0, "Преподаватель","http://agpk.kz/wp-content/uploads/2018/10/Sharatbekov-Ta-at.jpg")  )

        adapterr.addTeacherAdapter(ll)

        recycler_teach.apply {
            layoutManager = LinearLayoutManager(mContext)
            adapter = adapterr
        }

    }




}
