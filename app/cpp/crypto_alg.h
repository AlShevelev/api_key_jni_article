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
 * @param plaintext String to be encrypted. Handles utf-8.
 * @param password Password to be used for encryption
 * @return Encrypted text as uint32_t vector
 */
    extern bytes encrypt(const std::string &plaintext, const std::string &password);

/**
 * Decrypts text
 * @param encrypted_string @see encrypt
 * @param password password used to encrypt the string
 * @return utf8 encoded string
 */
    extern std::string decrypt(bytes &encrypted_string, const std::string &password);
}