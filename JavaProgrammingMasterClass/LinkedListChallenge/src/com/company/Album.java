package com.company;

import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Song> songList = new LinkedList<>();

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public boolean addSong(String title, String duration) {
        if (findSong(title) == null) {
            this.songList.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for (Song song: this.songList) {
            if (song.getTitle().equals(title))
                return song;
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if (index >= 0 && index < this.songList.size()) {
            playlist.add(this.songList.get(index));
            return true;
        }
        System.out.println("this album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
}
