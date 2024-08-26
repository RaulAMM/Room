package com.example.tarefa_final.data.repository

import android.content.Context
import com.example.tarefa_final.data.database.AppDatabase
import com.example.tarefa_final.data.model.Task

class TaskRepository (context: Context){

    private val database = AppDatabase.getInstance(context)
    private val dao = database.getTaskDao()

    suspend fun insert(task: Task):Boolean{
        return dao.create(task) > 0
    }
    suspend fun update(task: Task): Boolean{
        return dao.update(task) > 0
    }
    suspend fun remove(task: Task): Boolean{
        return dao.delete(task) > 0
    }
    suspend fun findById(id: Long): Task{
        return dao.getTask(id)
    }
    suspend fun findAll(): List<Task>{
        return dao.getAll()
    }

}