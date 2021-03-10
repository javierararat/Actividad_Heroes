package com.jararat.actividad_1

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import com.jararat.actividad_1.databinding.ActivityMainBinding
import com.jararat.actividad_1.databinding.ActivityVerDatosBinding

class VerDatosActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityVerDatosBinding

    lateinit var heroe:Heroe

    companion object{
        const val HEROE_KEY = "heroe_key"
       // const val POWER_KEY = "power_key"
      //  const val IMAGE_KEY = "image_key"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_ver_datos)
        viewBinding = ActivityVerDatosBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

       /* val intent:Bundle = intent.extras!!

        viewBinding.tvNameSend.text = intent.getString(HEROE_KEY)
        viewBinding.ratingBar.rating = intent.getFloat(POWER_KEY)
        viewBinding.photoSend.setImageBitmap(intent.getParcelable<Bitmap>(IMAGE_KEY))
        */

        //val people = intent.getSerializableExtra(HEROE_KEY) as? Heroe
        val heroe = intent.getParcelableExtra<Heroe>(HEROE_KEY)
        if (heroe != null) {
            viewBinding.tvNameSend.text = heroe.nombre
            viewBinding.ratingBar.rating  = heroe.power!!
            viewBinding.photoSend.setImageBitmap(heroe.img)
        }
    }
}