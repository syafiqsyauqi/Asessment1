package org.d3if0157.mobrpo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if0157.mobrpo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { hitungKonversi() }
    }

    private fun hitungKonversi() {
        val berat = binding.beratEditText.text.toString()
        if (TextUtils.isEmpty(berat)) {
            Toast.makeText(this, R.string.berat_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val beratFloat = berat.toFloat()

        val selectedId = binding.radioGroup.checkedRadioButtonId
        if (selectedId == -1) {
            Toast.makeText(this, R.string.konversi_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val isMiligram = selectedId == R.id.miligramRadioButton
        val isGram = selectedId == R.id.gramRadioButton

        // Mengubah satuan berat dari kg ke mg atau g
        val beratKonversi = if (isMiligram) {
            beratFloat * 1000000 // Konversi ke miligram
        } else if (isGram) {
            beratFloat * 1000 // Konversi ke gram
        } else {
            beratFloat // Tetap menggunakan satuan kilogram
        }

        val konversi = binding.beratEditText.text.toString().toFloat()
        val konversiMgOrG = beratKonversi * konversi

        binding.hasilTextView.text = getString(R.string.hasil_konversi, konversiMgOrG)
    }

}