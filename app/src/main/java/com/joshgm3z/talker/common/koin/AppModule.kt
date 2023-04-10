package com.joshgm3z.talker

import androidx.room.Room
import com.joshgm3z.talker.chat.ChatRepository
import com.joshgm3z.talker.chat.ChatViewModel
import com.joshgm3z.talker.common.room.TalkerDb
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            get(),
            TalkerDb::class.java, "talker-db")
            .fallbackToDestructiveMigration()
            .build()
    }
    single {
        ChatRepository(get())
    }
    viewModel {
        ChatViewModel(get())
    }
}