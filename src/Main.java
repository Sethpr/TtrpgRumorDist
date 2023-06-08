import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        String input = "";
        ArrayList<Player> players = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("How many rumors per player:");
        int rumorNum = in.nextInt();
        System.out.println("How many rumors will each other player receive:");
        int receiveNum = in.nextInt();
        in.nextLine();
        while(true){
            System.out.println("Please enter a player or type 'done' if they are all in:");
            input = in.nextLine().toLowerCase().trim();
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
                System.out.println("Please enter rumor #" + (i+1) + " for " + player.name);
                player.addRumor(in.nextLine());
            }
        }
        for(Player player: players){    //on one hand this is inefficient, on the other hand if I ever run for more than
            for(Player other: players){ //six players and I'll never do more than five rumors so...
                if(player.equals(other)){
                    continue;
                }
                for (int i = 0; i < receiveNum; i++) {
                    player.receiveRumor(other.name, other.sendRumor());
                }
            }
            System.out.println(player.getMessage());
        }
    }
}