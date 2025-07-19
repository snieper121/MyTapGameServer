#!/bin/bash
set -e # Остановить скрипт при любой ошибке

# Переходим в домашнюю директорию
cd ~

# Скачиваем инструменты командной строки
wget https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip

# Создаем папку для SDK и распаковываем
mkdir -p android-sdk/cmdline-tools
unzip commandlinetools-linux-11076708_latest.zip -d android-sdk/cmdline-tools
mv android-sdk/cmdline-tools/cmdline-tools android-sdk/cmdline-tools/latest
rm commandlinetools-linux-11076708_latest.zip

# Принимаем лицензии и устанавливаем необходимые пакеты
yes | $HOME/android-sdk/cmdline-tools/latest/bin/sdkmanager --licenses
$HOME/android-sdk/cmdline-tools/latest/bin/sdkmanager "platforms;android-36" "build-tools;36.0.0" "cmake;4.0.2"

echo "Android SDK installed successfully!"