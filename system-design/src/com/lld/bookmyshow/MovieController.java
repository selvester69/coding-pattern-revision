package com.lld.bookmyshow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.lld.bookmyshow.enums.City;

public class MovieController {
	Map<City, List<Movie>> cityVsMovies;
	List<Movie> allMovies;

	public MovieController() {
		cityVsMovies = new HashMap<City, List<Movie>>();
		allMovies = new ArrayList<Movie>();
	}

	void addMovie(Movie movie, City city) {
		allMovies.add(movie);
		List<Movie> movies = cityVsMovies.getOrDefault(city, new ArrayList<Movie>());
		movies.add(movie);
		cityVsMovies.putIfAbsent(city, movies);
	}

	Movie getMovieByName(String movieName) {
		Optional<Movie> optional = allMovies.stream().filter(movie -> movie.movieName.equalsIgnoreCase(movieName))
				.findFirst();
		return optional.orElse(null);
	}

	List<Movie> getMoviesByCity(City city) {
		return cityVsMovies.get(city);
	}
	//REMOVE movie from a particular city, make use of cityVsMovies map

    //UPDATE movie of a particular city, make use of cityVsMovies map

    //CRUD operation based on Movie ID, make use of allMovies list


}
