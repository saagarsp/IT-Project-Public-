import java.util.Scanner;

public class Reservation {
	
	static RestaurantList restDetails = new RestaurantList();

	
	public static void displayRestaurants(String city) {
		Restaurant[] restau = restDetails.searchByLocaion(city);
		
		for(int i = 0; i < restau.length; i++)
		{
			System.out.println((i + 1) +  ": " + restau[i]);
		}
		
		
	}
	public static void reserve(Time st,Time et,Restaurant chosenRestaurant,FoodAccount use) {
		
		boolean ifSuccessful =false;

		
		System.out.println("checking for vacant tables..");
		for(int i = 0;i<4;i++)
		{
			int noOfReservations=chosenRestaurant.tables[i].reservations;

			for(int j=0;j<noOfReservations;j++)
			{
				if(Time.intersects(chosenRestaurant.tables[i].startTime[j], chosenRestaurant.tables[i].endTime[j], st, et)==false)
				{
					noOfReservations++;
					chosenRestaurant.tables[i].startTime[noOfReservations]=st;
					chosenRestaurant.tables[i].endTime[noOfReservations]=et;
					chosenRestaurant.tables[i].reservations++;
					System.out.println("Table found,your reservation was successful");
					System.out.println("Table number = "+(i+1)+"\nStart Time = "+st+"\nEnd Time = "+et);
					ifSuccessful=true;

				}
				else
				{
					break;
				}
				
		
	
			}
			
		}
		
		if(ifSuccessful==false)
		{
			System.out.println("All tables are full");
			start(use);
		}
		
		
		
		
		
	}
	
	
	public static void start(FoodAccount user) {
		
		int choice;
		
		Scanner scan = new Scanner(System.in);
		Restaurant chosen = new Restaurant(null, null, null, null, 0, null, null, null);
		
		System.out.println("1]Search restaurant 2]Search by location");
		choice = scan.nextInt();
		if(choice==1) 
		{
			String resname,searchResult;
			System.out.println("Enter restaurant name");
			resname=scan.nextLine();
			searchResult= restDetails.byName(resname);
			System.out.println(searchResult);
			if(searchResult.equals("Not Found"))
			{
				start(user);
			}
			else
			{
				chosen = restDetails.searchByName(resname);
			}
			Time starttime,endtime;
			System.out.println("Enter start time and end time for your reservation (HH:MM)");
			String inp1,inp2;
			String[] temp;
			int hour,min;
			inp1 = scan.nextLine();
			temp = inp1.split(":");
			hour = Integer.parseInt(temp[0]);
			min = Integer.parseInt(temp[1]);
			starttime = new Time(hour,min);
			
			inp2 = scan.nextLine();
			temp = inp2.split(":");
			hour = Integer.parseInt(temp[0]);
			min = Integer.parseInt(temp[1]);
			endtime = new Time(hour,min);
			
			reserve(starttime,endtime,chosen,user);
			
			
		}
		
		if(choice==2) 
		{
			
			System.out.println("Search by location: 1]My city 2]Enter location");
			
			choice= scan.nextInt();
			if(choice==1)
			{
				displayRestaurants(user.city);
				Restaurant[] restInCity = restDetails.searchByLocaion(user.city);
				System.out.println("choose restuarant");
				choice = scan.nextInt();
				chosen  = restInCity[choice-1];
				Time starttime,endtime;
				System.out.println("Enter start time and end time for your reservation (HH:MM)");
				String inp1,inp2;
				String[] temp;
				int hour,min;
				inp1 = scan.nextLine();
				temp = inp1.split(":");
				hour = Integer.parseInt(temp[0]);
				min = Integer.parseInt(temp[1]);
				starttime = new Time(hour,min);
				
				inp2 = scan.nextLine();
				temp = inp2.split(":");
				hour = Integer.parseInt(temp[0]);
				min = Integer.parseInt(temp[1]);
				endtime = new Time(hour,min);
				
				reserve(starttime,endtime,chosen,user);
				
				
				
			}
			if(choice==2)
			{
				String city;
				city=scan.nextLine();
				displayRestaurants(city);
				Restaurant[] restInCity = restDetails.searchByLocaion(city);
				System.out.println("choose restuarant");
				choice = scan.nextInt();
				chosen  = restInCity[choice-1];
				Time starttime,endtime;
				System.out.println("Enter start time and end time for your reservation (HH:MM)");
				String inp1,inp2;
				String[] temp;
				int hour,min;
				inp1 = scan.nextLine();
				temp = inp1.split(":");
				hour = Integer.parseInt(temp[0]);
				min = Integer.parseInt(temp[1]);
				starttime = new Time(hour,min);
				
				inp2 = scan.nextLine();
				temp = inp2.split(":");
				hour = Integer.parseInt(temp[0]);
				min = Integer.parseInt(temp[1]);
				endtime = new Time(hour,min);
				
				reserve(starttime,endtime,chosen,user);
				
			}
			else 
			{
				start(user);
			}
			
		}
		
		
	}

}
