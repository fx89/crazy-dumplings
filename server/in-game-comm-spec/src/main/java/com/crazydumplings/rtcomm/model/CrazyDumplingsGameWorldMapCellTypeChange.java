package com.crazydumplings.rtcomm.model;

public class CrazyDumplingsGameWorldMapCellTypeChange extends CrazyDumplingsGameWorldChange {
    private int  x, y;
    private long newCellTypeId;

    public CrazyDumplingsGameWorldMapCellTypeChange(long source, long destination, int x, int y, long newCellTypeId) {
        super(source, destination);
        setX(x);
        setY(y);
        setNewCellTypeId(newCellTypeId);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public long getNewCellTypeId() {
        return newCellTypeId;
    }

    public void setNewCellTypeId(long newCellTypeId) {
        this.newCellTypeId = newCellTypeId;
    }

}
