package com.example.filmdemo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movies", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"imdbId"})
})
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String director;

	@Column(nullable = false)
	private Integer releaseYear;

	@Column(nullable = false, unique = true)
	private String imdbId;

	public Movie() {
	}

	public Movie(String title, String director, Integer releaseYear, String imdbId) {
		this.title = title;
		this.director = director;
		this.releaseYear = releaseYear;
		this.imdbId = imdbId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	@Override
	public String toString() {
		return "Movie{" +
				"id=" + id +
				", title='" + title + "'" +
				", director='" + director + "'" +
				", releaseYear=" + releaseYear +
				", imdbId='" + imdbId + "'" +
				'}' + "\n";
	}
}