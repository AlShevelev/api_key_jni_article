#include <jni.h>
#include <string>
#include <iostream>
#include <vector>
#include <cstdint>
#include <sstream>
#include <iterator>
#include "consts.h"
#include "xxtea.cpp"

std::string getData(int operationId, const std::string& key, const std::string& data) {
    switch (operationId) {
        // Encrypting
        case 1: {
            auto encryptedBytes = xxtea::encrypt(data, key);

            std::stringstream result;

            std::copy(
                    encryptedBytes.begin(),
                    encryptedBytes.end(),
                    std::ostream_iterator<std::uint32_t>(result, " ")
            );

            return result.str();
        }

        // Decrypting
        case 2: {
            std::istringstream inputStream(data);

            std::vector<std::uint32_t> bytesToDecrypt{
                    std::istream_iterator<std::uint32_t>(inputStream),
                    std::istream_iterator<std::uint32_t>()
            };

            return xxtea::decrypt(bytesToDecrypt, key);
        }

        default: return "";
    }
}

extern "C" jstring
Java_com_shevelev_apikeyjniarticle_ApiKeyExtractor_encrypt(
        JNIEnv *env,
        jobject /* this */,
        jstring sourceData,
        jstring sourceKey
) {
    std::string key = env->GetStringUTFChars(sourceKey, nullptr);
    std::string data = env->GetStringUTFChars(sourceData, nullptr);

    std::string result = getData(1, key, data);
    return env->NewStringUTF(result.c_str());
}

extern "C" jstring
Java_com_shevelev_apikeyjniarticle_ApiKeyExtractor_decrypt(
        JNIEnv *env,
        jobject /* this */,
        jstring sourceData,
        jstring sourceKey
) {
    std::string key = env->GetStringUTFChars(sourceKey, nullptr);
    std::string data = env->GetStringUTFChars(sourceData, nullptr);

    std::string result = getData(2, key, data);
    return env->NewStringUTF(result.c_str());
}

extern "C" jstring
Java_com_shevelev_apikeyjniarticle_ApiKeyExtractor_getApiKey(
        JNIEnv *env,
        jobject /* this */
) {
    std::string key = Consts::KEY;
    std::string data = Consts::DATA;

    std::string result = getData(2, key, data);
    return env->NewStringUTF(result.c_str());
}