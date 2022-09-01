package com.example.movies.Model;

public class Movie implements Comparable<Movie>{

    private int year;
    private int length;
    private String title;
    private String subject;
    private int popularity;
    private boolean award;


    public Movie() {
    }

    public Movie(int year, int length, String title, String subject, int popularity, boolean award) {
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        this.award = award;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public boolean isAward() {
        return award;
    }

    public void setAward(boolean award) {
        this.award = award;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "year=" + year +
                ", length=" + length +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", popularity=" + popularity +
                ", award=" + award +
                '}';
    }

    @Override
    public int compareTo(Movie o) {
        return this.getLength() - o.getLength();
    }
}
