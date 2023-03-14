package com.marmilich.recyclerviewadapterexample

import android.content.ClipData
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    val countries = listOf(
        Country("Argentina", "Buenos Aires", ),
        Country("Bolivia", "La Paz"),
        Country("Brasil", "Brasilia"),
        Country("Chile", "Santiago"),
        Country("Colombia", "Bogotá"),
        Country("Costa Rica", "San José"),
        Country("Cuba", "La Habana"),
        Country("Dominica", "Roseau"),
        Country("Ecuador", "Quito"),
        Country("El Salvador", "San Salvador"),
        Country("Guatemala", "Ciudad de Guatemala"),
        Country("Haití", "Puerto Príncipe"),
        Country("Honduras", "Tegucigalpa"),
        Country("Jamaica", "Kingston"),
        Country("México", "Ciudad de México"),
        Country("Nicaragua", "Managua"),
        Country("Panamá", "Ciudad de Panamá"),
        Country("Paraguay", "Asunción"),
        Country("Perú", "Lima"),
        Country("República Dominicana", "Santo Domingo"),
        Country("Uruguay", "Montevideo"),
        Country("Venezuela", "Caracas")
    )

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    fun init(){
        recyclerView = findViewById(R.id.recyclerview1)
        recyclerView.adapter = MyAdapter(this, countries)
        var staggeredGridLayoutManager: StaggeredGridLayoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = staggeredGridLayoutManager
    }

    public class MyAdapter(private val context: Context, private val countries: List<Country>) :
        RecyclerView.Adapter<MyAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.itemview, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val currentCountry = countries[position]
            holder.countryName.text = currentCountry.name
            holder.capital.text = currentCountry.capital
        }

        override fun getItemCount(): Int {
            return countries.size
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val countryName: TextView = itemView.findViewById(R.id.name)
            val capital: TextView = itemView.findViewById(R.id.capital)
        }
    }

}
