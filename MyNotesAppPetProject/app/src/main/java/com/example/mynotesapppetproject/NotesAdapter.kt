package com.example.mynotesapppetproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotesapppetproject.databinding.NotesItemBinding

class NotesAdapter(private val listenerNotes: ListenerNotes): RecyclerView.Adapter<NotesAdapter.NotesHolder>() {

    private val notesList = ArrayList<DataNotes>() //создаем массив в котором будут хранится notes_item

    class NotesHolder(item: View): RecyclerView.ViewHolder(item) { //в классе NotesHolder содержатся ссылки на все view которые будут отображаться в одном элементе

        var binding = NotesItemBinding.bind(item) //viewBinding

        fun bind(dataNotes: DataNotes, listenerNotes: ListenerNotes){ //передаем то что хотим видеть на MainActivity
            binding.imageViewNotes.setImageResource(dataNotes.imageId)
            binding.tvNameFile.text = dataNotes.fileName
            binding.btnDelete.setOnClickListener {

            }

            itemView.setOnClickListener{ //itemView это и есть RecyclerView, а в RecyclerView у меня notes_item
                listenerNotes.onClickNote(dataNotes)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesHolder { //создание разметки notes_item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notes_item, parent, false)
        return NotesHolder(view)
    }

    override fun onBindViewHolder(holder: NotesHolder, position: Int) { //заполнение notes_item
        holder.bind(notesList[position], listenerNotes)
    }

    override fun getItemCount(): Int { //узнает колличество элементов в списке
        return notesList.size
    }

    fun addNotes(dataNotes: DataNotes){ //добавление в массив новый notes_item
        notesList.add(dataNotes)
        notifyDataSetChanged() //метод указывает адаптеру что данные изменились
    }


}