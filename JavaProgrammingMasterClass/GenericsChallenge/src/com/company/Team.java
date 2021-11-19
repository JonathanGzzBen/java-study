package com.company;

public class Team<T extends Sport> implements Comparable<Team<T>> {
    String name;
    int points;

    public Team(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public int compareTo(Team<T> o) {
        return Integer.compare(this.points, o.getPoints());
    }

    @Override
    public String toString() {
        return this.name + " - " + this.points + "pts";
    }
}
