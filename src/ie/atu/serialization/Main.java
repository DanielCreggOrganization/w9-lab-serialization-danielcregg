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

    }
}
