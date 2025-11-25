

public class Song {
    private String title;
    private String artist;
    private int durationInSeconds ;
    public Song(String title , String artist,  int durationInSeconds)//constructor for the class Song
    {
        this.artist = artist;
        this.title = title;
        this.durationInSeconds = durationInSeconds;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public int getDurationInSeconds() {
        return durationInSeconds;
    }
    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }
    @Override
    public String toString(){
        return "Title: "+title+", Artist: "+artist+", Duration: "+durationInSeconds;
    }
}
