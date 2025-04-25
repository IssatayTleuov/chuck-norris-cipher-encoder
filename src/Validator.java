public class Validator {
    public static boolean validate(String encoded) {
        boolean isZeroAndSpace = checkByRegex(encoded);
        boolean isZeroBlocks = checkBlocks(encoded);
        boolean isOdd = isOdd(encoded);
        return isZeroAndSpace && isZeroBlocks && isOdd;
    }

    public static boolean checkByRegex(String encoded) {
        String regex = "^[0 ]*$";
        return encoded.matches(regex);
    }

    public static boolean checkBlocks(String encoded) {
        boolean isStartWithZero = false;
        String[] encodedBinaryArray = encoded.split(" ");
        for (int i = 0; i < encodedBinaryArray.length; i += 2) {
            if (encodedBinaryArray[i].equals("0") || encodedBinaryArray[i].equals("00")) {
                isStartWithZero = true;
            } else {
                isStartWithZero = false;
            }
        }
        return isStartWithZero;
    }

    public static boolean isOdd(String encoded) {
        String[] encodedBinaryArray = encoded.split(" ");
        return encodedBinaryArray.length % 2 == 0;
    }

    public static boolean isMultipleOf7(String binary) {
        return binary.length() % 7 == 0;
    }
}
