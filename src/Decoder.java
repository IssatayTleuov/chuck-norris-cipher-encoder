public class Decoder {
    public static String decode(String encodedBinary) {
        String[] encodedBinaryArray = encodedBinary.split(" ");
        StringBuilder decodedBinaryBuilder = new StringBuilder();
        for (int i = 1; i < encodedBinaryArray.length; i += 2) {
            if ("0".equals(encodedBinaryArray[i - 1])) {
                decodedBinaryBuilder.append("1".repeat(encodedBinaryArray[i].length()));
            } else if ("00".equals(encodedBinaryArray[i - 1])) {
                decodedBinaryBuilder.append("0".repeat(encodedBinaryArray[i].length()));
            }
        }
        return decodedBinaryBuilder.toString();
    }

    public static String binaryToChar(String decodedBinary) {
        StringBuilder wordBuilder = new StringBuilder();
        int period = 7;
        for (int i = period; i < decodedBinary.length() + period; i += period) {
            String decodedBinaryCode = decodedBinary.substring(i - period, i);
            int decodedInt = Integer.parseInt(decodedBinaryCode, 2);
            char decodedChar = (char) decodedInt;
            wordBuilder.append(decodedChar);
        }
        return wordBuilder.toString();
    }
}
