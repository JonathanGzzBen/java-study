package com.company;

import java.util.*;

public class Main {

    private static List<Album> albumList = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", "4:40");
        album.addSong("Love don't mean a thing", "4:30");
        album.addSong("Holy man", "4:21");
        album.addSong("Hold on", "4:52");
        album.addSong("Yo can't do it right", "4:34");
        album.addSong("The gypsy", "4:33");
        album.addSong("Marselo infinite", "2:40");
        album.addSong("Ay wey", "4:12");
        albumList.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("I put the finger on you", "5:44");
        album.addSong("Renai Circulation", "5:44");
        album.addSong("God knows", "5:44");
        album.addSong("Blue bird", "5:44");
        album.addSong("Hitorigoto", "5:44");
        albumList.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albumList.get(0).addToPlayList("You can't do it right", playList);
        albumList.get(0).addToPlayList("Holy man", playList);
        albumList.get(0).addToPlayList("Yeah asi es", playList); //Does not exist
        albumList.get(0).addToPlayList(8, playList);
        albumList.get(1).addToPlayList(4, playList);
        albumList.get(1).addToPlayList(5, playList);
        albumList.get(1).addToPlayList(6, playList);

        play(playList);
    }

    private static void play(List<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing 5" + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We're at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4- list songs in the playlist\n" +
                "5 - print available actions\n" +
                "6 - delete current song from playlist");
    }

    private static void printList(List<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("==================================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
        System.out.println("==================================");
    }
}
