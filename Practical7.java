public class Practical7 {

    String displayR(int size) {
        size = size+5;
        int mid = (size+1)/2;
        String R = "";
        for (int ln=1;ln<=size;ln++) {
            for (int col=1;col<=size;col++) {
                if(ln==1 || col==1 || ln==mid || (ln==mid+1&&col==size-1)) {
                    R+="*";
                } else {
                    R+=" ";
                }
                if(col==size) {
                    if(ln==mid+1) {
                        break;
                    }
                    R+="*";
                }
                if (ln==mid+1&&col==size-1) {
                    R+=" ";
                }
            }
            R+="\n";
        }
        return R;
    }

    String displayA(int size) {
        size = size+5;
        int mid = (size+1)/2;
        String A = "";

        for (int ln=1;ln<=size;ln++) {
            for (int col=1;col<=size;col++) {
                if (ln==1 || col==1 || ln==mid || col==size) {
                    A+="*";
                } else {
                    A+=" ";
                }
            }
            A+="\n";
        }
        return A;
    }

    String displayH(int size) {
        size = size+5;
        int mid = (size+1)/2;
        String H = "";

        for (int ln=1;ln<=size;ln++) {
            for (int col=1;col<=size;col++) {
                if (col==1 || ln==mid || col==size) {
                    H+="*";
                } else {
                    H+=" ";
                }
            }
            H+="\n";
        }
        return H;
    }

    String displayU(int size) {
        size = size+5;
        String U = "";

        for (int ln=1;ln<=size;ln++) {
            for (int col=1;col<=size;col++) {
                if (ln==size || col==1 || col==size) {
                    U+="*";
                } else {
                    U+=" ";
                }
            }
            U+="\n";
        }
        return U;
    }

    String displayL(int size) {
        size = size+5;
        String L = "";

        for (int ln=1;ln<=size;ln++) {
            for (int col=1;col<=size;col++) {
                if (ln==size || col==1) {
                    L+= "*";
                } else {
                    L+=" ";
                }
            }
            L+="\n";
        }
        return L;
    }


    public static void main(String[] args) {
        Practical7 practical7 = new Practical7();
    
        String[] rLines = practical7.displayR(1).split("\n");
        String[] aLines = practical7.displayA(1).split("\n");
        String[] hLines = practical7.displayH(1).split("\n");
        String[] uLines = practical7.displayU(1).split("\n");
        String[] lLines = practical7.displayL(1).split("\n");
    
        for (int i = 0; i < rLines.length; i++) {
            System.out.println(rLines[i] + "   " + aLines[i] + 
            "   " + hLines[i] + "   " + uLines[i] + "   " + lLines[i]);
        }
    }
    
}
