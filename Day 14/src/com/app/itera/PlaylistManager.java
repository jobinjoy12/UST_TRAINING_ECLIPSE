package com.app.itera;

import java.util.ArrayList;
import java.util.List;

public class PlaylistManager {
    public static void main(String[] args) {
        List<Song> playlist = new ArrayList<>();
        Song s1 = new Song("Jobin" , "Jobin",179);
        Song s2 = new Song("Happy" , "Jobin",159);
        Song s3 = new Song("Sad" , "Jobin",200);
        Song s4 = new Song("Arry" , "Jobin",110);
        Song s5 = new Song("Angry" , "Jobin",120);
        Song s6 = new Song("Emotionless" , "Jobin",90);
        playlist.add(s1);
        playlist.add(s2);
        playlist.add(s3);
        playlist.add(s4);
        playlist.add(s5);
        playlist.add(s6);

    for(Song obj:playlist){
        System.out.println(obj.toString);
    }
    }
}
