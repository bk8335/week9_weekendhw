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


//    means you can only add two of each item, and to make it work, rename title for a 3rd/4th/5th one etc.
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

//    for a proper BOGOF, need a hashmap with the count of each unique key.
//    With the value of each key starting at 1, and then going up each time it reappears
//    divide the number by two, multiply that by the price to get the value.
//    if number / 2 remainder 1 i.e. odd, then add one of the price to the value above.


}
