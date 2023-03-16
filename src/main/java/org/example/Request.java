package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Request {
    private static int staticId = 0;
    private int id = 0;
    private String customer;
    private String contactNumber;
    private String description;
    private String object;
    private int lostOrFound; // 0 - lost | 1 - found
    private java.time.LocalDate date;

    Request(){
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Tell me your name: (temporary before adding login user)");
            this.customer = scanner.nextLine();

            System.out.println("Tell me your contact number: (temporary before adding login user)");
            this.contactNumber = scanner.nextLine();

            System.out.println("You found or lost something? (0 - lost | 1 - found) " +
                    "(temporary, later choose from list)");
            while (true) {
                try {
                    this.lostOrFound = scanner.nextInt();
                    if (lostOrFound != 0 && lostOrFound != 1) {
                        throw new InputMismatchException();
                    }
                    break;
                } catch (InputMismatchException e) {
                    scanner.nextLine();   // clear input buffer to not loop when someone give string
                    System.out.println("Wrong number.");
                }
            }

            scanner.nextLine();
            System.out.println("What have you lost / found?");
            this.object = scanner.nextLine();

            System.out.println("Description");
            this.description = scanner.nextLine();

            date = java.time.LocalDate.now();

            System.out.println("\n-----------------------------------------------------\n");
            System.out.println("Customer: "+this.customer+", number: "+this.contactNumber+".");
            if(lostOrFound == 0) {
                System.out.print("You lost ");
            }else{
                System.out.print("You found ");
            }
            System.out.println(this.object +".");

            System.out.println("Description: "+this.description+".");

            System.out.println("Date: "+date+".");

            System.out.println("\n-----------------------------------------------------\n");
            System.out.println("Is that right? Are you sure you wanna save it? (1 - yes | 0 - no and start over)");
            int whatToDo;
            while (true) {
                try {
                    whatToDo = scanner.nextInt();
                    if (whatToDo != 0 && whatToDo != 1) {
                        throw new InputMismatchException();
                    }
                    break;
                } catch (InputMismatchException e) {
                    scanner.nextLine();   // clear input buffer to not loop when someone give string
                    System.out.println("Wrong number.");
                }
            }
            scanner.nextLine();
            if(whatToDo == 1){
                staticId ++;
                id = staticId;
                break;
            }
        }
    }

    public static void printRequest(Request request){
        System.out.println("-----------------------------------------------------");
        System.out.println("Your request id: "+request.id+".");
        System.out.println("Customer: "+request.customer+", number: "+request.contactNumber+".");
        if(request.lostOrFound == 0) {
            System.out.print("You lost ");
        }else{
            System.out.print("You found ");
        }
        System.out.println(request.object +".");

        System.out.println("Description: "+request.description+".");

        System.out.println("Date: "+request.date+".");

        System.out.println("-----------------------------------------------------\n");
    }
}
