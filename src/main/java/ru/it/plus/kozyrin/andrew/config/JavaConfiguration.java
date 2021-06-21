package ru.it.plus.kozyrin.andrew.config;

public class JavaConfiguration implements Configuration{
    @Override
    public String getPackageToScan() {
        return "ru.it.plus.kozyrin.andrew";
    }
}
