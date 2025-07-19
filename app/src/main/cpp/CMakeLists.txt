
cmake_minimum_required(VERSION 3.18.1)
project("MyTapGameServer")
set(CMAKE_CXX_STANDARD 17)
add_compile_options(-Werror=format -fdata-sections -ffunction-sections -fno-exceptions -fno-rtti -fno-threadsafe-statics)
find_library(log-lib log)

add_executable(tap_starter
        starter.cpp
        misc.cpp
        selinux.cpp
        cgroup.cpp
        android.cpp)
target_link_libraries(tap_starter PRIVATE ${log-lib})

add_library(wifi_pairing SHARED
        adb_pairing.cpp
        misc.cpp)
target_link_libraries(wifi_pairing PRIVATE ${log-lib})

