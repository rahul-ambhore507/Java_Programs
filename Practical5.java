public class Practical5 {
    int count = 0;

    int factorial1(int no){
        int fact = 1;
        if (no<0) {
            return no;
        }
        for(int i=2;i<=no;i++){
            fact*=i;
        }
        return fact;
    }

    int factorial2(int no){
        if (no<0) {
            return no;
        }
        int i = 2,fact =1;
        while (i<=no) {
            fact*=i;
            i++;
        }
        return fact;
    }

    int factorial3(int no){
        if(no==0||no==1){
            return no;
        }
        return no*factorial3(no-1);
    }

    int sumOfArray(int[] arr){
        if (count>arr.length-1) {
            return 0;
        }
        int current = arr[count];
        count++;
        return current+sumOfArray(arr);
    }
    
    public static void main(String[] args) {
        Practical5 p = new Practical5();
        int [] arr = {10,20,30,40,50};
        System.out.println("Factorial Using For Loop : "+p.factorial1(5));
        System.out.println("Factorial Using While Loop : "+p.factorial2(10));
        System.out.println("Factorial Using Recursion : "+p.factorial3(15));
        System.out.println("Sum Of Array Element Using Recursion : "+p.sumOfArray(arr));
    }
}
