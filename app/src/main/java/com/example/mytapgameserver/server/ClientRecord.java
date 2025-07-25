package com.example.mytapgameserver.server;

import static rikka.shizuku.ShizukuApiConstants.REQUEST_PERMISSION_REPLY_ALLOWED;

import android.os.Bundle;

import com.example.mytapgameserver.server.IShizukuApplication;
import com.example.mytapgameserver.server.util.ServerLog;

public class ClientRecord {

    protected static final ServerLog LOGGER = new ServerLog("ClientRecord");

    public final int uid;
    public final int pid;
    public final IShizukuApplication client;
    public final String packageName;
    public final int apiVersion;
    public boolean allowed;

    public ClientRecord(int uid, int pid, IShizukuApplication client, String packageName, int apiVersion) {
        this.uid = uid;
        this.pid = pid;
        this.client = client;
        this.packageName = packageName;
        this.allowed = false;
        this.apiVersion = apiVersion;
    }

    public void dispatchRequestPermissionResult(int requestCode, boolean allowed) {
        Bundle reply = new Bundle();
        reply.putBoolean(REQUEST_PERMISSION_REPLY_ALLOWED, allowed);
        try {
            client.dispatchRequestPermissionResult(requestCode, reply);
        } catch (Throwable e) {
            LOGGER.w(e, "dispatchRequestPermissionResult failed for client (uid=%d, pid=%d, package=%s)", uid, pid, packageName);
        }
    }
}
