package a4nt0n64r.cameraapi

import a4nt0n64r.cameraapi.ResultActivity.Companion.NAME
import a4nt0n64r.cameraapi.ResultActivity.Companion.PIC
import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        takePicture.setOnClickListener {
            if (checkText(nameField)){
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent,0)

            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){

            val photo = data!!.extras.get("data") as Bitmap

            val intent = Intent(this,ResultActivity::class.java)

            intent.putExtra(NAME,nameField.text.toString())
            intent.putExtra(PIC,photo)
            startActivity(intent)
        }
    }
    fun checkText(nameField:EditText) = !nameField.text.isEmpty()

}
