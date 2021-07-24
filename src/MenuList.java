
public class MenuList {
	
	Menu[] menus = new Menu[4];
	
public void buildLibrary() {
		
		menus[0] = new Menu(ReadFile.readStrings("Punjabi menu.txt"));
		menus[1] = new Menu(ReadFile.readStrings("South Indian menu.txt"));
		menus[2] = new Menu(ReadFile.readStrings("Fast Food menu.txt"));
		menus[3] = new Menu(ReadFile.readStrings("Italian menu.txt"));
   }
	

	public static void main(String[] args) {
		StdOut.print(ReadFile.readStrings("Punjabi menu.txt").length);
	}
}
