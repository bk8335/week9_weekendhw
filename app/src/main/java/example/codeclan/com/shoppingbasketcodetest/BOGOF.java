package example.codeclan.com.shoppingbasketcodetest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by user on 06/05/2017.
 */

public class BOGOF implements Discountable {

    private ArrayList<Item> basket;
    private HashMap<String, Double> basketHash = new HashMap<String, Double>();


    public String discount() {
        return "buy one get one free";
    }

    // as a basic v1, if you just add everything to a hashmap, then a 2nd identical title will simply replace the 1st one, making it BOGOF
    // use the .value method to sum up the value of the basket in the hashmap

    public HashMap<String, Double> basketToHash(ArrayList<Item> basket) {
        for (Item item : basket) {
            basketHash.put(item.getTitle(), item.getPrice());
        }
        return basketHash;
    }

    public double basketToHashValue(HashMap<String, Double> basketHash){
        double basketHashValue = 0;
        for(double value : basketHash.values()){
            basketHashValue += value;
        }
        return basketHashValue;
    }

//    public void buyOneGetOneFree(Item itemBeingAdded) {
//        ArrayList<Item> basketClone = new ArrayList<>();
//        for (Item item : basket){
//            if(itemBeingAdded != item) {
//                basketClone.add(itemBeingAdded);
//            }
//            else
//                itemBeingAdded.setPrice(0);
//                basketClone.add(itemBeingAdded);
//        }
//    }


}
