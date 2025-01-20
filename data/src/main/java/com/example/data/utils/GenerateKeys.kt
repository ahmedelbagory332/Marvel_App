package com.example.data.utils

import com.example.data.BuildConfig
import java.security.MessageDigest
import kotlin.random.Random

object GenerateKeys {
    private val randomNumber = Random.nextInt(1000000)
    val ts = randomNumber
    val concatenatedString = ts.toString() + BuildConfig.MARVEL_PRIVATE_KEY + BuildConfig.MARVEL_PUBLIC_KEY
    val md5Hash = md5(concatenatedString)
    private fun md5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        val bytes = md.digest(input.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }
}