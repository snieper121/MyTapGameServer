package com.example.mytapgameserver.server;

interface IShizukuServiceConnection {

    oneway void connected(IBinder service);

    oneway void died();
}
