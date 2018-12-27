package com.crazydumplings.rtcomm.model;

import static com.crazydumplings.rtcomm.model.CrazyDumplingsRealtimeDataType.*;

/**
 * Contains common attributes of all data objects sent and/or received through the
 * {@link com.desolatetimelines.crazydumplings.rtcomm.CrazyDumplingSSLSocket game sockets}
 */
public class CrazyDumplingsRealtimeData {
    public long                           source;
    public long                           destination;
    public CrazyDumplingsRealtimeDataType dataType;

    public CrazyDumplingsRealtimeData(long source, long destination) {
        this.source = source;
        this.destination = destination;
        this.dataType = DATA_TYPE_NONE;
    }
}
