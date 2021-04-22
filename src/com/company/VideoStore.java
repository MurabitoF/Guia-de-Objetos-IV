package com.company;

import java.time.LocalDate;
import java.util.*;

public class VideoStore {
    private List<Client> clients;
    private List<Movie> movies;
    private List<Ticket> tickets;

    public VideoStore(List<Client> clients, List<Movie> movies, List<Ticket> tickets) {
        this.clients = clients;
        this.movies = movies;
        this.tickets = tickets;
    }

    public VideoStore() {
        this.clients = new ArrayList<>();
        this.movies = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    private Movie createMovie(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Titulo: ");
        String title = scanner.nextLine();
        System.out.print("Genero: ");
        String genre = scanner.nextLine();
        System.out.print("Fecha de lanzamiento: ");
        LocalDate releaseDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Duracion: ");
        Integer runTime = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Clasificacion: ");
        String rating = scanner.nextLine();
        System.out.print("Pais de origen: ");
        String country = scanner.nextLine();
        System.out.print("Descripcion: ");
        String description = scanner.nextLine();
        System.out.print("Nro de copias: ");
        int copies = scanner.nextInt();

        return new Movie(title, genre, releaseDate, runTime, rating, country, description, copies);
    }

    public void addMovie(){
        this.movies.add(createMovie());
    }

    public Movie findMovie(String title) {
        for (Movie movie : this.movies) {
            if (title.toLowerCase(Locale.ROOT).compareTo(movie.getTitle().toLowerCase(Locale.ROOT)) == 0 && movie.getStock() >= 1) {
                return movie;
            }
        }
        return null;
    }

    public List<Movie> moviesByGenre(String genre){
        List<Movie> moviesGenre = new ArrayList<>();
        for (Movie movie : movies) {
            if(genre.toLowerCase(Locale.ROOT).equals(movie.getGenre().toLowerCase(Locale.ROOT))){
                moviesGenre.add(movie);
            }
        }
        return moviesGenre;
    }

    /*public Movie[] topMovies(){

    }*/


    private Client createClient(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Registro clientes");
        System.out.println();
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Telefono: ");
        String phone = scanner.nextLine();
        System.out.print("Direccion: ");
        String address = scanner.nextLine();

        return new Client(name, phone, address);
    }

    public void registerClient() {
        this.clients.add(this.createClient());
    }

    public  Client findClient(String name) {
        for (Client client : this.clients) {
            if (name.toLowerCase(Locale.ROOT).compareTo(client.getName().toLowerCase(Locale.ROOT)) == 0) {
                return client;
            }
        }
        return null;
    }

    public Ticket[] lastTickets(Client client) {
        Ticket[] lastTicket = new Ticket[10];
        List<Ticket> reverseTickets = new ArrayList<>();
        for (Ticket ticket : this.tickets) {
            if (ticket.getClient().getName().toLowerCase(Locale.ROOT).equals(client.getName().toLowerCase(Locale.ROOT))) {
                reverseTickets.add(ticket);
            }
        }
        Collections.reverse(reverseTickets);
        reverseTickets.toArray(lastTicket);
        return lastTicket;
    }

    public Ticket findTicket(Client client, Movie movie){
        for (Ticket ticket : this.tickets) {
            if (client.equals(ticket.getClient()) && movie.equals(ticket.getMovie()) && !ticket.getMovieReturned()){
                return ticket;
            }
        }
        return null;
    }

}
