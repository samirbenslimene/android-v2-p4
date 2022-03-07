package tn.esprit.loldatastorage.utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import tn.esprit.leagueoflegendrecyclerview.data.Champion
import tn.esprit.loldatastorage.dao.ChampionDao

//TODO 8 "Change to a ROOMDataBase"

@Database(entities = [Champion::class], version=1 , exportSchema = false)
abstract class AppDataBase  {

    //TODO 8.1 "Add the DAO"
 abstract  fun championdao() : ChampionDao

    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            if (instance == null) {
                synchronized(this) {
                    //TODO 8.2 "Build the DataBase"

                    instance = Room.databaseBuilder(context, AppDataBase::class.java , "db_champions")
                        .allowMainThreadQueries()
                        .build()


                }
            }
            return instance!!
        }
    }
}


