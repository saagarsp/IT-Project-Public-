import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class FoodAccountsList {
    FoodAccount[] f = new FoodAccount[1000];
    int count;
    public FoodAccountsList(){
        
        String filename = "accounts.txt";
            int i = 0;
            File myObj = new File(filename);
            Scanner myReader;
            try {
                myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] s = data.split(":");
                    this.f[i] = new FoodAccount(Integer.parseInt(s[0]),s[1],s[2],Double.parseDouble(s[3]),s[4],Integer.parseInt(s[5]),s[6]);
                    i++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            this.count = i; 
    }
    public String getF(int i){
        return this.f[i].userId;
    }
    public String getP(int i){
        return this.f[i].password;
    }
    public static void main(String[] args){
        FoodAccountsList a = new FoodAccountsList();
        System.out.println(a.count); 
    }   
}
