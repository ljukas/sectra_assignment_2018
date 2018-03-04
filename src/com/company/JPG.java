package com.company;

public class JPG extends Image {
    JPG(int x, int y) {
        this.setSizeX(x);
        this.setSizeY(y);
        this.setPyramidLevels();
        this.setCompressedSize(compressedSize());
    }


    @Override
    public int compressedSize() {
        int comp = this.getSizeX() * this.getSizeY() / 5;

        int pySize = comp;
        for (int i = 1; i <= this.getPyramidLevels(); i++) {
           pySize = pySize / 4;
           comp += pySize;
        }

        // Casting to int will always truncate as per instructions.
        return comp;
    }
}
