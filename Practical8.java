class Practical8 {
    
    // First Pattern
    void generatePattern1(int line,int size) {
        if (line>size+1) return;
        
        drawStars(line);
        System.out.println();
        
        generatePattern1(line+1,size);
        
        drawStars(line-1);
        System.out.println();
    }

    // Second Pattern
    void drawPattern2(int n,int line) {
        if (line>n) {
            drawSymbols(n+1,'+'); 
            return;
        }
        drawSymbols(n-line,' ');
        drawSymbols(line,'*');
        System.out.println();
        drawPattern2(n,line+1);
    }

    // Third Pattern
    void generatePattern3(int line,int totalSize) {
        int mid = (int) Math.ceil(totalSize/2f);
        if (line<=mid) {
            drawSpaces(mid-line);
            drawStars(line*2-1);
            System.out.println();
            generatePattern3(line+1,totalSize);
            if (line<mid) {
                drawSpaces(mid-line);
                drawStars(line*2-1);
                System.out.println();
            }
        }
    }

    void drawCenterLine(int line,int totalSize) {
        if (line >totalSize) {
            return;
        }
        drawSpaces(totalSize/2);
        System.out.println("+");
        drawCenterLine(line+1,totalSize);
    }

    
    void drawStars(int count) {
        if (count>0) {
            System.out.print("*");
            drawStars(count-1);
        }
    }

    void drawSpaces(int count) {
        if (count>0) {
            System.out.print(" ");
            drawSpaces(count-1);
        }
    }

    void drawSymbols(int count,char symbol) {
        if (count>0) {
            System.out.print(symbol);
            drawSymbols(count-1,symbol);
        }
    }

    public static void main(String[] args) {
        Practical8 p = new Practical8();

        System.out.println("Pattern 1:");
        p.generatePattern1(1, 3);

        System.out.println("\nPattern 2:");
        p.drawPattern2(3, 1);

        System.out.println("\nPattern 3:");
        p.generatePattern3(1, 5);
        p.drawCenterLine(1, 5);
    }
}
