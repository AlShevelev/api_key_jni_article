package com.shevelev.apikeyjniarticle

import org.junit.Assert.assertEquals
import org.junit.Test

class ApiKeyExtractorTest : ApiKeyExtractor() {
    fun encrypt(s: String): String {
        return getApiKey(1, s)
    }

    fun decrypt(s: String): String {
        return getApiKey(2, s)
    }

    @Test
    fun simpleDecryptionAndEncryptionTest() {
        // Arrange
        val source = "In a distant and second-hand set of dimensions, in an astral plane that " +
            "was never meant to fly, the curling star-mists waver and part..."

        // Act
        val encrypted = encrypt(source)
        val decrypted = decrypt(encrypted)

        // Assert
        assertEquals(source, decrypted)
    }
}
