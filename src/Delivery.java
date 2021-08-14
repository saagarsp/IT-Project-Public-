import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Delivery {

    private int itemNumber = 0;
    FoodAccount user;

    public Delivery(FoodAccount user) {
        this.user = user;
    }

    public void addInCart(Restaurant restaurant) {

        user.cart[itemNumber] = "";
        restaurant.menu.displayMenu();
        System.out.println("Enter the number corresponding to the item you want to order");
        int input = StdIn.readInt();
        user.cart[itemNumber] = restaurant.menu.menu[input - 1];
        itemNumber++;
        System.out.println(restaurant.menu.menu[input - 1] + " was added to your cart!");
        System.out.println("Press 1 if you want to order more or 2 if you want to checkout");
        input = StdIn.readInt();
        if (input == 1)
            addInCart(restaurant);
        user.timeOrdered = new Date();
        return;
    }

    public void start() {

        Restaurant restaurant;
        RestaurantList resList = new RestaurantList();

        System.out.println("Press 1 if you want to search by city");
        System.out.println("Press 2 if you want to search by rating");
        System.out.println("Press 3 if you want to search by name");

        int input = StdIn.readInt();

        if (input == 1) {
            System.out.println("Enter the city you want to search in:");
            String city = StdIn.readString();
            Restaurant[] newList = resList.searchByLocation(city);
            RestaurantList.printRes(newList);
            System.out.println("Press the number corresponding to the restaurant to select it");
            input = StdIn.readInt();
            restaurant = newList[input];
        }

        else if (input == 2) {
            System.out.println("Enter the rating you want to search by (number from 0 - 5)");
            double rating = StdIn.readDouble();
            Restaurant[] newList = resList.searchByRating(rating);
            RestaurantList.printRes(newList);
            System.out.println("Press the number corresponding to the restaurant to select it");
            input = StdIn.readInt();
            restaurant = newList[input];
        }

        else if (input == 3) {
            System.out.println("Enter the name of the restaurant");
            String name = StdIn.readString();
            restaurant = resList.searchByName(name);
        }

        else {
            System.out.println("invalid input");
            return;
        }

        addInCart(restaurant);

        File f = new File("cart.txt");
        try {
            FileWriter fw = new FileWriter(f,true);
            fw.write(user.accNumber);
            for (int i = 0; user.cart[i] != null; i++)
            {
                fw.write(":" + user.cart[i]);
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Your order will be delivered in in 45 minutes, you can log in again to check how much longer the delivery will take");
        System.out.println("Thank you");
    }

    public void checkDelivery() {
        if (user.cart[0] == null) {
            System.out.println("\nNo order has been placed yet");
            return;
        }

        System.out.println("\nYour Order is:");
        for (int i = 0; user.cart[i] != null; i++) {
            System.out.println(user.cart[i]);
        }
        System.out.println();
        Date now = new Date();
        int diff = now.compareTo(user.timeOrdered);
        System.out.println("It will be delivered in " + diff + " minutes");
    }
}
