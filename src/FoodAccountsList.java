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
                    this.f[i] = new FoodAccount(s[0],s[1],Double.parseDouble(s[2]),s[3],Integer.parseInt(s[4]),s[5]);
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
}
