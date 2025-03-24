package ie.atu.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a movie object
        Movie movie = new Movie("The Matrix", "Wachowskis", 1999, 8.7);
        System.out.println("Original Movie: " + movie);

        // Serialize
        try (FileOutputStream fileOut = new FileOutputStream("resources/movie.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(movie);
            System.out.println("Movie has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize
        try (FileInputStream fileIn = new FileInputStream("resources/movie.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Movie deserializedMovie = (Movie) in.readObject();
            System.out.println("Movie has been deserialized");
            System.out.println("Deserialized Movie: " + deserializedMovie);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // DIY Task 3: Movie Catalog
        System.out.println("\n--- Movie Catalog Implementation ---");

        // Create a catalog of movies
        List<Movie> movieCatalog = new ArrayList<>();
        movieCatalog.add(new Movie("The Matrix", "Wachowskis", 1999, 8.7));
        movieCatalog.add(new Movie("Inception", "Christopher Nolan", 2010, 8.8));
        movieCatalog.add(new Movie("The Dark Knight", "Christopher Nolan", 2008, 9.0));
        movieCatalog.add(new Movie("Pulp Fiction", "Quentin Tarantino", 1994, 8.9));
        movieCatalog.add(new Movie("Interstellar", "Christopher Nolan", 2014, 8.6));

        // Display original catalog
        movieCatalog.forEach(System.out::println);

        // Serialize the catalog - inline instead of using the static method
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("resources/movie_catalog.ser"))) {
            out.writeObject(movieCatalog);
            System.out.println("\nCatalog has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the catalog - inline instead of using the static method
        List<Movie> loadedCatalog = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("resources/movie_catalog.ser"))) {
            loadedCatalog = (List<Movie>) in.readObject();
            System.out.println("Catalog has been deserialized");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Display deserialized catalog
        System.out.println("\nDeserialized Movie Catalog:");
        for (Movie m : loadedCatalog) {
            System.out.println(m);
        }

        // DIY Task 4: Bank Account
        System.out.println("\n--- Bank Account Implementation ---");

        // Create a bank account
        BankAccount account = new BankAccount("1234567890", "Jane Doe", 1000.0, "9876");
        System.out.println("Unserialized Account: " + account);

        // Serialize the account
        try (FileOutputStream fileOut = new FileOutputStream("resources/account.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(account);
            System.out.println("Account has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create an object to hold the Deserialized account
        BankAccount deserializedAccount = null;

        try (FileInputStream fileIn = new FileInputStream("resources/account.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            deserializedAccount = (BankAccount) in.readObject();
            System.out.println("Account has been deserialized");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Print account details from toString method
        System.out.println("Deserialized Account: " + deserializedAccount);

        // DIY Task 5: Game Save System
        System.out.println("\n--- Game Save System Implementation ---");
        
        // Create Version 1 game save
        GameSave gameSave = new GameSave("Player1", 1000, 5);
        System.out.println("Creating Version 1 save:");
        System.out.println(gameSave);
        
        // Save the game (serialize)
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("resources/gamesave_v1.ser"))) {
            out.writeObject(gameSave);
            System.out.println("Save file created successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Try to load the game (deserialize)
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("resources/gamesave_v1.ser"))) {
            GameSave loadedSave = (GameSave) in.readObject();
            System.out.println("\nLoaded game save:");
            System.out.println(loadedSave);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("\nError loading save file: " + e.getMessage());
            e.printStackTrace();
        }

        // DIY Task 5: Game Save System - Part 2 (Version 2)
        System.out.println("\n--- Game Save System Version 2 Implementation ---");
        
        // Create Version 2 game save
        List<String> achievements = new ArrayList<>();
        achievements.add("First Victory");
        achievements.add("Treasure Hunter");
        
        GameSave gameSaveV2 = new GameSave("Player2", 2500, 10, 3600);
        System.out.println("Creating Version 2 save:");
        System.out.println(gameSaveV2);
        
        // Save the Version 2 game (serialize)
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("resources/gamesave_v2.ser"))) {
            out.writeObject(gameSaveV2);
            System.out.println("Version 2 save file created successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Attempt to load the Version 1 save with Version 2 class
        System.out.println("\nAttempting to load Version 1 save with Version 2 class:");
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("resources/gamesave_v1.ser"))) {
            GameSave loadedSave = (GameSave) in.readObject();
            System.out.println("Loaded game save:");
            System.out.println(loadedSave);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading save file: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }
}
