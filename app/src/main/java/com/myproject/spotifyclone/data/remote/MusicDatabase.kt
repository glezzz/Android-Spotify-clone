package com.myproject.spotifyclone.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.myproject.spotifyclone.data.entities.Song
import com.myproject.spotifyclone.other.Constansts.SONG_COLLECTION
import kotlinx.coroutines.tasks.await

class MusicDatabase {

    // get instance to Firebase Firestore Singleton
    private val firestore = FirebaseFirestore.getInstance()
    // retrieve all songs from db as a list
    private val songCollection = firestore.collection(SONG_COLLECTION)

    // coroutines
    // get songs from firestore
    suspend fun getAllSongs(): List<Song> {
        return try {
            // await() returns type any
            songCollection.get().await().toObjects(Song::class.java)

        } catch (e: Exception) {
            emptyList()
        }
    }
}