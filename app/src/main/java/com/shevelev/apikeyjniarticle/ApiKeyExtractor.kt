package com.shevelev.apikeyjniarticle

class ApiKeyExtractor {
    private external fun getApiKey(id: Int, source: String): String

    fun getKey(): String {
        // For the initial encryption
        //return getApiKey(1, "In a hole in the ground there lived a hobbit.")

        // For the normal decryption
        return getApiKey(2, BuildConfig.MY_API_KEY)
    }

    companion object{
        init {
            // Load the library
            System.loadLibrary("native-lib")
        }
    }
}