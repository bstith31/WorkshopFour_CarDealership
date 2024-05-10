package com.ps;

import java.io.*;

public class DealershipFileManager {

//    static final String fileName = "inventory.csv";
//    static final String backupFileName = "backup_inventory.csv";
    public Dealership getDealershipInfo() {
        Dealership dealership = new Dealership();
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("inventory.csv"));
            String lines;
            while ((lines = bufReader.readLine()) != null) {
                String[] dealershipInfo = lines.split("|");
                int vin = Integer.parseInt(dealershipInfo[0]);
                int year = Integer.parseInt(dealershipInfo[1]);
                String make = dealershipInfo[2];
                String model = dealershipInfo[3];
                String vehicleType = dealershipInfo[4];
                String color = dealershipInfo[5];
                int odometer = Integer.parseInt(dealershipInfo[6]);
                double price = Double.parseDouble(dealershipInfo[7]);
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dealership;
    }

        public void savingDealershipHeader(Dealership dealership){
        try{
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter("current_inventory"));
//            bufWriter.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone() + "\n");
            bufWriter.write("id|year|make|model|vehicle type|color|mileage|price\n");
            for (Vehicle vehicle : dealership.getInventory()){
                String lines = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n",
                        vehicle.getVin(), vehicle.getYear(), vehicle.getMake(),vehicle.getModel(),vehicle.getVehicleType(),vehicle.getColor(), vehicle.getOdometer(),vehicle.getPrice());
                bufWriter.write(lines);
            }

        } catch (IOException e){
            e.printStackTrace();
        }


    }
}

