package com.demo;

import java.util.*;

public class IterableSolution {

    public static List<Player> readData(){
        Player player1 = new Player("Lebron", 23);
        Player player2 = new Player("Kyrie", 11);

        /* -- Create an immutable (unchangeable) list (UnsupportedOperationException)
              Once created, you cannot add, remove, or modify elements in this list.
              Benefits (memory-efficient) -- */
//        List<Player> playerList = List.of(player2, player2);

        /* -- allows dynamic resizing and modification of its contents -- */
        // List<Player> playerList2 = new ArrayList<>();
        // playerList2.add(player1);
        // playerList2.add(player2);

        Collection<Player> collectionPlayer = List.of(player2, player2);
        Iterable<Player> iterablePlayer = collectionPlayer;
        Iterator<Player> iteratorPlayer = iterablePlayer.iterator();

        while(iteratorPlayer.hasNext()){
            Player pElement = iteratorPlayer.next();
            System.out.print("pElement: ");
            System.out.println(pElement);
        }

        iterablePlayer.forEach( (p) -> {
            System.out.print("p: ");
            System.out.println(p);
        });

        // Spliterator<Player> playerSpliterator = iterablePlayer.spliterator();

        return null;
    }

}


class Player{
    private String pname;
    private int pnum;

    Player(String pname, int pnum){
        this.pname = pname;
        this.pnum = pnum;
    }

    @Override
    public String toString() {
        return "Player{" +
                "pname='" + pname + '\'' +
                ", pnum=" + pnum +
                '}';
    }

}
