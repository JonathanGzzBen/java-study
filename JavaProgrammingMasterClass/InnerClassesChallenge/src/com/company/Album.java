package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private SongList songList;

    public Album() {
        this.songList = new SongList();
    }

    public Album(String name, String artist) {
        this();
        this.name = name;
        this.artist = artist;
    }

    public boolean addSong(String title, String duration) {
        return this.songList.addSong(new Song(title, duration));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        Song checkedSong = this.songList.findSong(trackNumber);
        if (checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = this.songList.findSong(title);
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

    private static class SongList {
        private List<Song> songList;

        public SongList() {
            songList = new ArrayList<>();
        }

        public boolean addSong(Song song) {
            if (songList.contains(song)) {
                return false;
            }
            this.songList.add(song);
            return true;
        }

        public Song findSong(String title) {
            for (Song song: this.songList) {
                if (song.getTitle().equals(title))
                    return song;
            }
            return null;
        }

        public Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if ((index >= 0) && (index < songList.size())) {
                return songList.get(index);
            }
            return null;
        }

        public Song getSong(int index) {
            if (index >= 0 && songList.size() > 0) {
                return songList.get(index);
            }
            return null;
        }

        public int getSize() {
            return songList.size();
        }
    }
}
