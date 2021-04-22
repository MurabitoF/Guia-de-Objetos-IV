package com.company;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private LocalDate rentDay;
    private Client client;
    private Movie movie;
    private Boolean movieReturned;

    public Ticket(LocalDate rentDay, Client client, Movie movie) {
        this.rentDay = rentDay;
        this.client = client;
        this.movie = movie;
        this.movieReturned = false;
    }

    public LocalDate getRentDay() {
        return rentDay;
    }

    public void setRentDay(LocalDate rentDay) {
        this.rentDay = rentDay;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Boolean getMovieReturned() {
        return movieReturned;
    }

    public void setMovieReturned(Boolean movieReturned) {
        this.movieReturned = movieReturned;
    }

    public LocalDate getReturnDay(){
        return this.rentDay.plusDays(7);
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Ticket: " +
                "client: %s, " +
                "movie: %s, " +
                "rent day: %s, " +
                "return day: %s, " +
                "movie returned: %b", this.client.getName(), this.movie.getTitle(), this.rentDay.format(formatter), this.getReturnDay().format(formatter),this.movieReturned);
    }
}
