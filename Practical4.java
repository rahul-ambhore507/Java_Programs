import java.util.Scanner;

public class Practical4 {

    // Conversion from one base to another
    void toXXSystem(String num, String xx) {
        int no = Integer.parseInt(num);

        String from_base = String.valueOf(xx.charAt(0));
        String to_base = String.valueOf(xx.charAt(1));   
        
        int decimalNumber = 0;
        if (from_base.equalsIgnoreCase("D")) {
            decimalNumber = no;
        } else if (from_base.equalsIgnoreCase("O")) {
            decimalNumber = to_decimal(no, 8);  
        } else if (from_base.equalsIgnoreCase("B")) {
            decimalNumber = to_decimal(no, 2);  
        } else if (from_base.equalsIgnoreCase("H")) {
            decimalNumber = to_decimal(no, 16);  
        }
        
        if (to_base.equalsIgnoreCase("O")) {
            from_decimal(decimalNumber, 8);  
        } else if (to_base.equalsIgnoreCase("B")) {
            from_decimal(decimalNumber, 2);  
        } else if (to_base.equalsIgnoreCase("H")) {
            from_decimal(decimalNumber, 16);  
        } else if (to_base.equalsIgnoreCase("D")) {
            System.out.println("Decimal equivalent: " + decimalNumber);
        }
    }

    void from_decimal(int no, int base) {
        StringBuilder sb = new StringBuilder();
        char[] hexChars = {'A', 'B', 'C', 'D', 'E', 'F'}; 
        while (no > 0) {
            int ans = no % base; 
            if (ans < 10) {
                sb.append(ans); 
            } else {
                sb.append(hexChars[ans - 10]); 
            }
            no = no / base;
        }
        sb.reverse(); 
        System.out.println("Converted number: " + sb.toString());
    }

    int to_decimal(int no, int base) {
        String numberStr = Integer.toString(no);
        char[] charArray = numberStr.toCharArray();
        int ans = 0;
        
        int power = charArray.length - 1; 
        for (char c : charArray) {
            int digit = Character.getNumericValue(c);
            ans += digit * Math.pow(base, power); 
            power--; 
        }
        return ans;
    }

    // Method to convert integer to short
    void shortValue(int no) {
        int ans = no % 65536;
        if (ans > 32767) {
            ans -= 65536;
        } else if (ans < -32768) {
            ans += 65536;
        }
        System.out.println("Short Value: " + ans);
    }

    // Method to convert integer to byte
    void byteValue(int no) {
        int ans = no % 256;
        if (ans > 127) {
            ans -= 256;
        } else if (ans < -128) {
            ans += 256;
        }
        System.out.println("Byte Value: " + ans);
    }

    // Method to getNumber type (byte or short)
    void getNumber(int no, String type) {
        int ans = 0;
        if (type.equalsIgnoreCase("byte")) {
            ans = no % 256;
            if (ans > 127) {
                ans -= 256;
            } else if (ans < -128) {
                ans += 256;
            }
            System.out.println("Byte Value: " + ans);
        } else if (type.equalsIgnoreCase("short")) {
            ans = no % 65536;
            if (ans > 32767) {
                ans -= 65536;
            } else if (ans < -32768) {
                ans += 65536;
            }
            System.out.println("Short Value: " + ans);
        }
    }

    public static void main(String[] args) {
        Practical4 program = new Practical4();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1: Byte Conversion");
        System.out.println("2: Short Conversion");
        System.out.println("3: Get Number");
        System.out.println("4: Base Conversion");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter a number for byte conversion: ");
                int byteNum = scanner.nextInt();
                program.byteValue(byteNum);
                break;

            case 2:
                System.out.print("Enter a number for short conversion: ");
                int shortNum = scanner.nextInt();
                program.shortValue(shortNum);
                break;

            case 3:
                System.out.print("Enter a number: ");
                int num = scanner.nextInt();
                System.out.print("Enter type (byte/short): ");
                String type = scanner.next();
                program.getNumber(num, type);
                break;

            case 4:
                System.out.print("Enter the number to convert: ");
                String baseNum = scanner.next();
                System.out.print("Enter conversion format (e.g., OB, DO): ");
                String format = scanner.next();
                program.toXXSystem(baseNum, format);
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }
}
