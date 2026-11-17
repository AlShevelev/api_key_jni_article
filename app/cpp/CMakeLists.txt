cmake_minimum_required(VERSION 4.0.2)

add_library(native-lib SHARED
        consts.h
        consts.cpp
        facade.cpp
        crypto_alg.h
        crypto_alg.cpp
)
