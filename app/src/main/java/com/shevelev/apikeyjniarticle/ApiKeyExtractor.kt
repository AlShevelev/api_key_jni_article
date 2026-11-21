package com.shevelev.apikeyjniarticle

open class ApiKeyExtractor {
    protected external fun encryptOrDecrypt(
        operationId: Int,
        sourceData: String,
        sourceKey: String,
    ): String

    protected external fun getApiKey(): String

    fun getKey(): String = getApiKey()

    companion object{
        init {
            System.loadLibrary("native-lib")
        }
    }
}