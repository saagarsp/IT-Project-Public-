import java.time.LocalTime;
import java.util.Date;

public class Delivery {

    private String[] cart;
    private int itemNumber = 0;
    private Date timeOrdered;
    FoodAccount user;

    public Delivery(FoodAccount user) {
        this.user = user;
    }

    public void addInCart(Restaurant restaurant) {

        restaurant.menu.displayMenu();
        System.out.println("Enter the number corresponding to the item you want to order");
        int input = StdIn.readInt();
        cart[itemNumber] = restaurant.menu.menu[input - 1];
        itemNumber++;
        System.out.println(restaurant.menu.menu[input - 1] + " was added to your cart!");
        System.out.println("Press y if you want to order more or c if you want to checkout");
        input = StdIn.readInt();
        if (input ==  'y' || input == 'Y')
            addInCart(restaurant);
        timeOrdered = new Date();
        return;
    }

    public void start() {

        Restaurant restaurant;
        RestaurantList resList = new RestaurantList();
        Restaurant[] list = resList.searchByLocation(user.city);
        RestaurantList.printRes(list);
        System.out.println("Press F if you want to filter the restaurants and press the number corresponding to the restaurant to select it");

        int input = StdIn.readInt();

        if (input == 'F') {

            System.out.println("Press 1 if you want to search by city");
            System.out.println("Press 2 if you want to search by rating");
            System.out.println("Press 3 if you want to search by name");

            input = StdIn.readInt();

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
        }

        else
            restaurant = list[input];

        addInCart(restaurant);

        System.out.println("Your order will be delivered in in 45 minutes, you can log in again to check how much longer the delivery will take");
        System.out.println("Thank you");
    }
}
