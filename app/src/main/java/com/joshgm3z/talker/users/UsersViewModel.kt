package com.joshgm3z.talker.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joshgm3z.talker.common.TalkerRepository
import com.joshgm3z.talker.common.room.entity.User
import kotlinx.coroutines.launch

class UsersViewModel(private val talkerRepository: TalkerRepository) : ViewModel() {

    lateinit var userList: List<User>

    init {
        viewModelScope.launch {
            userList = talkerRepository.getAllUsers()
        }
    }
}