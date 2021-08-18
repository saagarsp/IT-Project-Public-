import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Reservation {
	
	static RestaurantList restDetails = new RestaurantList();

	public Reservation() {
		File file = new File("ReservationRecords.txt");
    	Scanner myReader;
    	try {
			myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] stringArray = data.split("\\|");
				
				if (stringArray.length != 5)
					continue;
				
				Restaurant r = restDetails.searchByName(stringArray[0]);
				int tableNo = Integer.parseInt(stringArray[1]);
				int reservationNum = Integer.parseInt(stringArray[4]);
				String[] startTemp = stringArray[2].split(":");
				String[] endTemp = stringArray[3].split(":");

				Time startTime = new Time(Integer.parseInt(startTemp[0]),Integer.parseInt(startTemp[1]));
				Time endTime = new Time(Integer.parseInt(endTemp[0]),Integer.parseInt(endTemp[1]));
				
				if(r.tables[tableNo-1]==null)
				{
					r.tables[tableNo-1]=new Table(startTime,endTime);
				}	
				
				r.tables[tableNo-1].startTime[reservationNum-1]=startTime;
				r.tables[tableNo-1].endTime[reservationNum-1]=endTime;
				r.tables[tableNo-1].reservations=reservationNum;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void reserve(Time st,Time et,Restaurant chosenRestaurant,FoodAccount use) {
		
		String fileName = "ReservationRecords.txt";
		boolean ifSuccessful =false;

		for(int i = 0;i<4;i++) {

			if(chosenRestaurant.tables[i]==null) {
				chosenRestaurant.tables[i]=new Table(st,et);
				chosenRestaurant.tables[i].reservations++;

				System.out.println("\nTable found, your reservation was successful");
				System.out.println("Table number = "+(i+1)+"\nStart Time = "+st+"\nEnd Time = "+et);
				ifSuccessful=true;
				
				String result = chosenRestaurant.name+"|"+(i+1)+"|"+st.toString()+"|"+et.toString()+"|"+chosenRestaurant.tables[i].reservations;
				 try {
				 	BufferedWriter out = new BufferedWriter(new FileWriter(fileName,true));
				 	out.write(result+"\n");
				 	out.close();
				 }
			        catch (IOException e) {
			            System.out.println("Exception Occurred" + e);
			        }
				 break;
			}

			int noOfReservations=chosenRestaurant.tables[i].reservations;

			if(!Time.intersects(chosenRestaurant.tables[i].startTime[0], chosenRestaurant.tables[i].endTime[0], st, et)) {
				chosenRestaurant.tables[i].startTime[noOfReservations]=st;
				chosenRestaurant.tables[i].endTime[noOfReservations]=et;
				chosenRestaurant.tables[i].reservations++;
				System.out.println("\nTable found, your reservation was successful");
				System.out.println("Table number = "+(i+1)+"\nStart Time = "+st+"\nEnd Time = "+et);
				ifSuccessful=true;

				String result = chosenRestaurant.name+"|"+(i+1)+"|"+st.toString()+"|"+et.toString()+"|"+chosenRestaurant.tables[i].reservations;
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter(fileName,true));
					out.write(result+"\n");
					out.close();
				} catch (IOException e) {
					System.out.println("Exception Occurred" + e);
				}
				return;

			}
			else {
				break;
			}
		}

		if(!ifSuccessful)
		{
			System.out.println("All tables are full");
			start(use);
		}
	}

	public void start(FoodAccount user) {
		
		int choice;
		Scanner scan = new Scanner(System.in);
		
		Restaurant chosen = new Restaurant(null, null, null, null, 0, null, null, null);
		
		System.out.println("\n1] Search restaurant \n2] Search by location");
		System.out.println();
		choice = StdIn.readInt();

		while (choice < 1 || choice > 2) {
			System.out.println("\nEnter a valid number!\n");
			choice = StdIn.readInt();
		}

		if (choice==1) {
			String restaurantName,searchResult;
			System.out.println("\nEnter the name of the restaurant:");
			restaurantName=scan.nextLine();
			System.out.println();
			searchResult= restDetails.byName(restaurantName);
			System.out.println(searchResult);

			if(searchResult.equalsIgnoreCase("Not Found")) {
				start(user);
			}

			else {
				chosen = restDetails.searchByName(restaurantName);
			}

			Time startTime, endTime;
			System.out.println("\nEnter start time and end time for your reservation (HH:MM)\n");
			String inp1,inp2;
			String[] temp;
			int hour,min;
			inp1 = StdIn.readString();
			temp = inp1.split(":");
			hour = Integer.parseInt(temp[0]);
			min = Integer.parseInt(temp[1]);
			startTime = new Time(hour,min);
			
			inp2 = StdIn.readString();
			temp = inp2.split(":");
			hour = Integer.parseInt(temp[0]);
			min = Integer.parseInt(temp[1]);
			endTime = new Time(hour,min);
			
			reserve(startTime,endTime,chosen,user);
		} else {
			System.out.println("\n1] Chennai\n2] Bangalore\n3] Hyderabad\n4] Kolkata\n5] Delhi");
			System.out.println("6] Pune\n7] Coimbatore\n8] Vadodara\n9] Ahmedabad\n10] Jaipur\n");
			int input = StdIn.readInt();
			System.out.println();

			while (input > 10 || input < 1) {
				System.out.println("\nEnter a valid number!\n");
				input = StdIn.readInt();
			}

			Restaurant[] newList;
			RestaurantList resList = new RestaurantList();

			if (input == 1) {
				String city = "Chennai";
				newList = resList.searchByLocation(city);
			} else if (input == 2) {
				String city = "Bangalore";
				newList = resList.searchByLocation(city);
			} else if (input == 3) {
				String city = "Hyderabad";
				newList = resList.searchByLocation(city);
			} else if (input == 4) {
				String city = "Kolkata";
				newList = resList.searchByLocation(city);
			} else if (input == 5) {
				String city = "Delhi";
				newList = resList.searchByLocation(city);
			} else if (input == 6) {
				String city = "Pune";
				newList = resList.searchByLocation(city);
			} else if (input == 7) {
				String city = "Coimbatore";
				newList = resList.searchByLocation(city);
			} else if (input == 8) {
				String city = "Vadodara";
				newList = resList.searchByLocation(city);
			} else if (input == 9) {
				String city = "Ahmedabad";
				newList = resList.searchByLocation(city);
			} else {
				String city = "Jaipur";
				newList = resList.searchByLocation(city);
			}
				RestaurantList.printRes(newList);
				System.out.println("Choose restaurant\n");
				choice = StdIn.readInt();
				chosen  = newList[choice-1];
				Time startTime,endTime;
				System.out.println("\nEnter start time and end time for your reservation (HH:MM)\n");
				String inp1,inp2;
				String[] temp;
				int hour,min;
				inp1 = StdIn.readString();
				temp = inp1.split(":");
				hour = Integer.parseInt(temp[0]);
				min = Integer.parseInt(temp[1]);
				startTime = new Time(hour,min);
				
				inp2 = StdIn.readString();
				temp = inp2.split(":");
				hour = Integer.parseInt(temp[0]);
				min = Integer.parseInt(temp[1]);
				endTime = new Time(hour,min);
				
				reserve(startTime,endTime,chosen,user);
		}
	}
}