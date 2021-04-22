package com.company;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        List<Client> clients = new ArrayList<>();
        List<Movie> movies = new ArrayList<>();
        List<Ticket> tickets = new ArrayList<>();

        movies.add(new Movie("Duro de matar", "Accion", LocalDate.of(1988, 12, 15), 131, "R",
                "USA", "El pela los hace cagar a todos", 2));
        movies.add(new Movie("Duro de matar 2", "Accion", LocalDate.of(1990, 6, 29), 124, "R",
                "USA", "El pela los hace cagar a todos otra vez", 4));
        movies.add(new Movie("Indiana Jones y los cazadores del arca perdida", "Aventura", LocalDate.of(1981, 6, 12), 115, "R",
                "USA", "El Harrison Ford los hace cagar a todos", 5));
        movies.add(new Movie("Beetlejuice, el súper fantasma", "Comedia", LocalDate.of(1988, 4, 21), 93, "G",
                "USA", "La unica pelicula buena de Tim Burton", 3));
        movies.add(new Movie("El resplandor", "Horror", LocalDate.of(1980, 12, 25), 146, "R",
                "USA", "jaja mira de ahi salio ese meme", 6));
        movies.add(new Movie("Cosmos: un viaje personal", "Documental", LocalDate.of(1980, 9, 28), 520, "G",
                "USA", "Temporada 1", 2));

        clients.add(new Client("Franco", "45546546", "Calle 1234"));
        clients.add(new Client("Luciana", "42323463", "Calle 4334"));
        clients.add(new Client("Mariano", "45484465", "Calle 1434"));
        clients.add(new Client("Martha", "49875454", "Calle 1879"));

        do {
            System.out.println("Bienvenido al VideoClub Roberto");
            System.out.println();
            System.out.println("1- Agregar nueva pelicula");
            System.out.println("2- Alquilar pelicula");
            System.out.println("3- Ver peliculas alquiladas");
            System.out.println("4- Ver devoluciones de hoy");
            System.out.println("5- Ver alquileres de un cliente");
            System.out.println("6- Peliculas mas alquiladas");
            System.out.println("7- Buscar peliculas por genero");
            System.out.println("8- Ver detalles de una pelicula");
            System.out.println("0- Salir");
            System.out.println();
            System.out.print(">>> ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
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

                    movies.add(new Movie(title, genre, releaseDate, runTime, rating, country, description, copies));
                    break;
                case 2:
                    System.out.print("Ingrese nombre cliente: ");
                    Client rentClient = findClient(scanner.nextLine(), clients);
                    if (rentClient == null) {
                        rentClient = registerClient();
                        clients.add(rentClient);
                    }
                    System.out.print("Ingrese el titulo de la pelicula: ");
                    Movie rentalMovie = findMovie(scanner.nextLine(), movies);
                    if (rentalMovie != null) {
                        tickets.add(rentClient.rentMovie(rentalMovie));
                        System.out.println(String.format("La pelicula %s ha sido alquilada por %s", rentalMovie.getTitle(), rentClient.getName()));
                    } else {
                        System.out.println("\u001B[31m" + "Error! la pelicula no esta disponible" + "\\u001B[0m");
                    }
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Listado de alquileres");
                    System.out.println();
                    if (tickets.isEmpty()) {
                        System.out.println("No hay alquileres vigentes");
                    } else {
                        for (Ticket ticket : tickets) {
                            if (!ticket.getMovieReturned()) {
                                System.out.println(ticket);
                            }
                        }
                    }
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("Devoluciones de hoy");
                    System.out.println();
                    if (tickets.isEmpty()) {
                        System.out.println("No hay devoluciones hoy");
                    } else {
                        for (Ticket ticket : tickets) {
                            if (!ticket.getMovieReturned() && ticket.getReturnDay().isEqual(LocalDate.now())) {
                                System.out.println(ticket);
                            }
                        }
                    }
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.println("Alquileres de cliente");
                    System.out.println();
                    System.out.print("Nombre del cliente: ");
                    Client foundClient = findClient(scanner.nextLine(), clients);

                    if (foundClient == null) {
                        System.out.println("El cliente no existe");
                    } else {
                        Ticket[] lastTickets = lastTickets(foundClient, tickets);
                        for (Ticket ticket : lastTickets) {
                            if(ticket != null){
                                System.out.println(ticket);
                            }
                        }
                    }
                    scanner.nextLine();
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Peliculas por genero");
                    System.out.println();
                    System.out.print("Ingrese genero: ");
                    List<Movie> moviesByGenre = moviesByGenre(scanner.nextLine(), movies);
                    for (Movie movie : moviesByGenre) {
                        System.out.println(movie);
                    }
                    scanner.nextLine();
                    break;
                case 8:
                    System.out.println("Ver detalle de pelicula");
                    System.out.println();
                    System.out.print("Nombre de la pelicula: ");
                    Movie foundMovie = findMovie(scanner.nextLine(), movies);
                    if (foundMovie == null){
                        System.out.println("La pelicula no esta en el inventario");
                    }else{
                        System.out.println(foundMovie);
                    }
                    scanner.nextLine();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Error! opcion no valida");
                    scanner.nextLine();
            }
        } while (opcion != 0);
    }

    public static Client findClient(String name, List<Client> clients) {
        for (Client client : clients) {
            if (name.toLowerCase(Locale.ROOT).compareTo(client.getName().toLowerCase(Locale.ROOT)) == 0) {
                return client;
            }
        }
        return null;
    }

    public static Client registerClient() {
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

    public static Movie findMovie(String title, List<Movie> movies) {
        for (Movie movie : movies) {
            if (title.toLowerCase(Locale.ROOT).compareTo(movie.getTitle().toLowerCase(Locale.ROOT)) == 0 && movie.getStock() >= 1) {
                return movie;
            }
        }
        return null;
    }

    public static Ticket[] lastTickets(Client client, List<Ticket> tickets) {
        Ticket[] lastTicket = new Ticket[10];
        List<Ticket> reverseTickets = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getClient().getName().toLowerCase(Locale.ROOT).equals(client.getName().toLowerCase(Locale.ROOT))) {
                reverseTickets.add(ticket);
            }
        }
        Collections.reverse(reverseTickets);
        reverseTickets.toArray(lastTicket);
        return lastTicket;
    }

    /*public static Movie[] topMovies(List<Movie> movies, List<Ticket> tickets){

    }*/

    public static List<Movie> moviesByGenre(String genre, List<Movie> movies){
        List<Movie> moviesGenre = new ArrayList<>();
        for (Movie movie : movies) {
            if(genre.toLowerCase(Locale.ROOT).equals(movie.getGenre().toLowerCase(Locale.ROOT))){
                moviesGenre.add(movie);
            }
        }
        return moviesGenre;
    }
}
