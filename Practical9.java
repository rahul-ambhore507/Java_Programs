import java.util.Random;

public class Practical9 {
    
    public static int[] generateRandomNumbersArray() {
        int[] numbers = new int[10];
        Random random = new Random();
        
        for (int i=0;i<numbers.length;i++) {
            numbers[i]=random.nextInt(50) + 1;
        }
        
        return numbers;
    }

    public static long measureIterativeFactorialTime(int num) {
        long startTime = System.nanoTime();
        
        long result = 1;
        for (int i=1;i<=num;i++) {
            result *=i;
        }
        
        return System.nanoTime()-startTime;
    }

    private static long factorialRecursive(int num) {
        if (num<=1) return 1;
        return num * factorialRecursive(num - 1);
    }

    public static long measureRecursiveFactorialTime(int num) {
        long startTime = System.nanoTime();
        long result = factorialRecursive(num);
        return System.nanoTime() - startTime;
    }

    public static void compareFactorialMethods() {
        int[] numbers = generateRandomNumbersArray();
        long totalIterativeTime=0,totalRecursiveTime=0;

        for (int num : numbers) {
            long iterativeSum=0,recursiveSum=0;

            for (int i=0;i<5;i++) {
                iterativeSum+=measureIterativeFactorialTime(num);
                recursiveSum+=measureRecursiveFactorialTime(num);
            }

            totalIterativeTime+=iterativeSum/5;
            totalRecursiveTime+=recursiveSum/5;
        }

        System.out.println(totalIterativeTime<totalRecursiveTime 
            ? "Iterative factorial is faster." 
            : "Recursive factorial is faster.");
    }

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        
        for (int i=0;i<length;i++) {
            int randomValue=random.nextInt(52);
            char ch = (randomValue<26) 
                ? (char) ('A'+randomValue) 
                : (char) ('a'+(randomValue-26));
            
            sb.append(ch);
        }
        
        return sb.toString();
    }

    public static void measureStringConcatenation(int size) {
        String baseString = generateRandomString(size);
        int iterations = 1000;

        long startTime,elapsedTime;

        startTime = System.nanoTime();
        String strConcat = "";
        for (int i=0;i<iterations;i++) {
            strConcat+=baseString;
        }
        elapsedTime=System.nanoTime()-startTime;
        long stringTime = elapsedTime;

        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<iterations;i++) {
            sb.append(baseString);
        }
        elapsedTime=System.nanoTime()-startTime;
        long stringBuilderTime = elapsedTime;

        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i=0;i<iterations;i++) {
            sbf.append(baseString);
        }
        elapsedTime=System.nanoTime()-startTime;
        long stringBufferTime=elapsedTime;

        System.out.println("String: "+stringTime+" ns");
        System.out.println("StringBuilder: "+stringBuilderTime+" ns");
        System.out.println("StringBuffer: "+stringBufferTime+" ns");

        if (stringTime<stringBuilderTime&&stringTime<stringBufferTime) {
            System.out.println("String concatenation is the fastest.");
        } else if (stringBuilderTime<stringTime&&stringBuilderTime<stringBufferTime) {
            System.out.println("StringBuilder is the fastest.");
        } else {
            System.out.println("StringBuffer is the fastest.");
        }
    }

    public static void main(String[] args) {
        compareFactorialMethods();
        measureStringConcatenation(10);
    }
}
