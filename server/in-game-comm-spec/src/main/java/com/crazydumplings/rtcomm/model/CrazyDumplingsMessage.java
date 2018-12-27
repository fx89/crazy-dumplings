package com.crazydumplings.rtcomm.model;

/**
 * Messaging between client and server. For example: before the game starts the server needs to know that all clients have downloaded and
 * created the game world locally. Thus, the server sends the REQUEST_STATUS message to all clients and each client replies with either WORKING
 * or IDLE.
 */
public class CrazyDumplingsMessage extends CrazyDumplingsRealtimeData {
    public static final long MSG_IDLE           = 0x0000;
    public static final long MSG_WORKING        = 0x0001;
    public static final long MSG_REQUEST_STATUS = 0x0002;

    public long              state;

    public CrazyDumplingsMessage(long source, long destination, long state) {
        super(source, destination);
        this.state = state;
    }
}
