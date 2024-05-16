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
                    processGetAllVehiclesRequest();
                    break;
                case "2":
                    processGetVehiclesByPriceRequest();
                    break;
                case "3":
                    processAddVehicleRequest();
                    break;
                case "4":
                    processRemoveVehicleRequest();
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

    public static void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> allVehicles = dealership.getAllVehicles();
        if (allVehicles.isEmpty()) {
            System.out.println("No vehicles found in the inventory.");
        } else {
            System.out.println("All Vehicles:");
            for (Vehicle vehicle : allVehicles) {
                System.out.println(vehicle);
            }
        }

    }

    public static void processAddVehicleRequest() {

        System.out.println("Enter vehicle details:");
        System.out.print("VIN: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Vehicle Type: ");
        String vehicleType = scanner.nextLine();

        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Odometer: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

        dealership.addVehicle(newVehicle);

        System.out.println("Vehicle added successfully!");
    }

    public static void processRemoveVehicleRequest() {

        System.out.println("Enter the VIN of the vehicle to remove:");
        int vinToRemove = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vinToRemove) {
                dealership.removeVehicle(vehicle);
                System.out.println("Vehicle removed successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Vehicle with VIN " + vinToRemove + " not found in the inventory.");
        }
    }
}