package com.crazydumplings.rtcomm;

import com.crazydumplings.rtcomm.exception.CrazyDumplingsInGameCommException;
import com.crazydumplings.rtcomm.model.CrazyDumplingsRealtimeData;

/** 
 * 
 */
public interface CrazyDumplingsDataReceivedCallback {
    void processData(CrazyDumplingsRealtimeData data) throws CrazyDumplingsInGameCommException;
}
