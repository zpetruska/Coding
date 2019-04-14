import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        if(a.score > b.score) {
            return -1;
        } else if(a.score < b.score) {
            return 1;
        } else {
            if (a.name.compareTo(b.name) > 0) {
                return 1;
            } else if(a.name.compareTo(b.name) < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

