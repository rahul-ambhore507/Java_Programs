import java.util.Random;
import java.util.Calendar;

class Practical11 {
    private final String name;  
    private final String branch;  
    private final String bGroup; 
    private final String dob;  
    private final int year;  
    private final String regNo;  

   
    Practical11(String name, String branch, String bGroup, String dob, int year) {
        this.name = name;  
        this.branch = getBranchCode(branch);  
        this.bGroup = bGroup;
        this.dob = dob;  
        this.year = year;  
        this.regNo = generateReg(); 
    }

    private String getBranchCode(String branch) {
        if (branch.equals("CSE")) return "BCS";
        if (branch.equals("IT")) return "BIT";
        if (branch.equals("EXTC")) return "BEX";
        if (branch.equals("MECH")) return "BME";
        if (branch.equals("CHEM")) return "BCH";
        if (branch.equals("PROD")) return "BPR";
        if (branch.equals("ELECTRICAL")) return "BEE";
        if (branch.equals("CIVIL")) return "BCV";
        if (branch.equals("TEXTILE")) return "BTX";
        if (branch.equals("INSTRUMENTATION")) return "BIN";
        return "GEN";
    }

    private String generateReg() {
        Random random = new Random();
        int randomNum = 100 + random.nextInt(900);  
        return year + branch + randomNum;  
    }

    private int calculateAge() {
        int birthYear = Integer.parseInt(dob.substring(dob.length() - 4));  
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);  
        return currentYear - birthYear;  
    }

    @Override
    public String toString() {
        return "Student Details:\n" +
               "Name: " + name + "\n" +
               "Branch: " + branch + "\n" +
               "Blood Group: " + bGroup + "\n" +
               "Date of Birth: " + dob + "\n" +
               "Admission Year: " + year + "\n" +
               "Age: " + calculateAge() + " years\n" +
               "Registration Number: " + regNo + "\n";
    }

    public static void main(String[] args) {
        Practical11 student = new Practical11("Rahul", "IT", "B+", "27-08-2005", 2024);
        System.out.println(student);
    }
}