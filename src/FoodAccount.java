
import java.util.Scanner;

public class FoodAccount {
    Scanner scan = new Scanner(System.in);
    String userId;
    String password;
    int cov;
    String address;
    double phoneno;
    public FoodAccount(String userId,String password,int cov,String address,double phoneno){
        this.userId = userId;
        this.password = password;
        this.phoneno = phoneno;
        this.address = address;
        this.cov = cov;
    }
    public void newAccount(){
        System.out.print("\t Enter your userID : ");
        this.userId = scan.nextLine();
        System.out.print("\t Enter your password (minimum password size 8) : ");
        String psswd = scan.nextLine();
        while(psswd.length()<8){
            System.out.print("\t Please enter a valid password : ");
            psswd = scan.nextLine();
        }
        this.password = psswd;
        System.out.print("\t Enter your phone/mobile no. : ");
        this.phoneno = Double.parseDouble(scan.nextLine());
        double d = phoneno/1000000000;
        while((d<1)||(d>=10))
        {
            System.out.println("\t Please enter a valid phone/mobile no. : ");
            this.phoneno = Double.parseDouble(scan.nextLine());
            d = phoneno/1000000000;
        }
        System.out.print("\t Enter your address : ");
        this.address = scan.nextLine();
        System.out.print("\t Enter the no. of covid19 vaccine doses taken : ");
        this.cov = Integer.parseInt(scan.nextLine());
        System.out.println("\t\t\tYour account has been registered. ");
    }
    public void existingAccount(){
        System.out.print("Enter your userID : ");
        this.userId = scan.nextLine();
        System.out.print("Enter your password : ");
        this.password = scan.nextLine();
        System.out.println("\n\t\t\tYou have successfully logged in. ");
    }
    public void start(){
        System.out.println("\n\n\t\t\t\t\t Welcome to Foomato\n\n");
        System.out.println("\t\t1] New User(Sign up)\t\t\t\t 2] Existing user(log in)");
        int input = Integer.parseInt(scan.nextLine());
        if(input ==1)
        newAccount();
        else if(input ==2)
        existingAccount();
        else
        System.out.println("Please enter valid input");
        System.out.println("\n\n\n Welcome " + this.userId + ", what can we do for you");
        System.out.println("\n\n 1] Delivery \t\t\t\t 2] Dine-in \t\t\t\t 3] Takeaway ");
        input = Integer.parseInt(scan.nextLine());
    }
    public static void main(String[] args){
       FoodAccount f = new FoodAccount("sdw","def",958485522,"43 afhindfr",2);
        f.start();
    }
}
