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
        System.out.println("Original Movie Catalog:");
        for (Movie m : movieCatalog) {
            System.out.println(m);
        }
        
        // Serialize the catalog
        serializeMovieCatalog(movieCatalog, "resources/movie_catalog.ser");
        
        // Deserialize the catalog
        List<Movie> loadedCatalog = deserializeMovieCatalog("resources/movie_catalog.ser");
        
        // Display deserialized catalog
        System.out.println("\nDeserialized Movie Catalog:");
        for (Movie m : loadedCatalog) {
            System.out.println(m);
        }
    }
    
    private static void serializeMovieCatalog(List<Movie> movies, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            out.writeObject(movies);
            System.out.println("\nCatalog has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static List<Movie> deserializeMovieCatalog(String filename) {
        List<Movie> movies = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filename))) {
            movies = (List<Movie>) in.readObject();
            System.out.println("Catalog has been deserialized");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
