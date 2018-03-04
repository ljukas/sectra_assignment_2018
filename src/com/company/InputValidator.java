package com.company;

import java.util.Arrays;

public class InputValidator {
    public boolean isImageInput(String args[]) {
        if (args.length != 3) {
            return false;
        }

        if (invalidImageType(args[0])) {
            return false;
        }

        String sizeArgs[] = Arrays.copyOfRange(args, 1, args.length);
        if (invalidIntegerArguments(sizeArgs)) {
            return false;
        }

        return true;
    }

    // Checks if input is to group images.
    // ASSUMPTION: Both "g" and "G" are acceptable inputs.
    public boolean isGroupInput(String args[]) {
        if (args.length <= 2) {
            return false;
        }

        if (!args[0].toLowerCase().equals("g")) {
            return false;
        }

        // Gets all except the first element in the args array.
        String indexArgs[] = Arrays.copyOfRange(args, 1, args.length);
        if (invalidIntegerArguments(indexArgs)) {
           return false;
        }

        return true;
    }

    // Makes sure there is only one argument and its "Q" or "q".
    // ASSUMPTION: Both "Q" and "q" are acceptable inputs.
    public boolean isCalculateSizeInput(String args[]) {
        return args.length == 1 && args[0].toLowerCase().equals("q");
    }

    // Validates that the first argument given is a recognized image type.
    private static boolean invalidImageType(String arg) {
        for (ImageType it : ImageType.values()) {
            if (it.name().equals(arg)) {
                return false;
            }
        }
        return true;
    }

    // Validates all arguments to be integers and above 0..
    private static boolean invalidIntegerArguments(String args[]) {
        for (String arg: args) {
            try {
                int x = Integer.parseInt(arg);
                if (x <= 0) {
                    return true;
                }
            } catch (NumberFormatException e) {
                return true;
            }
        }
        return false;
    }
}
