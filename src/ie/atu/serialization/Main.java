package ie.atu.serialization;

import java.io.*;

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
    }
}
