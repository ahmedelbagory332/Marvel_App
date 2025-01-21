package com.example.domain.utils

import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

fun String.encodeForRoute(): String =
    URLEncoder.encode(this, StandardCharsets.UTF_8.toString())


fun String.decodeFromRoute(): String =
    URLDecoder.decode(this, StandardCharsets.UTF_8.toString())
