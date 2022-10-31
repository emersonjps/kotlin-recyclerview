package com.example.kotlinrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ocanha.kotlinrecyclerview.DataSource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var liveAdapter: LiveAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView() // <--- Ativa uma instância do recycler view
        addDataSource() // <--- inseri os itens para o adpter renderizar
    }

    private fun addDataSource() {
        val dataSource = DataSource.createDataSet() // <--- Pega a lista de dados mokados
        this.liveAdapter.setDataSet(dataSource) // <--- Inserir ao Adpter os dados de renderização
    }

    private fun initRecyclerView() {

        this.liveAdapter = LiveAdapter() // <--- Instância a classe do adpter

        recyclerview.layoutManager = LinearLayoutManager(this@MainActivity) // <-- Gerenciador de layout do adpter
        recyclerview.adapter = this.liveAdapter // <-- Referência a recycler view ao adpter criado

    }
}