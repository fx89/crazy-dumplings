package com.crazydumplings.rtcomm.model;

/**
 * When an object is spawned in the game world, the server sends the parameters of the spawning process to the clients, so that they can
 * replicate it locally
 */
public class CrazyDumplingsObjectSpawnData extends CrazyDumplingsWorldObjectData {
    public long                      objectType;
    public CrazyDumplingsCoordinates coordinates;

    public CrazyDumplingsObjectSpawnData(long source, long destination, long objectId, long objectType, CrazyDumplingsCoordinates coordinates) {
        super(source, destination, objectId);
        this.objectType = objectType;
        this.coordinates = coordinates;
    }

}
