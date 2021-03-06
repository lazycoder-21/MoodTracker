package lostankit7.android.entry_data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import lostankit7.android.entry_data.local.entities.LocalTaskIcon

@Dao
interface TaskIconDao {

    @Query("SELECT * FROM LocalTaskIcon where category = :category")
    fun getTaskIcons(category: String): LiveData<List<LocalTaskIcon>>

    @Insert
    suspend fun insertTaskIcons(list: List<LocalTaskIcon>)

    @Insert
    suspend fun insertTaskIcon(icon: LocalTaskIcon)

    @Delete
    suspend fun deleteTask(icon: LocalTaskIcon)

    @Update
    suspend fun updateTask(icon: LocalTaskIcon)

    @Query("UPDATE LocalTaskIcon SET category = :newCategory WHERE category = :oldCategory")
    suspend fun updateTaskCategory(oldCategory: String, newCategory: String)
}