
cmake_minimum_required(VERSION 3.18.1)
project("MyTapGameServer")

set(CMAKE_CXX_STANDARD 17)
add_compile_options(-Werror=format -fdata-sections -ffunction-sections -fno-exceptions -fno-rtti -fno-threadsafe-statics)

# Находим системную библиотеку логирования
find_library(log-lib log)

# Находим библиотеки BoringSSL и CXX из NDK
find_package(boringssl REQUIRED CONFIG)
find_package(cxx REQUIRED CONFIG)

# Цель для tap_starter
add_executable(tap_starter
        starter.cpp
        misc.cpp
        selinux.cpp
        cgroup.cpp
        android.cpp)
# Указываем, что tap_starter зависит от системной библиотеки логов и cxx
target_link_libraries(tap_starter PRIVATE ${log-lib} cxx::cxx)

# Цель для wifi_pairing
add_library(wifi_pairing SHARED
        adb_pairing.cpp
        misc.cpp)
# Указываем, что wifi_pairing зависит от логов, BoringSSL и cxx
target_link_libraries(wifi_pairing PRIVATE ${log-lib} boringssl::crypto_static cxx::cxx)

