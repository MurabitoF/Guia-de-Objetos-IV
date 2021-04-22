package com.company;

import java.time.LocalDate;

public class Client {
    private String name;
    private String phone;
    private String address;

    public Client(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Ticket rentMovie(Movie movie){
        LocalDate rentDate = LocalDate.now();
        movie.removeCopy();
        return new Ticket(rentDate, this, movie);
    }

    public void returnMovie(Ticket ticket){
        ticket.setMovieReturned(true);
        ticket.getMovie().addCopy();
    }
}
