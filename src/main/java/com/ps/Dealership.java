package com.ps;

import java.util.ArrayList;

public class Dealership {

    //ArrayList <Vehicle> = new ArrayList<>()

    private String name;
    private String address;
    private String phone;
    private ArrayList <Vehicle> inventory ;

    public Dealership() {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", inventory=" + inventory +
                '}';
    }

    //addVehicle
    public void addVehicle(Vehicle vehicle){
        this.inventory.add(vehicle);
    }


    //getAllVehicle
    public ArrayList<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    //removeVehicle
    public void removeVehicle(Vehicle vehicleIndex){
        this.inventory.remove(vehicleIndex);
    }

    //Search Vehicles by categories
    public ArrayList<Vehicle> getVehiclesByPrice(float min, float max) {
        ArrayList<Vehicle> vehiclesToDisplay = new ArrayList<>();

        for(Vehicle vehicle: this.inventory){
            if(vehicle.getPrice() > min && vehicle.getPrice() < max){
                vehiclesToDisplay.add(vehicle);
            }
        }

        return vehiclesToDisplay;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return new ArrayList<>();
    }
    public ArrayList<Vehicle> getVehiclesByYear(int year) {
        return new ArrayList<>();
    }
    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        return new ArrayList<>();
    }
    public ArrayList<Vehicle> getVehicleByMileage(int mileage){
        return null;
    }
    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        return new ArrayList<>();
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

//    public void setInventory(Vehicle[] inventory) {
//        this.inventory = inventory;
//    }
}
