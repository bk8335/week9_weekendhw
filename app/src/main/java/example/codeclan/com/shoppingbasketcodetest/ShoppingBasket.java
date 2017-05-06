package example.codeclan.com.shoppingbasketcodetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ShoppingBasket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private ArrayList<Item> basket;

    public ShoppingBasket() {
        this.basket = new ArrayList<Item>();
    }

    public ArrayList<Item> getBasket() {
        return new ArrayList<Item>(basket);
    }

    public void addItemtoBasket(Item item) {
        basket.add(item);
    }

    public void removeItemFromBasket(int arrayPosition){
        basket.remove(arrayPosition);
    }

    public int basketSize() {
        return basket.size();
    }

    public void emptyBasket() {
        basket.clear();
    }






}
