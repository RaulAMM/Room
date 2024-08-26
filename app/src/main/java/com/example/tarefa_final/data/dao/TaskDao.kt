package com.example.tarefa_final.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tarefa_final.data.model.Task

@Dao
interface TaskDao {

    @Insert
    suspend fun create(task: Task): Long

    @Query("SELECT * FROM tb_tasks ORDER BY title")
    suspend fun retrieveAll(): List<Task>

    @Query("SELECT * FROM tb_tasks WHERE id = :id")
    suspend fun getTask(id: Long): Task

    @Update
    suspend fun update(task: Task): Int

    @Delete
    suspend fun delete(task: Task):Int
}