package kz.zhansaya.college.Activities

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_virtual.*
import kz.zhansaya.college.R
import kz.zhansaya.college.adapter.CabinetAdapter
import kz.zhansaya.college.model.Cabinetmodel

class VirtualActivity : AppCompatActivity() {
    lateinit var mContext: Context
    var newsss: List<Cabinetmodel> = listOf()
    private val adapterr by lazy { CabinetAdapter(ArrayList()) }

    private lateinit var webView: WebView
    private var width: Int = 0
    private var height: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_virtual)
        mContext=this

        val ll = arrayListOf<Cabinetmodel>(
            Cabinetmodel("https://s0.rbk.ru/v6_top_pics/media/img/3/76/755042588185763.jpg", "Кабинет 101", "Позавчера 10:00", "https://streamable.com/s/3hf71/kvomqe" ),
            Cabinetmodel("https://cdn.the-village.ru/the-village.ru/post-cover/g8MT6XzgITkL5hqSKnU1Zg-default.jpg", "Кабинет 102", "Вчера 12:00", "https://streamable.com/s/yaq3s/paqmsf" ),
            Cabinetmodel("http://api-platform.newtonew.com/uploads/5ab24c1c1fed8655275850.jpeg", "Кабинет 104", "", "https://streamable.com/s/fryav/ltaxxn"),
            Cabinetmodel("http://eddesignaward.com/wp-content/uploads/cache/2018/09/dsc06439-1/2154153050.png", "Кабинет 105", "", "https://streamable.com/s/otrmg/berjzw"),
            Cabinetmodel("https://harvest.zp.ua/upload/article/gorizontalnie-jalyuzi-dlya-shkolnogo-klassa.jpg","Кабинет 405", "", "https://streamable.com/s/gdcgc/pqsbcd"),
            Cabinetmodel("https://atanorgroup.ru/wp-content/uploads/2017/04/act_zal_n.jpeg","Актовый зал","","https://streamable.com/s/a5loe/plbbwz"),
            Cabinetmodel( "https://cdn.the-village.ru/the-village.ru/post_image-image/9WfwGKJee3So1gV47OqHVw-wide.jpg", "Общежития", "","https://streamable.com/s/svsjg/efqjfv")
        )
        adapterr.addCabinetAdapter(ll)

        recycler_view.apply {
            layoutManager = LinearLayoutManager(mContext)
            adapter = adapterr
        }



    }
}
