package com.example.majorprogrammingproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.Random;
import java.util.Stack;

public class main extends Application {

    private static Stack<Restaurant> restaurantStack = new Stack<Restaurant>();
    private static MyLinkedList restaurantList = new MyLinkedList();
    private static BinarySearchTree tree = new BinarySearchTree();
    private static WeightedGraph graph = new WeightedGraph(3);

    private static String path = "./src/main/resources/Saved/";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException, MyLinkedListException {
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("MainInterface.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Restaurant Information");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        FileEditor.CreateArrayOfTextFiles();
    }

    public static void addToStack(String[] restaurantInformation) {
        restaurantStack.push(Restaurant.CreateRestaurant(restaurantInformation));
    }

    public static Restaurant getLastCreated() {
        if (!restaurantStack.isEmpty()) {
            return restaurantStack.peek();
        } else {
            return null;
        }
    }

    public static void addToList(String[] restaurantInformation) {
        restaurantList.insert(Restaurant.CreateRestaurant(restaurantInformation));
        insertNode(restaurantList.size()*10);
        Random rand = new Random();
        int rand1 = rand.nextInt(5);
        int rand2 = rand.nextInt(rand1+1, 10);
        int rand3 = rand.nextInt(10);
        addEdgeToGraph(rand1, rand2, rand3);
    }

    public static MyLinkedList getRestaurantList() {
        return restaurantList;
    }

    public static void setPath(String path) {
        main.path = path;
    }

    public static String getPath() {
        return path;
    }

    public static void insertNode(int key) {
        tree.root = tree.insert(tree.root, key);
        tree.insert(tree.root, key);
    }

    public static int searchNode(int key) {
        if (tree.search(tree.root, restaurantList.size() * 10) == null) {
            System.out.println(key + " was not found!");
            return -1;
        } else {
            System.out.println("Key " + key + " was found!");
            return key;
        }
    }

    public static void addEdgeToGraph(int source, int destination, int weight) {
        graph.addEdge(source, destination, weight);
    }
}
