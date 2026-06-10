/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moviebookingsystem;

import java.util.ArrayList;
import java.util.List;

public class DataStoreU {

    // ========== CURRENT BOOKING ==========
    public static String email = "";
    public static String txtFullName = "";
    public static String txtEmail = "";
    public static String txtMobile = "";
    public static String gender = "";
    public static int spnAge = 0;
    public static String movieName = "";
    public static String movieGenre = "";
    public static String bookingId = "";
    public static String cinemaName = "";
    public static String city = "";
    public static String date = "";
    public static String day = "";
    public static String showtime = "";
    public static String selectedSeats = "";
    public static double totalSeatPrice = 0.0;
    public static String paymentMethod = "";
    public static double amountPaid = 0.0;
    public static String fullName = "";
   
    public static String mobileNumber = "";
    
    public static int age = 0;

    // ========== BOOKING HISTORY ==========
    public static List<String[]> allBookings = new ArrayList<>();
    public static double totalRevenue = 0.0;
    public static int bookingsToday = 0;
    static String movieIdCounter;

    public static void saveBookingToHistory() {
        String[] record = {
            bookingId,
            movieName,
            cinemaName,
            day + " " + date + " @ " + showtime,
            selectedSeats,
            "Rs." + amountPaid,
            paymentMethod,
            "Confirmed"
        };
        allBookings.add(record);
        totalRevenue += amountPaid;
        bookingsToday++;
    }

    // ========== MOVIES ==========
    public static List<Movie> movies = new ArrayList<>();
    public static int editingMovieIndex = -1;
    public static Movie editingMovie = null;

    // ========== THIS RUNS AUTOMATICALLY WHEN APP STARTS ==========
    static {
        loadDefaultMovies(); // Always load defaults first
    }

    // ========== DEFAULT MOVIES — ALWAYS AVAILABLE ==========
    public static void loadDefaultMovies() {
        movies.clear();
        movies.add(new Movie("M001", "Avengers",
            "Action/Adventure", "2h 30m", "4.7",
            "Earth's mightiest heroes must come together"));
        movies.add(new Movie("M002", "Inception",
            "Fantasy/Adventure", "2h 28m", "4.5",
            "A thief who steals corporate secrets through dreams"));
        movies.add(new Movie("M003", "Zootopia 2",
            "Animated/Adventure", "1h 55m", "4.2",
            "Judy and Nick return for a new adventure"));
        movies.add(new Movie("M004", "Chhorii 2",
            "Horror/Thriller", "2h 10m", "4.3",
            "A terrifying sequel to the horror hit"));
        movies.add(new Movie("M005", "Unlocked",
            "Thriller", "2h 05m", "4.8",
            "A deadly game of cat and mouse"));
        movies.add(new Movie("M006", "Kabeer",
            "Drama/Action", "2h 20m", "4.0",
            "An action-packed drama of survival"));
    }

    // ========== SAVE MOVIES TO FILE ==========
    public static void saveMoviesToFile() {
        try {
            String path = System.getProperty("user.dir") + "/movies.txt";
            java.io.BufferedWriter writer = new java.io.BufferedWriter(
                new java.io.FileWriter(path));
            for (Movie m : movies) {
                writer.write(
                    m.id + "|" + m.title + "|" + m.genre + "|" +
                    m.duration + "|" + m.rating + "|" + m.description);
                writer.newLine();
            }
            writer.close();
            System.out.println("Saved to: " + path);
        } catch (Exception e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }

    // ========== LOAD MOVIES FROM FILE ==========
    public static void loadMoviesFromFile() {
        try {
            String path = System.getProperty("user.dir") + "/movies.txt";
            java.io.File file = new java.io.File(path);

            // If file doesn't exist, keep defaults
            if (!file.exists()) {
                System.out.println("No file found, using defaults.");
                return;
            }

            java.io.BufferedReader reader = new java.io.BufferedReader(
                new java.io.FileReader(file));

            List<Movie> loaded = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split("\\|");
                    if (parts.length >= 6) {
                        loaded.add(new Movie(
                            parts[0].trim(),
                            parts[1].trim(),
                            parts[2].trim(),
                            parts[3].trim(),
                            parts[4].trim(),
                            parts[5].trim()
                        ));
                    }
                }
            }
            reader.close();

            // Only replace if file had data
            if (!loaded.isEmpty()) {
                movies.clear();
                movies.addAll(loaded);
                System.out.println("Loaded " + movies.size() + " movies from file.");
            }

        } catch (Exception e) {
            System.out.println("Load error: " + e.getMessage());
        }
    }
}