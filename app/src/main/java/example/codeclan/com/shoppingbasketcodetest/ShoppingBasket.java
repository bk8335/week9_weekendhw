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
        basket = new ArrayList<Item>();
    }

    public ArrayList<Item> getBasket() {
        return new ArrayList<Item>(basket);
    }






}
