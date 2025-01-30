class Practical6{
    void displayPattern1(int size)
    {
         for(int ln = 1;ln<=size;ln++){
            for(int space = size-ln;space>0;space--){
                System.out.print(" ");
            }
            for(int plus = ln*2-1;plus>0;plus--){
                System.out.print("+");
            }
            System.out.print("\n");
        }
        for(int ln =size-1;ln>0;ln--){
            for(int space = size-ln;space>0;space--){
                System.out.print(" ");
            }
            for(int plus = ln*2-1;plus>0;plus--){
                System.out.print("+");
            }
            System.out.print("\n");
        }
      }
      
       void displayPattern2(int size){
        for(int ln = 1;ln<=size;ln++){
            for(int space = size-ln;space>0;space--){
                System.out.print(" ");
            }
            for(int plus = ln*2-1;plus>0;plus--){
                if (plus%2!=0) {
                    System.out.print("+");
                }else{
                System.out.print(" ");
                }
            }
            System.out.print("\n");
        }

        for(int ln =size-1;ln>0;ln--){
            for(int space = size-ln;space>0;space--){
                System.out.print(" ");
            }
            for(int plus = ln*2-1;plus>0;plus--){
                if (plus%2!=0) {
                    System.out.print("*");
                }else{
                System.out.print(" ");
                }
            }
            System.out.print("\n");
        }     
    }
    
    void displayPattern3(int size){
        for(int ln = 1;ln<=size;ln++){
            for(int space = size-ln;space>0;space--){
                System.out.print(" ");
            }
            for(int plus = ln*2-1;plus>0;plus--){
                if (ln%2==0) {
                    if (plus%2!=0) {
                        System.out.print("+");
                    }
                    else{
                        System.out.print("*");
                    }
                } else{
                    if (plus%2==0) {
                        System.out.print("+");
                    }
                    else{
                        System.out.print("*");
                    }
                }
                
            }
            System.out.print("\n");
        }

        for(int ln =size;ln>0;ln--){
            for(int space = size-ln;space>0;space--){
                System.out.print(" ");
            }
            for(int plus = ln*2-1;plus>0;plus--){
                if (ln%2==0) {
                    if (plus%2!=0) {
                        System.out.print("*");
                    }
                    else{
                        System.out.print("+");
                    }
                } else{
                    if (plus%2==0) {
                        System.out.print("*");
                    }
                    else{
                        System.out.print("+");
                    }
                }
            }
            System.out.print("\n");
        }
        }
    
    
    public static void main(String args[]){
          Practical6 p6 = new Practical6();
          p6.displayPattern1(3);
          p6.displayPattern2(3);
          p6.displayPattern3(3);
      }
      }
          
