package lostankit7.droid.moodtracker.data.repository

import lostankit7.droid.moodtracker.data.database.dao.MoodIconDao
import lostankit7.droid.moodtracker.data.database.dao.SuggestedMoodDao
import lostankit7.droid.moodtracker.data.database.entities.MoodIcon
import lostankit7.droid.moodtracker.data.database.entities.SuggestedMood
import javax.inject.Inject

class MoodRepository @Inject constructor(
    private val moodIconDao: MoodIconDao,
    private val suggestedMoodDao: SuggestedMoodDao
) {

    val moodIcons = moodIconDao.getMoodIcons()

    val suggestedMoodIcons = suggestedMoodDao.suggestedMoodIcons()

    suspend fun insertMoodIcons(icons: List<MoodIcon>) = moodIconDao.insertMoodIcons(icons)

    suspend fun insertMoodIcon(icon: MoodIcon) = moodIconDao.insertMoodIcon(icon)

    suspend fun insertSuggestedMoods(list: List<SuggestedMood>) =
        suggestedMoodDao.insertSuggestions(list)

}