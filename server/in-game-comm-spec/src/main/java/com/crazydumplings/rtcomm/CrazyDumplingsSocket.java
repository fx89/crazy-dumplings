package com.crazydumplings.rtcomm;

import com.crazydumplings.rtcomm.exception.CrazyDumplingsClientSocketException;
import com.crazydumplings.rtcomm.model.CrazyDumplingsRealtimeData;

/**
 * Common components of the client and server sockets
 */
public interface CrazyDumplingsSocket {
    void setCallback(CrazyDumplingsDataReceivedCallback callback);

    void sendData(CrazyDumplingsRealtimeData data) throws CrazyDumplingsClientSocketException;

    boolean isConnected();
}
