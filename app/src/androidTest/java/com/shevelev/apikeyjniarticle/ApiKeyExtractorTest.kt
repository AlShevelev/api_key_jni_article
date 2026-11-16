package com.shevelev.apikeyjniarticle

import org.junit.Assert.assertEquals
import org.junit.Test

class ApiKeyExtractorTest : ApiKeyExtractor() {
    fun encryptData(data: String, key: String): String {
        return encrypt(data, key)
    }

    fun decryptData(data: String, key: String): String {
        return decrypt(data, key)
    }

    @Test
    fun simpleDecryptionAndEncryptionTest() {
        // Arrange
        val source = "In a distant and second-hand set of dimensions, in an astral plane that " +
            "was never meant to fly, the curling star-mists waver and part..."
        val key = "@qyj%4m4JV#EWfc%PWUR8BnbM**&5z9#@zg!g3XUkE9EF94gAEV6M%!j*4gp!MH#"

        // Act
        val encrypted = encryptData(source, key)
        val decrypted = decryptData(encrypted, key)

        // Assert
        assertEquals(source, decrypted)
    }
}
