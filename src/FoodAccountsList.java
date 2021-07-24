import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class FoodAccountsList {
    public FoodAccountsList(){
            FoodAccount[] f = new FoodAccount[1000];
            String filename = "accounts.txt";
            int i = 0;
            int j = 0;
            File myObj = new File(filename);
            Scanner myReader;
            try {
                myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    
                    String data = myReader.nextLine();
                    String[] s = data.split("\\|");
                    f[i].userId =  s[j];
                    f[i].password = s[j+1];
                    f[i].phoneno = Double.parseDouble(s[j+2]);
                    f[i].address = s[j+3];
                    f[i].cov = Integer.parseInt(s[j+4]);
                    i++;
                    j+=5;
                    System.out.println(data);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        
    }
    public static void main(String[] args){
        new FoodAccountsList();
    }
}
