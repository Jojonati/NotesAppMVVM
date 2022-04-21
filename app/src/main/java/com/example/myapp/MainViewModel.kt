package com.example.myapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapp.model.Note
import com.example.myapp.utils.TYPE_FIREBASE
import com.example.myapp.utils.TYPE_ROOM_DATABASE
import java.lang.IllegalArgumentException

class MainViewModel(application: Application): AndroidViewModel(application) {
    val readTest: MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>()
    }

    val dbType: MutableLiveData<String> by lazy {
        MutableLiveData<String>(TYPE_ROOM_DATABASE)
    }
    fun initDatabase(typeDB: String) {
        dbType.value = typeDB
        Log.d("checkData", "MainVewModel init Database with type: $typeDB")
    }

    init {
        readTest.value =
            when(dbType.value) {
            TYPE_ROOM_DATABASE -> {
                listOf(
                    Note(title = "TITLE 1", subtitle = "SUBTITLE FOR NOTE 1"),
                    Note(title = "TITLE 2", subtitle = "SUBTITLE FOR NOTE 2"),
                    Note(title = "TITLE 3", subtitle = "SUBTITLE FOR NOTE 3"),
                    Note(title = "TITLE 4", subtitle = "SUBTITLE FOR NOTE 4"),
                    Note(title = "TITLE 5", subtitle = "SUBTITLE FOR NOTE 5")
                )
            }
            TYPE_FIREBASE -> listOf()
            else -> listOf()
        }
    }
}
class MainViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application = application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}