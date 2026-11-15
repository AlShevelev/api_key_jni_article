package com.shevelev.apikeyjniarticle

open class ApiKeyExtractor {
    protected external fun getApiKey(operationId: Int, source: String): String

    fun getKey(): String {
        return getApiKey(2, BuildConfig.MY_API_KEY)
    }

    companion object{
        init {
            System.loadLibrary("native-lib")
        }
    }
}