package com.example.myartist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artists(
    val name: String,
    val desription: String,
    val photo: Int
) : Parcelable