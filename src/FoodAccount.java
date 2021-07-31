import java.io.Console;
import java.util.Scanner;
public class FoodAccount {
    Scanner scan = new Scanner(System.in);
    String userId;
    String password;
    int cov;
    String address;
    double phoneno;
    String city;
    public FoodAccount(String userId,String password,double phoneno,String address,int cov,String city){
        this.userId = userId;
        this.password = password;
        this.phoneno = phoneno;
        this.address = address;
        this.cov = cov;
        this.city = city;
    }
    
    public FoodAccount newAccount(){
        FoodAccountsList p = new FoodAccountsList();
        System.out.print("Enter your userID : ");
        this.userId = scan.nextLine();
        for(int i = 0; i < p.count; i++)
        {
            while(p.getF(i).equals(this.userId)){
                System.out.print("Oops! UserId already registered. Please enter a different userId : ");
                this.userId = scan.nextLine();
            }
        }    
        System.out.print("Enter your password (minimum password size 8) : ");
        String psswd = scan.nextLine();
        while(psswd.length()<8){
            System.out.print("Please enter a valid password : ");
            psswd = scan.nextLine();
        }
        this.password = psswd;
        System.out.print("Enter your phone/mobile no. : ");
        this.phoneno = Double.parseDouble(scan.nextLine());
        double d = phoneno/1000000000;
        while((d<1)||(d>=10))
        {
            System.out.print("Please enter a valid phone/mobile no. : ");
            this.phoneno = Double.parseDouble(scan.nextLine());
            d = phoneno/1000000000;
        }
        System.out.print("Enter your address : ");
        this.address = scan.nextLine();
        System.out.print("Enter the no. of covid19 vaccine doses taken : ");
        this.cov = Integer.parseInt(scan.nextLine());
        System.out.print("Enter the city of your residence : ");
        this.city = scan.nextLine();
        
        p.f[p.count] = new FoodAccount(this.userId,this.password,this.phoneno,this.address,this.cov,this.city);
        System.out.println("\n\n\t\t\t\t\tYour account has been registered. ");
        return new FoodAccount(this.userId,this.password,this.phoneno,this.address,this.cov,this.city);
    }
    public FoodAccount existingAccount(){
        FoodAccountsList p = new FoodAccountsList();
        System.out.print("Enter your userID : ");
        this.userId = scan.nextLine();
        boolean cond = false;
        int j;
        for(j = 0; j<=p.count;j++){
            if(this.userId.equals(p.getF(j)))
            {
                cond = true;
                break;
            }
        }
        if(cond == false){
            System.out.println("Oops! Seems like this userId hasn't been registered.");
            System.out.print("Please enter a different userId : ");
            this.userId = scan.nextLine();
        }
        System.out.print("Enter your password : ");
        this.password = scan.nextLine();
        if(this.password.equals(p.getP(j)))
        System.out.println("\n\n\t\t\t\t\tYou have successfully logged in.");
        else
        {
            System.out.print("Incorrect password! Please enter the password again : ");
            this.password = scan.nextLine();
        }
        return p.f[j];
    }
    public FoodAccount start(){
        FoodAccount q = new FoodAccount("sdw","def",958485522,"43 afhindfr",2,"ahm");
        System.out.println("\n\n\t\t\t\t\t Welcome to Foomato\n\n");
        System.out.println("\t\t1] New User(Sign up)\t\t\t\t 2] Existing user(log in)");
        Console console = System.console();
        char[] i = console.readPassword();
        if(i[0] == '1')
        q = newAccount();
        else if(i[0] =='2')
        q = existingAccount();
        else
        System.out.println("Please enter valid input");
        System.out.println("\n\n\n Welcome " + this.userId + ", what can we do for you");
        System.out.println("\n\n 1] Delivery \t\t\t\t 2] Dine-in \t\t\t\t 3] Takeaway \n\n");
        return q;
    }
}
