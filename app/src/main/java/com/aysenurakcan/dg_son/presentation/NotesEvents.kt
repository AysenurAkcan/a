package com.aysenurakcan.dg_son.presentation

import com.aysenurakcan.dg_son.data.Note

sealed interface NotesEvent {
    object SortNotes: NotesEvent

    data class DeleteNote(val note: Note): NotesEvent

    data class SaveNote(
        val baslık: String,
        val not: String
    ): NotesEvent
}
