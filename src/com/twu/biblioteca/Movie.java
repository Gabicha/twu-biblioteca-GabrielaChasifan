package com.twu.biblioteca;

/**
 * Created by gchasifa on 6/10/15.
 */
public class Movie {
    private int status;

    public String getName() {
        return name;
    }

    private String name;

    public int getYear() {
        return year;
    }

    private int year;

    public String getDirector() {
        return director;
    }

    private String director;

    public String getRating() {
        return rating;
    }

    private String rating;

    public Movie(String name, int year, String director, String rating, int status) {
        this.name = name.toUpperCase();
        this.year = year;
        this.director = director.toUpperCase();
        this.rating = rating.toUpperCase();
        this.status = status;
    }

    public boolean validateRating() throws Exception {
        if (!"UNRATED".equals(rating)) {
            if (rating.compareTo("10") <= 0 && rating.compareTo("1") >= 0) {
                return true;
            } else {
                throw new Exception("Invalid Rating");
            }
        }
        return true;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status){
        this.status=status;
    }

    public String getMovieInformation() {
        String movieName = "NAME: "+name+ "\n";
        String movieYear = "YEAR: "+year+"\n";
        String movieDirector = "DIRECTOR: "+director +"\n";
        String movieRating = "RATING: "+rating +"\n";
        return movieName+movieYear+movieDirector+movieRating;
    }
}
