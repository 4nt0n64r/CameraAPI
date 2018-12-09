package a4nt0n64r.cameraapi

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_WRITE_EXTERNAL_STORAGE = 1
    val REQUEST_CAMERA = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermissionStorage()
        checkPermissionCamera()

        takePicture.setOnClickListener {

        }


    }

    fun checkPermissionStorage():Boolean {
        //запрашиваем разрешение на доступ к STORAGE
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // Разрешение не дано
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_WRITE_EXTERNAL_STORAGE)
            return true
        }else{
            return false
        }
    }

    fun checkPermissionCamera():Boolean{
        //запрашиваем разрешение на доступ к CAMERA
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // Разрешение не дано
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                REQUEST_CAMERA)
            return true
        }else{
            return false
        }
    }
}
