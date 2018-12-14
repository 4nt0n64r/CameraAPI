package a4nt0n64r.cameraapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.activity_result.*


class ResultActivity : AppCompatActivity() {

    companion object {
        const val NAME = "NAME"
        const val PIC = "PIC"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val intent = intent
        nameDisplay.setText(intent.getStringExtra(NAME).toString())
        imageDisplay.setImageBitmap(intent.getParcelableExtra(PIC))

        //при повороте засунуть всё в onsaveinstState

    }
}
