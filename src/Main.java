
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean runMenu = true;
        while (runMenu) {

            System.out.println("If you are a hospital administrator please press 1,If you are a patient please press 2,Press 3 to exit");
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();

            if (userInput == 1) {

                boolean runAdmin = true;
                while (runAdmin) {
                    System.out.println("Press 1 to add a doctor,press 2 to add a doctor availability,and press 3 to exit");
                    int userObjective = scanner.nextInt();

                    if (userObjective == 1) {
                        System.out.println("added a doctor");
                    } else if (userObjective == 2) {
                        System.out.println("added doctor availability");
                    } else if (userObjective == 3) {
                        runAdmin = false;
                    } else {
                        System.out.println("Invalid input");
                    }
                }
            } else if (userInput == 2) {

                boolean runPatient = true;
                while (runPatient) {

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
                        runPatient = false;
                    } else {
                        System.out.println("Invalid input");
                    }
                }
            } else if (userInput == 3) {

                runMenu = false;
                System.out.println("finished");
            }else{
                System.out.println("Invalid input");
            }
        }
    }
}
