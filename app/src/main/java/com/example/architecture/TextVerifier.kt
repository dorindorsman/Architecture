package com.example.architecture


class TextVerifier() {

    fun checkIntOrEmpty(txt: String): Int? {
        if (txt.isEmpty()) {
            return null
        }
        return try {
            txt.toInt()
        } catch (e: NumberFormatException) {
            null
        }
    }
}