package com.example.majorprogrammingproject;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainInterfaceController {
    public TextField name;
    public TextField address;
    public TextField phoneNumber;
    public TextField typeOfFood;
    public TextField pathTextField;
    public TextField searchTextField;

    public void EnterInformation(ActionEvent e) {
        String[] restaurantInformation = GetText();
        if(restaurantInformation[0].isEmpty() || restaurantInformation[1].isEmpty() || restaurantInformation[2].isEmpty() || restaurantInformation[3].isEmpty()) {
            System.out.println("Error! All fields must be filled before pressing enter.");
        } else {
            if(pathTextField.getText().isEmpty()) {
                FileEditor.CreateFile(restaurantInformation);
                FileEditor.WriteToFile(restaurantInformation);
                ClearText();
            } else if (!pathTextField.getText().isEmpty()) {
                main.setPath(pathTextField.getText());
                FileEditorCustomPath.CreateFile(restaurantInformation);
                FileEditorCustomPath.WriteToFile(restaurantInformation);
            }
        }
    }

    public void UnhidePath(ActionEvent e) {
        if(pathTextField.isVisible()) {
            pathTextField.setVisible(false);
        } else {
            pathTextField.setVisible(true);
        }
    }

    public void ClearText() {
        name.clear();
        typeOfFood.clear();
        address.clear();
        phoneNumber.clear();
    }

    public String[] GetText() {
        String textArray[] = new String[4];
        textArray[0] = name.getText();
        textArray[1] = typeOfFood.getText();
        textArray[2] = address.getText();
        textArray[3] = phoneNumber.getText();

        return textArray;
    }

    public void SearchForCuisine() throws FileNotFoundException, MyLinkedListException {
        ArrayList<Restaurant> allRestaurants;
        if(pathTextField.getText().isEmpty()) {
            allRestaurants = FileEditor.CreateArrayOfTextFiles();
        } else {
            allRestaurants = FileEditorCustomPath.CreateArrayOfTextFiles(pathTextField.getText());
        }

        String names[] = new String[allRestaurants.size()];
        for (int i = 0; i < allRestaurants.size(); i++) {
            names[i] = allRestaurants.get(i).name;
        }
        QuickSort.QuickSort(names);

        ArrayList<Restaurant> restaurantsMatchingCuisine = new ArrayList<>();

        if(!searchTextField.getText().isEmpty()) {
            for (Restaurant element : allRestaurants) {
                if(element.typeOfFood.equalsIgnoreCase(searchTextField.getText())) {
                    restaurantsMatchingCuisine.add(element);
                }
            }
        }

        if(!restaurantsMatchingCuisine.isEmpty()) {
            System.out.println("There are " + restaurantsMatchingCuisine.size() + " restaurants serving " + restaurantsMatchingCuisine.get(0).typeOfFood);
            for(Restaurant element : restaurantsMatchingCuisine) {
                System.out.println(element.name);
            }
        } else if (!searchTextField.getText().isEmpty() && restaurantsMatchingCuisine.isEmpty()){
            System.out.println(restaurantsMatchingCuisine.size());
            System.out.println("There are 0 restaurants serving " + searchTextField.getText());
        }
        main.searchNode(main.getRestaurantList().size());
        restaurantsMatchingCuisine.clear();
    }

    public void GetLastCreatedFile() {
        Restaurant lastRestaurantCreated = main.getLastCreated();
        if (lastRestaurantCreated != null) {
            System.out.println("Last Restaurant Registered: " + lastRestaurantCreated.name);
        } else {
            System.out.println("No Restaurant Has Been Registered in This Session!");
        }
    }
}
