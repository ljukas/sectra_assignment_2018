package com.company;

import static java.lang.Math.min;

public abstract class Image {
    private int sizeX = 0;
    private int sizeY = 0;
    private int pyramidLevels = 0;
    private int compressedSize = 0;
    private boolean grouped = false;


    private int calcPyramidLevels() {
        int smallestAxel = min(sizeX, sizeY) / 2;
        int levels = 0;
        while (smallestAxel >= 128) {
            levels++;
            smallestAxel = smallestAxel / 2;
        }
        return levels;
    }

    public abstract int compressedSize();

    int getSizeX() {
        return sizeX;
    }

    void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    int getSizeY() {
        return sizeY;
    }

    void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    int getPyramidLevels() {
        return pyramidLevels;
    }

    void setPyramidLevels() {
        this.pyramidLevels = calcPyramidLevels();
    }

    void setCompressedSize(int compressedSize) {
       this.compressedSize  = compressedSize;
    }

    boolean isGrouped() {
        return grouped;
    }

    void setGrouped(boolean grouped) {
        this.grouped = grouped;
    }
}
