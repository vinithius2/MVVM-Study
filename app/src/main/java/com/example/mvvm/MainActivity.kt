package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    /***
     * Responsável pela manipulação da interface, como o clique, a navegação entre as activitys,
     * obtenção e atribuição de valores. A View do MVVM é para a interface, para parte visual.
     */
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Deixar a instância por responsabilidade do sistema
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.textWelcome.observe(this, Observer {
            textWelcome.text = it
        })

        viewModel.login.observe(this, Observer {
            if(it) {
                Toast.makeText(applicationContext, "Sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Falha!", Toast.LENGTH_SHORT).show()
            }
        })

        buttonLogin.setOnClickListener {
            val login = editName.text.toString()
            viewModel.login(login)
        }

    }

}