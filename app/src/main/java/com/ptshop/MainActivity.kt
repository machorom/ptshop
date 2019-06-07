package com.ptshop

import android.content.DialogInterface
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myWebView = findViewById<View>(R.id.webview) as WebView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true)
        }
        val settings = myWebView.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        myWebView.loadUrl("http://www.ptshop.kr/pt/test.php")
    }

    override fun onBackPressed() {
        Log.i("back","back key")
        var dialog = AlertDialog.Builder(this)
        dialog.setTitle("PT-Shop")
        dialog.setMessage("앱을 종료하시겠습니까?")
        dialog.setIcon(R.mipmap.ic_launcher)
        fun toast_p() {
            finish()
        }
        fun toast_n(){
            Log.d("MainActivity","close cancle")
            //Toast.makeText(this, "Negative 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show()
        }
        var dialog_listener = object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when(which){
                    DialogInterface.BUTTON_POSITIVE ->
                        toast_p()
                    DialogInterface.BUTTON_NEGATIVE ->
                        toast_n()
                }
            }
        }
        dialog.setPositiveButton("YES",dialog_listener)
        dialog.setNegativeButton("NO",dialog_listener)
        dialog.show()
        return
    }
}
