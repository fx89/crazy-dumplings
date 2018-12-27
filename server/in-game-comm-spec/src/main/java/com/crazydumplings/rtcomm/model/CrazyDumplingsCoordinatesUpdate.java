package com.crazydumplings.rtcomm.model;

/**
 * The server sends frequent updates of the coordinates of each object in the game world to each client
 */
public class CrazyDumplingsCoordinatesUpdate extends CrazyDumplingsWorldObjectData {
    public CrazyDumplingsCoordinates coordinates;

    public CrazyDumplingsCoordinatesUpdate(long source, long destination, long objectId, CrazyDumplingsCoordinates coordinates) {
        super(source, destination, objectId);
        this.coordinates = coordinates;
    }

}
