public class Main {

    public static void main(String[] args) {

        FoodAccount user = new FoodAccount(1,"saagar","12345678",1.23456789E9,"sad",2,"bangalore");

        System.out.println("\n\n\n Welcome " + user.userId + ", what can we do for you");
        System.out.println("\n\n 1] Delivery / Takeaway \t\t\t\t 2] Dine-in \t\t\t\t 3] Check Delivery \t\t\t\t 4] Check Reservation\n\n");

        int input = StdIn.readInt();
        Delivery delivery = new Delivery(user);

        if (input == 1) {
            delivery.start();
        }
        else if (input == 2) {
            Reservation reservation = new Reservation();
            reservation.start(user);
        }
        else if(input == 3) {
            delivery.checkDelivery();
        }
    }
}
