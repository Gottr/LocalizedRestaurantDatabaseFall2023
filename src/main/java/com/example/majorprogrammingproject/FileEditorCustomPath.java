package com.example.majorprogrammingproject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// Does work with custom paths, sometimes it's unable to find paths such as Desktop or Downloads. Also have to make sure it has permissions to create or modify files in the location.

public class FileEditorCustomPath extends FileEditor {
    public static ArrayList<Restaurant> CreateArrayOfTextFiles(String path) throws FileNotFoundException {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles(txtFilesOnly);
        String savedValues[] = new String[4];
        int index = 0;
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        assert listOfFiles != null;
        for(File element : listOfFiles) {
            Scanner fileReader = new Scanner(element);
            while (fileReader.hasNextLine()) {
                String temp = fileReader.nextLine();
                switch(index) {
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
            index=0;
            restaurants.add(Restaurant.CreateRestaurant(savedValues));
        }
        return restaurants;
    }

    public static void CreateFile(String[] restaurantInformation) {
        try {
            File newFile = new File(main.getPath() +"/"+ restaurantInformation[0] + ".txt");
            if(newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
                main.addToStack(restaurantInformation);
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
            BufferedWriter writer = new BufferedWriter(new FileWriter(main.getPath() + "/" + restaurantInformation[0] + ".txt"));
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

