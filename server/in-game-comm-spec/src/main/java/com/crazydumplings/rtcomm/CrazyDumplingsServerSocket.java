package com.crazydumplings.rtcomm;

import com.crazydumplings.rtcomm.exception.CrazyDumplingsClientSocketException;

/**
 * 
 */
public interface CrazyDumplingsServerSocket extends CrazyDumplingsSocket {
    void startListening(String interfaceName, int portNumber, CrazyDumplingsDataReceivedCallback onDataReceivedCallback) throws CrazyDumplingsClientSocketException;
}
