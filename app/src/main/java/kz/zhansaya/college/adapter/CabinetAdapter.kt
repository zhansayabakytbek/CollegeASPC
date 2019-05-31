package kz.zhansaya.college.adapter

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cabinet_item.view.*
import kz.zhansaya.college.R
import kz.zhansaya.college.model.Cabinetmodel

class CabinetAdapter(val items: ArrayList<Cabinetmodel>) :
    RecyclerView.Adapter<CabinetAdapter.CabinetAdapterViewHolder>() {
    private lateinit var webView: WebView
    private var width: Int = 0
    private var height: Int = 0


    fun addCabinetAdapter(itemss: List<Cabinetmodel>) {
        items.addAll(itemss)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CabinetAdapterViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.cabinet_item, p0, false)
        return CabinetAdapterViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("SetJavaScriptEnabled")
    override fun onBindViewHolder(p0: CabinetAdapterViewHolder, p1: Int) {
        p0.title.text = items[p1].title
        Picasso.get().load(items[p1].image).into(p0.image)
        p0.card.setOnClickListener {

            val webView = WebView(p0.itemView.context)
            webView.setInitialScale(1)
            webView.webChromeClient = WebChromeClient()
            webView.settings.allowFileAccess = true
            webView.settings.pluginState = WebSettings.PluginState.ON
            webView.settings.pluginState = WebSettings.PluginState.ON_DEMAND
            webView.webViewClient = WebViewClient()
            webView.settings.javaScriptEnabled = true
            webView.settings.loadWithOverviewMode = true
            webView.settings.useWideViewPort = true
            val displaymetrics = DisplayMetrics()
//            windowManager.defaultDisplay.getMetrics(displaymetrics)
            val height = 300
            val width = 300

            val VIDEO_URL = items[p1].price
            val data_html =
                "<!DOCTYPE html><html> <head> <meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"target-densitydpi=high-dpi\" /> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> <link rel=\"stylesheet\" media=\"screen and (-webkit-device-pixel-ratio:1.5)\" href=\"hdpi.css\" /></head> <body style=\"background:black;margin:0 0 0 0; padding:0 0 0 0;\"> <iframe style=\"background:black;\" width=' $width' height='$height' src=\"$VIDEO_URL\" frameborder=\"0\"></iframe> </body> </html> "

            webView.loadDataWithBaseURL(null, data_html, "text/html", "UTF-8", null)

            val alertDialog = AlertDialog.Builder(p0.itemView.context)
            alertDialog.setTitle("Video").setView(webView).setNeutralButton("ok", null).show()


        }
    }

    inner class CabinetAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.cabinet_itemtext
        val image = view.cabinet_image
        val card = view.cabinet_cardview
    }


}