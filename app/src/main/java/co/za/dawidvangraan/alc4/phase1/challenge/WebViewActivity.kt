package co.za.dawidvangraan.alc4.phase1.challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_web_view.*
import android.webkit.WebViewClient
import android.net.http.SslError
import android.webkit.SslErrorHandler




class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_web_view)

        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://andela.com/alc/")

        webView.webViewClient = WebViewController()
    }
}

internal class WebViewController : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        view.loadUrl(url)
        return true
    }

    override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, er: SslError) {
        handler.proceed()
        // Ignore SSL certificate errors
    }
}
