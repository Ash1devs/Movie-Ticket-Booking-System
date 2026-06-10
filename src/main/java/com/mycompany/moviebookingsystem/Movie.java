/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moviebookingsystem;

/**
 *
 * @author Dell
 */
public class Movie {
    public String id;
    public String title;
    public String genre;
    public String duration;
    public String rating;
    public String description;
    public java.awt.Color cardColor;
    
    // Constructor
    public Movie(String id, String title, String genre, 
                 String duration, String rating, String description) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
        this.description = description;
        this.cardColor = getRandomColor();
    }
    
    // Generates random nice color for movie card
    private java.awt.Color getRandomColor() {
        java.awt.Color[] colors = {
            new java.awt.Color(220, 50, 50),   // Red
            new java.awt.Color(50, 120, 220),   // Blue
            new java.awt.Color(50, 160, 100),   // Green
            new java.awt.Color(180, 80, 180),   // Purple
            new java.awt.Color(220, 140, 40),   // Orange
            new java.awt.Color(40, 160, 180),   // Teal
            new java.awt.Color(180, 60, 120),   // Pink
        };
        return colors[(int)(Math.random() * colors.length)];
    }
}