package com.example.majorprogrammingproject;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class FileEditor {
    static FilenameFilter txtFilesOnly = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".txt");
        }
    };

    public static ArrayList<Restaurant> CreateArrayOfTextFiles() throws FileNotFoundException, MyLinkedListException {
        File folder = new File("./src/main/resources/Saved/");
        File[] listOfFiles = folder.listFiles(txtFilesOnly);
        String[] savedValues = new String[4];
        int index = 0;
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        assert listOfFiles != null;
        for (File element : listOfFiles) {
            Scanner fileReader = new Scanner(element);
            while (fileReader.hasNextLine()) {
                String temp = fileReader.nextLine();
                switch (index) {
                    case 0:
                        savedValues[index] = temp.substring(17);
                        break;
                    case 1:
                    case 3:
                        savedValues[index] = temp.substring(14);
                        break;
                    case 2:
                        savedValues[index] = temp.substring(9);
                        break;
                }
                index++;
            }
            index = 0;
            restaurants.add(Restaurant.CreateRestaurant(savedValues));
            boolean alreadyInList = false;
            for (int i = 0; i < main.getRestaurantList().size(); i++) {
                if (Objects.equals(main.getRestaurantList().get(i).name, savedValues[0])) {
                    alreadyInList = true;
                    break;
                }
            }
            if (!alreadyInList) {
                main.addToList(savedValues);
            }
        }
        return restaurants;
    }

    public static void CreateFile(String[] restaurantInformation) {
        try {
            File newFile = new File("./src/main/resources/Saved/" + restaurantInformation[0] + ".txt");
            if (newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
                main.addToStack(restaurantInformation);
                main.addToList(restaurantInformation);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void WriteToFile(String[] restaurantInformation) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./src/main/resources/Saved/" + restaurantInformation[0] + ".txt"));
            writer.write("Restaurant Name: " + restaurantInformation[0]);
            writer.newLine();
            writer.write("Type Of Food: " + restaurantInformation[1]);
            writer.newLine();
            writer.write("Address: " + restaurantInformation[2]);
            writer.newLine();
            writer.write("Phone Number: " + restaurantInformation[3]);
            writer.close();
        } catch (IOException e) {
            System.out.println("An Error Occurred");
            e.printStackTrace();
        }
    }
}