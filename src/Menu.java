
public class Menu {
	
	String[] menu;
	
	public Menu(String[] menu) {
		this.menu=menu;
	}
	public void displayMenu() {
		
		System.out.println("MENU");
		for(int i=0;i<24;i++) {
			System.out.println((i + 1) + "." + " " + this.menu[i]);
		}
	}
}
