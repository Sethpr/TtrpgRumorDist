import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input = "";
        ArrayList<Player> players = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("how many rumors per player:");
        int rumorNum = in.nextInt();
        while(true){
            System.out.println("Please enter a player or type 'done' if they are all in:");
            input = in.next().toLowerCase().trim();
            if(input.equals("done")){
                break;
            }
            players.add(new Player(input));
        }
        if(players.size() == 0){
            System.out.println("No players");
            throw new RuntimeException();
        }
        for(Player player: players){
            for (int i = 0; i < rumorNum; i++) {
                System.out.println("Please enter rumor #" + (i+1));
            }
        }
    }
}