package com.oliveiralia.beecrowd2611.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oliveiralia.beecrowd2611.Movie;
import com.oliveiralia.beecrowd2611.projections.MovieMinProjection;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	@Query(nativeQuery = true, value = "SELECT m.id, m.name "
			+ "FROM movies m "
			+ "JOIN genres g ON m.id_genres = g.id "
			+ "WHERE g.description = :genreName;")
	List<MovieMinProjection> search1(String genreName);

}
