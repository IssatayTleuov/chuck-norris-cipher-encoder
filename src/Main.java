import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation = getOperation(scanner);
        while (!operation.equals("exit")) {
            if (operation.equals("encode")) {
                System.out.println("Input string:");
                String input = scanner.nextLine();
                String binary = Encoder.getBinary(input);
                String encoded = Encoder.encode(binary);
                System.out.println("Encoded string:");
                System.out.println(encoded + "\n");
            } else if (operation.equals("decode")) {
                System.out.println("Input encoded string:");
                String input = scanner.nextLine();
                boolean isValid = Validator.validate(input);
                String binary = Decoder.decode(input);
                boolean isMultipleOf7 = Validator.isMultipleOf7(binary);
                if (!(isValid && isMultipleOf7)) {
                    System.out.println("Encoded string is not valid.\n");
                    operation = getOperation(scanner);
                    continue;
                }
                String decoded = Decoder.binaryToChar(binary);
                System.out.println("Decoded string:");
                System.out.println(decoded + "\n");
            } else {
                System.out.println("There is no '" + operation + "' operation\n");
            }
            operation = getOperation(scanner);
        }
        System.out.println("Bye!");
    }

    private static String getOperation(Scanner scanner) {
        System.out.println("Please input operation (encode/decode/exit):");
        return scanner.nextLine();
    }
}
