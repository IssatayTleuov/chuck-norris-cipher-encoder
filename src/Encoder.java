public class Encoder {
    public static String encode(String binaryCode) {
        char[] binaryCodeChars = binaryCode.toCharArray();
        StringBuilder encodedStringBuilder = new StringBuilder();
        int count = 0;
        char temp = binaryCodeChars[0];
        for (int i = 0; i < binaryCodeChars.length; i++) {
            if (binaryCodeChars[i] == temp) {
                count++;
            } else {
                encodedStringBuilder.append(merge(count, temp));
                count = 1;
                temp = binaryCodeChars[i];
            }
        }
        encodedStringBuilder.append(merge(count, temp));
        return encodedStringBuilder.toString();
    }

    public static String getBinary(String text) {
        char[] chars = text.toCharArray();
        StringBuilder resultBinaryBuilder = new StringBuilder();
        for (char aChar : chars) {
            StringBuilder binaryCharBuilder = new StringBuilder(Integer.toBinaryString(aChar));
            if (binaryCharBuilder.toString().length() < 7) {
                binaryCharBuilder.insert(0, "0");
            }
            String binaryChar = binaryCharBuilder.toString();
            resultBinaryBuilder.append(binaryChar);
        }
        return resultBinaryBuilder.toString();
    }

    public static String merge(int count, char binaryNum) {
        StringBuilder encodedStringBuilder = new StringBuilder();
        if (binaryNum == '0') {
            encodedStringBuilder.append("00 ");
        } else if (binaryNum == '1') {
            encodedStringBuilder.append("0 ");
        }
        encodedStringBuilder.append("0".repeat(count)).append(" ");
        return encodedStringBuilder.toString();
    }
}
