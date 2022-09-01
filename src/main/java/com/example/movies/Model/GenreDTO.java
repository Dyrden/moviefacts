package com.example.movies.Model;

public class GenreDTO {

    private String value_1;
    private String value_2;

    @Override
    public String toString() {
        return "genreDTO{" +
                "value_1='" + value_1 + '\'' +
                ", value_2='" + value_2 + '\'' +
                '}';
    }

    public GenreDTO() {
    }


    public GenreDTO(String value_1, String value_2) {
        this.value_1 = value_1;
        this.value_2 = value_2;
    }

    public String getValue_1() {
        return value_1;
    }

    public void setValue_1(String value_1) {
        this.value_1 = value_1;
    }

    public String getValue_2() {
        return value_2;
    }

    public void setValue_2(String value_2) {
        this.value_2 = value_2;
    }
}
