package com.example.movies.Controller;

import com.example.movies.Model.FilterDTO;
import com.example.movies.Model.GenreDTO;
import com.example.movies.Model.Movie;
import com.example.movies.Model.MovieRespository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MovieController {

    @GetMapping("/")
    public String index() {
        return "/index";
    }


    @ResponseBody
    @GetMapping("/getFirst")
    public String getFirst() {
        MovieRespository MR = new MovieRespository();
        return MR.getFirst();
    }


    @ResponseBody
    @GetMapping("/findAll")
    public String findAll() {
        MovieRespository MR = new MovieRespository();
        return MR.findAll();
    }


    @ResponseBody
    @GetMapping("/getRandom")
    public String getRandom() {
        MovieRespository MR = new MovieRespository();
        return ""+MR.getRandom();
    }


    @ResponseBody
    @GetMapping("/findAllMovies")
    public ArrayList<Movie> findAllMovies() {
        MovieRespository MR = new MovieRespository();
        return MR.findAllMovies();
    }

    @ResponseBody
    @GetMapping("/get10RandomMovies")
    public ArrayList<Movie> get10RandomMovies() {
        MovieRespository MR = new MovieRespository();
        return MR.get10Random();
    }

    @ResponseBody
    @GetMapping("/wonAwards")
    public ArrayList<Movie> wonAwards() {
        MovieRespository MR = new MovieRespository();
        return MR.wonAwards();
    }



    @PostMapping("/filter")
    public String filter(@ModelAttribute FilterDTO dto, Model model) {
        String value_1 = dto.getValue_1();
        int value_2 = dto.getValue_2();

        MovieRespository MR = new MovieRespository();

        ArrayList<Movie> result = MR.filter(value_1, value_2);
        model.addAttribute("result",result);

        return "/filteredMovies";

    }

    @PostMapping("/longest")
    public String longest(@ModelAttribute GenreDTO dto, Model model) {
        String value_1 = dto.getValue_1();
        String value_2 = dto.getValue_2();

        MovieRespository MR = new MovieRespository();

        String result = MR.genre(value_1, value_2);
        model.addAttribute("result",result);

        return "/longestGenre";

    }




}
