public class Main {

    public static void main(String[] args) {

        FoodAccount user = new FoodAccount();
        user = user.start();

        Delivery delivery = new Delivery(user);
        delivery.start();
    }
}
