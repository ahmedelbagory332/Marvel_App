package com.example.data.utils

fun  String?.landscapeIncredible (): String? =
    if (!this.isNullOrEmpty())
        "$this/landscape_incredible.jpg"
    else this

fun  String?.portraitXlarge (): String? =
    if (!this.isNullOrEmpty())
        "$this/portrait_uncanny.jpg"
    else this