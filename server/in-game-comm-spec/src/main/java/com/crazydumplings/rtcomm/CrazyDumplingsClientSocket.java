package com.crazydumplings.rtcomm;

import com.crazydumplings.rtcomm.exception.CrazyDumplingsClientSocketException;

/**
 * Defines the functionality of a client socket
 */
public interface CrazyDumplingsClientSocket extends CrazyDumplingsSocket {
    /**
     * Establishes a connection to a server socket
     * @param serverAddress
     * @param serverPort
     * @param onDataReceivedCallback
     */
    void connect(String serverAddress, int portNumber, CrazyDumplingsDataReceivedCallback onDataReceivedCallback) throws CrazyDumplingsClientSocketException;

    void disconnect() throws CrazyDumplingsClientSocketException;

}
