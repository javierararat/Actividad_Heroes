package com.jararat.actividad_1

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.jararat.actividad_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        //setContentView(R.layout.activity_main)
        setContentView(viewBinding.root)


        //var et_Heroe = findViewById<EditText>(R.id.et_NameHeroe)
        //var bt_send = findViewById<Button>(R.id.btn_Send)

        //var heroe:String = et_Heroe.text.toString()

        //evento
        //bt_send.setOnClickListener {
        /*viewBinding.btnSend.setOnClickListener {
           // Toast.makeText(this, "Has registrado a $heroe", Toast.LENGTH_LONG).show()
           // Snackbar.make(it, "Has registrado a $heroe",Snackbar.LENGTH_LONG).setAnchorView(R.id.btn_Send).show()

           // var heroe:String = getString(R.string.txt_notification,et_Heroe.text.toString())
            var heroe:String = getString(R.string.txt_notification,viewBinding.etNameHeroe.text.toString())

            Snackbar.make(it, heroe,Snackbar.LENGTH_LONG).setAnchorView(R.id.btn_Send).show()
        }*/


        viewBinding.btnSend.setOnClickListener {

            val intent = Intent(this,VerDatosActivity::class.java)

            val heroe:String = viewBinding.etHeroeName.text.toString()
            val power:Float = viewBinding.rbPower.rating
            val image:Bitmap = viewBinding.ivPhoto.drawable.toBitmap()

           // intent.putExtra(VerDatosActivity.HEROE_KEY, heroe)
           // intent.putExtra(VerDatosActivity.POWER_KEY, power)
           // intent.putExtra(VerDatosActivity.IMAGE_KEY, image)

            val heroeC = Heroe(heroe, power,image)
             intent.putExtra(VerDatosActivity.HEROE_KEY, heroeC)

            startActivity(intent)
        }

        viewBinding.ivPhoto.setOnClickListener {
            val intentImplicito = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(intentImplicito,7)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==7 && resultCode == Activity.RESULT_OK) {
            val data_img:Bundle? = data?.extras

            val heroeImage:Bitmap? = data_img?.getParcelable<Bitmap>("data")

            viewBinding.ivPhoto.setImageBitmap(heroeImage)
        }
    }
}