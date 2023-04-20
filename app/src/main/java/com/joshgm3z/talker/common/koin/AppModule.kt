package com.joshgm3z.talker

import androidx.room.Room
import com.joshgm3z.talker.common.TalkerRepository
import com.joshgm3z.talker.chat.ChatViewModel
import com.joshgm3z.talker.common.firestore.FirestoreManager
import com.joshgm3z.talker.common.room.TalkerDb
import com.joshgm3z.talker.common.utils.SharedPref
import com.joshgm3z.talker.frx.LoginRepository
import com.joshgm3z.talker.frx.LoginViewModel
import com.joshgm3z.talker.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            get(),
            TalkerDb::class.java, "talker-db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
    single {
        FirestoreManager()
    }
    single {
        SharedPref(get())
    }
    single {
        TalkerRepository(get(), get())
    }
    single {
        LoginRepository(get(), get())
    }
    viewModel {
        ChatViewModel(get())
    }
    viewModel {
        LoginViewModel(get())
    }
    viewModel {
        HomeViewModel(get(), get())
    }
}