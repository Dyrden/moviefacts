package com.example.movies.Model;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MovieRespository {

    private ArrayList<Movie> listOfMovies;

    public MovieRespository() {
        listOfMovies = new ArrayList<>();
        try {
            File file = new ClassPathResource("imdb-data.csv").getFile();
            Scanner input = new Scanner(file);
            input.nextLine();
            while (input.hasNextLine()) {
                Scanner line = new Scanner(input.nextLine());
                line.useDelimiter(";");
                int year = line.nextInt();
                int length = line.nextInt();
                String title = line.next();
                String subject = line.next();
                int popularity = line.nextInt();
                boolean award = "yes".equalsIgnoreCase(line.next());
                listOfMovies.add(new Movie(year, length, title, subject, popularity, award));
            }
            Collections.sort(listOfMovies);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
    }


    public ArrayList<Movie> wonAwards() {
        ArrayList<Movie> movies = new ArrayList<>();
        for (Movie movie : listOfMovies) {
            if (movie.isAward()) movies.add(movie);
        }

        return movies;
    }


    public String getFirst() {
        return listOfMovies.get(0).toString();
    }


    public Movie getRandom() {
        Random random = new Random();
        return listOfMovies.get(random.nextInt(listOfMovies.size()));
    }


    public ArrayList<Movie> findAllMovies() {
        return listOfMovies;

    }

    public String findAll() {
        return "alle film";
    }

    public ArrayList<Movie> get10Random() {
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i < listOfMovies.size(); i++) numbers.add(i);
        Collections.shuffle(numbers);

        for (int i = 0; i < 10; i++) {
            movies.add(listOfMovies.get(numbers.get(i)));
        }
        return movies;

    }


    public ArrayList<Movie> filter(String value_1, int integer) {
        ArrayList<Movie> movies = new ArrayList<>();
        for (Movie movie : listOfMovies) {
            if (movie.getTitle().toLowerCase().split(value_1).length == integer + 1) movies.add(movie);
        }
        return movies;
    }

    public String genre(String value_1, String value_2) {
        double average1 = findAverageLengthByGenre(value_1);
        double average2 = findAverageLengthByGenre(value_2);
        String result;
        if (average1 > average2) {
            result = value_1 + "'" + average1 + "' on average has longer movies than " + value_2 + "'" + average2 + "'";
        } else {
            result = value_2 + "'" + average2 + "' on average has longer movies than " + value_1 + "'" + average1 + "'";
        }
        return result;
    }




    private double findAverageLengthByGenre(String genre) {
        double average = 0;
        int count = 0;
        for (Movie movie : listOfMovies) {
            if (movie.getSubject().equalsIgnoreCase(genre)) {
                count++;
                average+= movie.getLength();
            }
        }
        return average/count;
    }



}
