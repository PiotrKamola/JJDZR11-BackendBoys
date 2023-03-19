package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RequestMenu {
    RequestController requestController;
    public RequestMenu(RequestController requestController) {
        this.requestController = requestController;
    }

    private String getRequestRequesterData(){
        return getUserInput("Tell me your name: (temporary before adding login user)\n");
    }
    private String getRequestContactNumberData(){
        return getUserInput("Tell me your contact number: (temporary before adding login user)\n");
    }
    private int getRequestLostOrFound(){
        int lostOrFound;
        System.out.println("You found or lost something? (0 - lost | 1 - found) " +
                "(temporary, later choose from list)");
        while (true) {
            try {
                String userInput = getUserInput("");
                lostOrFound = Integer.parseInt(userInput);
                if (lostOrFound != 0 && lostOrFound != 1) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Wrong number.");
            }
        }
        return lostOrFound;
    }

    private String getObjectName(){
        return getUserInput("What have you lost / found?\n");
    }

    private String getObjectDescription(){
        return getUserInput("Description\n");
    }

    public boolean sendRequestData(){
        try {
            requestController.addRequest(getRequestRequesterData(),
                    getRequestContactNumberData(),
                    getObjectDescription(),
                    getObjectName(),
                    getRequestLostOrFound());
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private static String getUserInput(String inputMessage){
        System.out.print(inputMessage);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void printRequest(Request request){
        System.out.println("-----------------------------------------------------");
        System.out.println("Customer name: "+request.getRequester()+", number: "+request.getContactNumber()+".");
        if(request.getLostOrFound() == 0) {
            System.out.print("You lost ");
        }else{
            System.out.print("You found ");
        }
        System.out.println(request.getObjectName() +".");

        System.out.println("Description: "+request.getDescription()+".");

        System.out.println("Date: "+request.getRequestDate()+".");

        System.out.println("-----------------------------------------------------\n");
    }



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
        public static void createNewRequest(){
        while(true) {
            System.out.println("\n-----------------------------------------------------\n");
            System.out.println("Customer: "+this.requester+", number: "+this.contactNumber+".");
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
    */
}
