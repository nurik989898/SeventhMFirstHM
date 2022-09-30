package com.example.seventhmfirsthm.domain.model

data class Note(
    var id: Int = DEFAULT_ID,
    var title: String? = null,
    var description: String? = null,
) {
    companion object {
        const val DEFAULT_ID = 0
    }
}
