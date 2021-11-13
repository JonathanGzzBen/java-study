package com.company;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeagueTable<T extends Sport> {
    List<Team<T>> teamList;

    public LeagueTable() {
        teamList = new LinkedList<>();
    }

    public void printTeams() {
        Collections.sort(teamList);
        Collections.reverse(teamList);
        for (Team<T> team:
             teamList) {
            System.out.println(team.toString());
        }
    }

    public boolean addTeam(Team<T> team) {
        if (teamList.contains(team)) {
            System.out.println("Team is already in the league table");
            return false;
        }
        teamList.add(team);
        return true;
    }
}
