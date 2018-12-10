package a4nt0n64r.cameraapi

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.content.FileProvider
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import android.os.Build



class MainActivity : AppCompatActivity() {

    val REQUEST_CAMERA = 0
    val REQUEST_WRITE_EXTERNAL_STORAGE = 1
    val REQUEST_READ_EXTERNAL_STORAGE = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        takePicture.setOnClickListener {
            if (checkText(nameField)){
                choosePermission(REQUEST_CAMERA)
                //запрос камеры идет после интента для запуска второй активности
                // интент камеры который вернет картинку
                // сохраняем картинку




                // интент второй активности
                val intent = Intent(this,ResultActivity::class.java)
                intent.putExtra("NAME",nameField.text.toString())
                startActivity(intent)
            }
        }
    }



    fun checkPermissionStorageWrite() {
        //запрашиваем разрешение на доступ к STORAGE
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // Разрешение не дано
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_WRITE_EXTERNAL_STORAGE)
        }
    }

    fun checkPermissionCamera(){
        //запрашиваем разрешение на доступ к CAMERA
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // Разрешение не дано
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                REQUEST_CAMERA)
        }
    }

    fun checkText(nameField:EditText) = !nameField.text.isEmpty()

    fun checkPermissionStorageRead() {
        //запрашиваем разрешение на доступ к STORAGE
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // Разрешение не дано
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                REQUEST_WRITE_EXTERNAL_STORAGE)
        }
    }

    fun choosePermission(requestCode:Int){
        when(requestCode){
            REQUEST_CAMERA -> checkPermissionCamera()
            REQUEST_READ_EXTERNAL_STORAGE -> checkPermissionStorageRead()
            REQUEST_WRITE_EXTERNAL_STORAGE -> checkPermissionStorageWrite()
        }
    }
}
