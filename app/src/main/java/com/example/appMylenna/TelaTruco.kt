package com.example.appMylenna

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.tela_truco.*

class TelaTruco : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_truco)

        var placarCima = 0
        var placarbaixo = 0
        var informacaoRecebida = intent.getIntExtra("chave", 0)
        textoCima.text = informacaoRecebida.toString()

        maisUmCima.setOnClickListener {
            if (placarCima < 12) {
                placarCima += 1
                textoCima.text = placarCima.toString()
            }

        }

        trucoCima.setOnClickListener {
            if (placarCima <= 9) {
                placarCima += 3
            }
            if (placarCima in 10..11) {
                placarCima = 12
            }
            textoCima.text = placarCima.toString()
        }

        maisUmBaixo.setOnClickListener {
            if (placarbaixo < 12) {
                placarbaixo += 1
                textoBaixo.text = placarbaixo.toString()
            }
        }
        trucoBaixo.setOnClickListener {
            if (placarbaixo <= 9) {
                placarbaixo += 3
            }

            if (placarbaixo in 10..11) {
                placarbaixo = 12
            }
            textoBaixo.text = placarbaixo.toString()

        }

        reiniciar.setOnClickListener {
            placarCima = 0
            placarbaixo = 0
            textoBaixo.text = placarbaixo.toString()
            textoCima.text = placarCima.toString()
        }

    }

}