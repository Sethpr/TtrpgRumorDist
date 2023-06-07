import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {
    String name;
    HashMap<String, Integer> rumorMap;
    ArrayList<String> receivedRumors;
    int minValue=0;

    public Player(String name){
        this.name = name;
        rumorMap = new HashMap<>();
        receivedRumors = new ArrayList<>();
    }

    public void addRumor(String rumor){
        rumorMap.put(rumor, 0);
    }


    public void receiveRumor(String name, String rumor) {
        receivedRumors.add(name + ": " + rumor);
    }

    public String sendRumor() {
        for(String key : rumorMap.keySet()){
            if(rumorMap.get(key) == minValue){
                rumorMap.put(key, rumorMap.get(key) + 1);
                checkMin();
                return key;
            }
        }
        return ""+minValue;
    }

    private void checkMin(){
        if(!rumorMap.values().contains(minValue)){
            minValue++;
        }
    }

    public String getMessage() {
        StringBuilder message = new StringBuilder("rumors for " + name + "\n");
        for(String rumor: receivedRumors){
            message.append(rumor).append("\n");
        }
        return message.toString();
    }
}
