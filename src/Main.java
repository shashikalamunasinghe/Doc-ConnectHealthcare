import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("If you are a hospital administrator please press 1,If you are a patient please press 2,Press 3 to exit");
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        if (userInput == 1) {

            System.out.println("Press 1 to add a doctor,press 2 to add a doctor availability,and press 3 to exit");
            int userObjective = scanner.nextInt();

            if (userObjective == 1) {
                System.out.println("added a doctor");
            } else if (userObjective == 2) {
                System.out.println("added doctor availability");
            } else if (userObjective == 3) {
                System.out.println("exist");
            } else {
                System.out.println("Invalid input");
            }
        } else if (userInput == 2) {

            System.out.println("Press 1 to view doctors,press 2 to book an appointment, press 3 to view a selected doctor's bookings,press 4 to register patient and press 5 to exit");
            int userObjective = scanner.nextInt();

            if (userObjective == 1) {
                System.out.println("all the doctors");
            } else if (userObjective == 2) {
                System.out.println("booked an appointment");
            } else if (userObjective == 3) {
                System.out.println("selected doctor's bookings");
            } else if (userObjective == 4) {
                System.out.println("register patient");
            } else if (userObjective == 5) {
                System.out.println("exist");
            } else {
                System.out.println("Invalid input");
            }

        } else if (userInput == 3) {
            System.out.println("exist");
        }else{
            System.out.println("Invalid input");
        }
    }
}

