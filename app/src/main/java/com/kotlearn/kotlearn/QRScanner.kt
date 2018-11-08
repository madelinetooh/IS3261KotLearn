package com.kotlearn.kotlearn

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.barcode.Barcode
import com.google.android.gms.vision.barcode.BarcodeDetector
import kotlinx.android.synthetic.main.activity_qrscanner.*
import java.io.IOException

class QRScanner : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    private var myPreferences = "myPrefs"
    private var CODE = "code"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        setContentView(R.layout.activity_qrscanner)

        btn_back.setOnClickListener {
            finish()
        }

        val cameraView = findViewById<SurfaceView>(R.id.surfaceView)

        val barcodeDetector = BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.QR_CODE)
                .build()

        val cameraSource = CameraSource.Builder(this, barcodeDetector)
                .setRequestedPreviewSize(640, 480)
                .build()

        cameraView.holder.addCallback(object: SurfaceHolder.Callback {
            @SuppressLint("MissingPermission")
            override fun surfaceCreated(holder: SurfaceHolder) {
                try {
                    cameraSource.start(cameraView.holder)
                } catch (ie: IOException) {
                    Log.e("Camera source", ie.message)
                }
            }

            override fun surfaceChanged(holder: SurfaceHolder,
                                        format: Int, width: Int, height: Int) {}
            override fun surfaceDestroyed(holder: SurfaceHolder) {
                cameraSource.stop()
            }
        })

        barcodeDetector.setProcessor(object : Detector.Processor<Barcode> {

            override fun release() {}

            override fun receiveDetections(detections: Detector.Detections<Barcode>) {
                val barCodes = detections.detectedItems
                if (barCodes.size() != 0) {
                    val editor = sharedPreferences.edit()
                    val displayValue = barCodes.valueAt(0).displayValue
                    editor.putString(CODE, displayValue)
                    editor.apply()
                    val myIntent = Intent()
                    setResult(Activity.RESULT_OK, myIntent)
                    println("TEST $displayValue")
                    finish()
                }
            }
        })

    }
}
