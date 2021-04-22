package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Movie {
    private String title;
    private String genre;
    private LocalDate releaseDate;
    private Integer runTime;
    private String rating;
    private String country;
    private String description;
    private int stock;

    public Movie(String title, String genre, LocalDate releaseDate, Integer runTime, String rating, String country, String description, int stock) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.runTime = runTime;
        this.rating = rating;
        this.country = country;
        this.description = description;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getRunTime() {
        return runTime;
    }

    public void setRunTime(Integer runTime) {
        this.runTime = runTime;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void addCopy(){
        this.stock++;
    }

    public void removeCopy(){
        this.stock--;
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Movie: " +
                "title= %s, " +
                "genre= %s, " +
                "release date= %s, " +
                "run time= %d, " +
                "rating= %s, " +
                "country= %s, " +
                "copies= %d\n " +
                "description= %s", this.title, this.genre, this.releaseDate.format(formatter), this.runTime, this.rating, this.country, this.stock, this.description);
    }
}
