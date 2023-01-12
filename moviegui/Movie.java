package moviegui;
import java.sql.Date;



public class Movie {
    

    private String original_language;
    private String original_title;
    private String overview;
    private String poster_path;
    private String vote_average;
    private Date year;
    
    


   

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public void setRelease_date(Date year) {
        this.year = year;
    }

    

    public String getOriginal_language() {
        return original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getVote_average() {
        return vote_average;
    }

    public Date getRelease_date() {
        return year;
    }

    

    public Movie(String original_language,String original_title, String overview,String poster_path,String vote_average,Date year){
        
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.year = year;
        this.vote_average = vote_average;
        

    }
    
    
}

