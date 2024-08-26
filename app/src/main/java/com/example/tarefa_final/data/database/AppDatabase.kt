package com.example.tarefa_final.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tarefa_final.data.dao.TaskDao
import com.example.tarefa_final.data.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    companion object{
        const val DATA_NAME = "app_tasks.db"
        private lateinit var instance: AppDatabase

        fun getInstance(context: Context): AppDatabase{
            synchronized(AppDatabase::class){
                if(! ::instance.isInitialized){
                    instance = Room.databaseBuilder(
                        context,AppDatabase::class.java, DATA_NAME
                    ).build()
                }
            }
            return instance
        }
    }
    abstract fun getTaskDao(): TaskDao

}