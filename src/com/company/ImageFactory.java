package com.company;

public class ImageFactory {
    public static Image createImage(String args[]) {
        int x = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        switch (args[0]) {
            case "J":
            case "JPG":
                return new JPG(x, y);
            case "JP2":
            case "JPEG2000":
                return new JPEG2000(x, y);
            default:
                return new BMP(x, y);
        }
    }
}
