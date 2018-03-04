package com.company;

public class JPEG2000 extends Image {
    JPEG2000(int x, int y) {
        this.setSizeX(x);
        this.setSizeY(y);
        this.setCompressedSize(compressedSize());
    }

    @Override
    public int compressedSize() {
        double comp = this.getSizeX() * this.getSizeY() * 0.4;
        comp = comp / Math.log(Math.log((this.getSizeX() * this.getSizeY()) + 16));

        // Casting to int will always truncate as per instructions.
        return (int) comp;
    }
}
