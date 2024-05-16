package com.ps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private static Dealership dealership;
    private static Scanner scanner = new Scanner(System.in);
    private static DealershipFileManager dealershipFileManager = new DealershipFileManager();

    private static void dealershipInit() {
        dealership = dealershipFileManager.getDealership();
    }

    public static void displayInterface() {
        dealershipInit();
        System.out.println("Dealership: " + dealership);

        String mainMenuInput;

        do {
            System.out.println("\nPlease choose from the following search options: \n");
            System.out.println("1: Get all vehicles\n");
            System.out.println("2: Get all vehicles by price\n");
            System.out.println("3: Add a Vehicle\n");
            System.out.println("4: Remove a Vehicle\n");
            System.out.println("5: Exit\n");

            System.out.print("Which are you choosing: ");
            mainMenuInput = scanner.nextLine();

            switch (mainMenuInput) {
                case "1":
                    // processGetAllVehiclesRequest();
                    break;
                case "2":
                    processGetVehiclesByPriceRequest();
                    break;
                case "3":
                    // processAddVehicleRequest();
                    break;
                case "4":
                    // processRemoveVehicleRequest();
                    break;
                case "5":
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Command not found, please try again");
            }
        } while (!mainMenuInput.equals("5"));
    }

    public static void processGetVehiclesByPriceRequest() {
        System.out.println("Please give me a min price");
        float minValue = scanner.nextFloat();
        System.out.println("Please give me a max price");
        float maxValue = scanner.nextFloat();

        ArrayList<Vehicle> vehiclesByPrice = dealership.getVehiclesByPrice(minValue, maxValue);
        for (Vehicle vehicle : vehiclesByPrice) {
            System.out.println(vehicle);
        }
    }
}