#pragma once
#include <vector>
#include <string>
#include <cstdint>
#include <climits>
#include <limits>

namespace CryptoAlg {
    using bytes = std::vector<std::uint32_t>;

/**
 *  Encrypts text
 * @param plainText String to be encrypted. Handles utf-8.
 * @param encryptionKey Password to be used for encryption
 * @return Encrypted text as uint32_t vector
 */
    extern bytes encrypt(const std::string &plainText, const std::string &encryptionKey);

/**
 * Decrypts text
 * @param encrypted_string @see encrypt
 * @param encryptionKey password used to encrypt the string
 * @return utf8 encoded string
 */
    extern std::string decrypt(bytes &encrypted_string, const std::string &encryptionKey);
}