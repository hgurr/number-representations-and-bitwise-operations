package cs250.hw1;

public class Operations {
    public static void main(String[] args) {
        // TASK 1
        System.out.println("Task 1");

        if (args.length != 3) {
            System.out.println("Incorrect number of arguments have been provided. Program Terminating!");
            System.exit(0);
        } else {
            System.out.println("Correct number of arguments given.");
        }

        // TASK 2
        System.out.println("Task 2");

        String[] types = new String[args.length];

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            String type;

            // Binary
            if (arg.startsWith("0b") || arg.startsWith("0B")) {
                type = "Binary";
            }
            // Hexadecimal
            else if (arg.startsWith("0x") || arg.startsWith("0X")) {
                type = "Hexadecimal";
            }
            // Decimal
            else {
                type = "Decimal";
            }

            types[i] = type;
            System.out.println(arg + "=" + type);
        }

        // TASK 3
        System.out.println("Task 3");

        boolean invalidInput = false;

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            String t = types[i];
            boolean valid = true;

            // Binary
            if (t.equals("Binary")) {
                for (int j = 2; j < arg.length(); j++) {
                    if (arg.charAt(j) != '0' && arg.charAt(j) != '1') {
                        valid = false;
                        break;
                    }
                }
            }
            // Hexadecimal
            else if (t.equals("Hexadecimal")) {
                for (int j = 2; j < arg.length(); j++) {
                    if (!((arg.charAt(j) >= '0' && arg.charAt(j) <= '9') || (arg.charAt(j) >= 'a' && arg.charAt(j) <= 'f') || (arg.charAt(j) >= 'A' && arg.charAt(j) <= 'F'))) {
                        valid = false;
                        break;
                    }
                }
            }
            // Decimal
            else {
                for (int j = 0; j < arg.length(); j++) {
                    if (arg.charAt(j) < '0' || arg.charAt(j) > '9') {
                        valid = false;
                        break;
                    }
                }

            }

            System.out.println(arg + "=" + valid);

            if (!valid) {
                invalidInput = true;
            }
        }
            if (invalidInput) {
                System.exit(0);
            }

        // TASK 4 (INCLUDES HELPER METHOD)
        System.out.println("Task 4");
        
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            String t = types[i];
            int value;

            if (t.equals("Binary")) {
                value = binaryToDecimal(arg);
            } else if (t.equals("Hexadecimal")) {
                value = hexaToDecimal(arg);
            } else {
                value = decimalToInteger(arg);
            }

            String binaryString = "0b" + decimalToBinary(value);
            String hexaString = "0x" + decimalToHexa(value).toLowerCase();

            System.out.println("Start=" + arg + ", Binary=" + binaryString + ", Decimal=" + value + ", Hexadecimal=" + hexaString);
        }

        // TASK 5 (INCLUDES HELPER METHOD)
        System.out.println("Task 5");

        for (int i = 0; i < args.length; i ++) {
            String arg = args[i];
            String t = types[i];
            int value;

            if (t.equals("Binary")) {
                value = binaryToDecimal(arg);
            } else if (t.equals("Hexadecimal")) {
                value = hexaToDecimal(arg);
            } else {
                value = decimalToInteger(arg);
            }

            String binaryString = decimalToBinary(value);
            String onesComp = onesComplement(binaryString);

            System.out.print(arg + "=" + binaryString + "=>" + onesComp + "\n");
        }

        // TASK 6 (INCLUDES HELPER METHOD)
        System.out.println("Task 6");

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            String t = types[i];
            int value;

            if (t.equals("Binary")) {
                value = binaryToDecimal(arg);
            } else if (t.equals("Hexadecimal")) {
                value = hexaToDecimal(arg);
            } else {
                value = decimalToInteger(arg);
            }

            String binaryString = decimalToBinary(value);
            String twosComp = twosComplement(binaryString);

            System.out.println(arg + "=" + binaryString + "=>" + twosComp);
        }

        // TASK 7 (INCLUDES HELPER METHOD)
        System.out.println("Task 7");

        int[] values = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            if (types[i].equals("Binary")) {
                values[i] = binaryToDecimal(args[i]);
            } else if (types[i].equals("Hexadecimal")) {
                values[i] = hexaToDecimal(args[i]);
            } else {
                values[i] = decimalToInteger(args[i]);
            }
        }

        String[] binaries = new String[values.length];

        for (int i = 0; i < values.length; i++) {
            binaries[i] = decimalToBinary(values[i]);
        }
        int maxLength = 0;
        for (String b : binaries) {
            if (b.length() > maxLength) maxLength = b.length();
        }

        String[] padding = new String[binaries.length];
        for (int i = 0; i < binaries.length; i++) {
            padding[i] = leftPadding(binaries[i], maxLength);
        }

        String orResult  = OR(padding);
        String andResult = AND(padding);
        String xorResult = XOR(padding);

        System.out.println(binaries[0] + "|" + binaries[1] + "|" + binaries[2] + "=" + orResult);
        System.out.println(binaries[0] + "&" + binaries[1] + "&" + binaries[2] + "=" + andResult);
        System.out.println(binaries[0] + "^" + binaries[1] + "^" + binaries[2] + "=" + xorResult);

        // TASK 8
        System.out.println("Task 8");

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            String t = types[i];
            int value;

            if (t.equals("Binary")) {
                value = binaryToDecimal(arg);
            } else if (t.equals("Hexadecimal")) {
                value = hexaToDecimal(arg);
            } else {
                value = decimalToInteger(arg);
            }

            String binaryString = decimalToBinary(value);
            String leftShift = binaryString + "00";

            String rightShift;

            if (binaryString.length() <= 2) {
                rightShift = "0";
            } else {
                rightShift = binaryString.substring(0, binaryString.length() - 2);
            }

            System.out.println(binaryString + "<<2=" + leftShift + "," + binaryString + ">>2=" + rightShift);
        }
    }

    // HELPER METHODS (TASKS 4-7)
    // ===== TASK 4 =====
    // Binary to Decimal
    public static int binaryToDecimal(String binary) {
        int result = 0;
        int exponent = 0;

        for (int i = binary.length() - 1; i >= 2; i--) {
            int bit;

            if (binary.charAt(i) == '1') {
                bit = 1;
            } else {
                bit = 0;
            }

            result += bit * Math.pow(2, exponent);
            exponent++;
        }

        return result;
    }
    // Hexadecimal to Decimal
    public static int hexaToDecimal(String hexa) {
        int result = 0;
        int exponent = 0;

        for (int i = hexa.length() - 1; i >= 2; i--) {
            int alphanumeric;

            if (hexa.charAt(i) >= '0' && hexa.charAt(i) <= '9') {
                alphanumeric = hexa.charAt(i) - '0';
            } else if (hexa.charAt(i) >= 'a' && hexa.charAt(i) <= 'f') {
                alphanumeric = 10 + (hexa.charAt(i) - 'a');       
            } else {
                alphanumeric = 10 + (hexa.charAt(i) - 'A');
            }

            result += alphanumeric * Math.pow(16, exponent);
            exponent++;
        }

        return result;
    }

    // Decimal to Binary
    public static String decimalToBinary(int decimal) {
        String result = "";
        if (decimal == 0) {
            return "0";
        }
        while (decimal > 0) {
            int remainder = decimal % 2;
            result = remainder + result;
            decimal /= 2;
        }

        return result;
    }
    // Decimal to Hexadecimal
    public static String decimalToHexa(int decimal) {
        String hexaDigits = "0123456789ABCDEF";
        String result = "";

        if (decimal == 0) {
            return "0";
        }
        while (decimal > 0) {
            int remainder = decimal % 16;
            result = hexaDigits.charAt(remainder) + result;
            decimal /= 16;
        }

        return result;
    }

    // Decimal to Integer
    public static int decimalToInteger(String decimal) {
        int result = 0;
        for (int i = 0; i < decimal.length(); i++) {
            result = result * 10 + (decimal.charAt(i) - '0');
        }

        return result;
    }

    // ===== TASK 5 =====
    public static String onesComplement(String binary) {
        String result = "";
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                result += "1";
            } else {
                result += "0";
            }
        }

        return result;
    }

    // ===== TASK 6 =====
    public static String twosComplement(String binary) {
        String ones = onesComplement(binary);
        String result = "";
        int carry = 1;

        for (int i = ones.length() - 1; i >= 0; i--) {
            int bit = ones.charAt(i) - '0';
            int sum = bit + carry;

            if (sum == 2) {
                result = "0" + result;
                carry = 1;
            } else {
                result = sum + result;
                carry = 0;
            }
        }
        if (carry == 1) {
            result = "1" + result;
        }

        return result;
    }

    // ===== TASK 7 =====
    public static String leftPadding(String s, int length) {
        while (s.length() < length) {
            s = "0" + s;
        }

        return s;
    }

    // OR
    public static String OR(String[] binaries) {
        int len = binaries[0].length();
        String result = "";
        
        for (int i = 0; i < len; i++) {
            char bit = '0';

            for (String b : binaries) {
                if (b.charAt(i) == '1') {
                    bit = '1';
                    break;
                }
            }

            result += bit;
        }

        return result;
    }

    // AND
    public static String AND(String[] binaries) {
        int len = binaries[0].length();
        String result = "";

        for (int i = 0; i < len; i++) {
            char bit = '1';

            for (String b : binaries) {
                if (b.charAt(i) == '0') {
                    bit = '0';
                    break;
                }
            }

            result += bit;
        }

        return result;
    }

    // XOR
    public static String XOR(String[] binaries) {
        int len = binaries[0].length();
        String result = "";

        for (int i = 0; i < len; i++) {
            int countOnes = 0;

            for (String b : binaries) {
                if (b.charAt(i) == '1') {
                    countOnes++;
                }
            }
            if (countOnes % 2 == 1) {
                result += '1';
            } else {
                result += '0';
            }
        }

        return result;
    }
}