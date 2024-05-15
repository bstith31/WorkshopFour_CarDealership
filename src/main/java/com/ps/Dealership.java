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
    public ArrayList<Vehicle> addVehicle(Vehicle vehicle) {
//        this.inventory.add();
        return null;
    }


    //getAllVehicle
    public ArrayList<Vehicle> getAllVehicle() {
        return this.inventory;
    }

    //removeVehicle
    public ArrayList<Vehicle> removeVehicle() {
//          this.inventory.remove();
          return null;
       }

    //Search Vehicles by categories
    public ArrayList<Vehicle> getVehicleByPrice(int price){
        return null;
    }
    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model){
        return null;
    }
    public ArrayList<Vehicle> getVehicleByYear(int year){
        return null;
    }
    public ArrayList<Vehicle> getVehicleByColor(String color){
        return null;
    }
    public ArrayList<Vehicle> getVehicleByMileage(int mileage){
        return null;
    }
    public ArrayList<Vehicle> getVehicleByType(String vehicleType){
        return null;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

//    public void setInventory(Vehicle[] inventory) {
//        this.inventory = inventory;
//    }
}
