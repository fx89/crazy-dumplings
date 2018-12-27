package com.crazydumplings.rtcomm.model;

import static com.crazydumplings.rtcomm.model.CrazyDumplingsRealtimeDataType.*;

public class CrazyDumplingsWorldObjectData extends CrazyDumplingsRealtimeData {
    public long objectId;

    public CrazyDumplingsWorldObjectData(long source, long destination, long objectId) {
        super(source, destination);
        this.objectId = objectId;
        this.dataType = DATA_TYPE_NONE;
    }

}
