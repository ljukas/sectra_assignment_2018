package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ImageList {
    private ArrayList<Image> imgList = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> stacks = new ArrayList<>();


    public void addImage(Image image) {
        this.imgList.add(image);
    }

    // Will set which images are stacked together, if possible.
    public boolean addStack(ArrayList<Integer> stack) {
        // Check if given stack images are already used in another stack.
        for (ArrayList<Integer> s : stacks) {
            for (int toFind : stack)  {
                if (s.contains(toFind)) {
                   return false;
                }
            }
        }
        this.stacks.add(stack);
        // Set grouped == true for all images in the stack.
        for (int i : stack) {
            // Index is i-1 since if you input G 1 2, it means image 1 and 2 but they are at index 0, 1.
            imgList.get(i-1).setGrouped(true);
        }
        return true;
    }

    // This calculates the total compressed size of the ImageList. Grouped images are counted seperatly.
    public int compressedSize() {
        // First calculate the total size of all ungrouped images.
        int totalSize = 0;
        for (Image img : imgList) {
            if (!img.isGrouped()) {
               totalSize += img.compressedSize();
            }
        }
        System.out.println("Ungrouped size: " + totalSize);
        // Calculate the final compressed size of each stack and add it to the total.
        for (ArrayList<Integer> stack : stacks) {
           totalSize += stackSize(stack);
        }
        return totalSize;
    }

    // Calculates the compressed size of a stack in the ImageList..
    private int stackSize(ArrayList<Integer> stack) {
        int stackSize = 0;
        for (int index : stack) {
            stackSize += imgList.get(index-1).compressedSize();
        }
        stackSize /= Math.log(stack.size() + 3);
        return stackSize;
    }
}
