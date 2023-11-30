package com.example.majorprogrammingproject;

public class Restaurant {
    protected String name;
    protected String typeOfFood;
    protected String address;
    protected String phoneNumber;

    public static Restaurant CreateRestaurant(String[] restaurantInfo) {
        Restaurant createdRestaurant = new Restaurant();
        createdRestaurant.name = restaurantInfo[0];
        createdRestaurant.typeOfFood = restaurantInfo[1];
        createdRestaurant.address = restaurantInfo[2];
        createdRestaurant.phoneNumber = restaurantInfo[3];

        return createdRestaurant;
    }
}
