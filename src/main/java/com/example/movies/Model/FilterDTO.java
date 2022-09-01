package com.example.movies.Model;

public class FilterDTO {
    private String value_1;
    private int value_2;

    public FilterDTO(String value_1, int value_2) {
        this.value_1 = value_1;
        this.value_2 = value_2;
    }

    public FilterDTO() {
    }

    @Override
    public String toString() {
        return "DTO{" +
                "value_1='" + value_1 + '\'' +
                ", value_2='" + value_2 + '\'' +
                '}';
    }

    public String getValue_1() {
        return value_1;
    }

    public void setValue_1(String value_1) {
        this.value_1 = value_1;
    }

    public int getValue_2() {
        return value_2;
    }

    public void setValue_2(int value_2) {
        this.value_2 = value_2;
    }
}
