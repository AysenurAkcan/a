package com.aysenurakcan.dg_son.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.aysenurakcan.dg_son.data.Note

data class NoteState(

    val notes: List<Note> = emptyList(),
    val baslık: MutableState<String> = mutableStateOf(""),
    val not: MutableState<String> = mutableStateOf("")

)