package com.example.appMylenna

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.tela_menu.*

class TelaMenu : AppCompatActivity(){ // Declarou que a classe é do tipo tela(AppCompatActivity)

    override fun onCreate(savedInstanceState: Bundle?) { // Sobrescreveu a função que será executada quando a tela for criada
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_menu) // Função que diz qual XML representa essa tela

        botaoTruco.setOnClickListener {
            val navegar = Intent(applicationContext, TelaTruco::class.java) // Criou uma variável Intent, que recebe como parâmetro aonde está
            // (applicationcontext) e para onde vai(Classe kotlin da tela que vai, seguido de ::class.java)
            navegar.putExtra("chave", 0)// Esta enviando uma informação para a próxima tela, junto com a sua chave de identificação
            startActivity(navegar) // Função que abre a outra tela, basta passar a variável intent
        }

        botaoAgua.setOnClickListener {
            val navegar = Intent(applicationContext, TelaAgua::class.java)
            startActivity(navegar)
        }



    }

}