package com.company;

import java.io.Console;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        System.out.println("Storage calculator by Lukas Lindqvist.");
        System.out.println("Enter one line for each image/group on the format 'type width height', or 'G i, i, ...'. Exit with 'Q'.");

        InputValidator iv = new InputValidator();
        ImageList imgList = new ImageList();
        while (true) {
            String input[] = getUserInput(c);
            if (iv.isImageInput(input)) {
                imgList.addImage(ImageFactory.createImage(input));
            } else if (iv.isGroupInput(input)) {
                // Remove the G.
                String[] strStack = Arrays.copyOfRange(input, 1, input.length);
                ArrayList<Integer> stack = convertStringArrayToIntArrayList(strStack);
                if (!imgList.addStack(stack)) {
                    System.out.println("One or more images are already used in another group.");
                }
            } else if (iv.isCalculateSizeInput(input)) {
                // Use france format to get the sought after format with spaces.
                NumberFormat nf = NumberFormat.getNumberInstance(Locale.FRANCE);

                System.out.println("Total size: " + nf.format(imgList.compressedSize()) + " bytes");
                System.exit(0);
            } else {
                System.out.println("Erroneous input, please try again.");
            }
        }
    }

    // Gets user input from command line.
    private static String[] getUserInput(Console c) {
        String input = c.readLine();
        return input.split(" ");
    }

    private static ArrayList<Integer> convertStringArrayToIntArrayList(String[] input) {
        ArrayList<Integer> stack = new ArrayList<>();
        for (String index : input) {
            stack.add(Integer.parseInt(index));
        }
        return stack;
    }

}
