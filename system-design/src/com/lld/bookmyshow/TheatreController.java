package com.lld.bookmyshow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lld.bookmyshow.enums.City;

public class TheatreController {
	Map<City, List<Theatre>> cityVsTheatre;
	List<Theatre> allTheatres;

	public TheatreController() {
		cityVsTheatre = new HashMap<City, List<Theatre>>();
		allTheatres = new ArrayList<Theatre>();
	}

	void addTheatre(Theatre theatre, City city) {
		allTheatres.add(theatre);
		List<Theatre> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<Theatre>());
		theatres.add(theatre);
		cityVsTheatre.put(city, theatres);
	}

	Map<Theatre, List<Show>> getAllShow(Movie movie, City city) {
		Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();
		List<Theatre> theatres = cityVsTheatre.get(city);
		for (Theatre theatre : theatres) {

			List<Show> givenMovieShows = new ArrayList<>();
			List<Show> shows = theatre.getShows();

			for (Show show : shows) {
				if (show.movie.getMovieId() == movie.getMovieId()) {
					givenMovieShows.add(show);
				}
			}
			if (!givenMovieShows.isEmpty()) {
				theatreVsShows.put(theatre, givenMovieShows);
			}
		}

		return theatreVsShows;

	}

}
