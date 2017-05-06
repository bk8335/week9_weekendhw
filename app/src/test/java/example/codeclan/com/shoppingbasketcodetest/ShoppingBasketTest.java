package example.codeclan.com.shoppingbasketcodetest;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 05/05/2017.
 */

public class ShoppingBasketTest {

    Item item;
    ArrayList<Item> basket;

    @Before
    public void before() {
        this.item = new Item("Amazon Kindle", 50);
    }

    @Test
    public void hasTitle() {
        assertEquals("Amazon Kindle", item.getTitle() );
    }

    @Test
    public void getPrice() {
        assertEquals(50, item.getPrice() );
    }

    @Test
    public void addItemtoBasket() {
        basket = new ArrayList<Item>();
        basket.add(new Item("xbox one", 300));
        basket.add(item);
        assertEquals(2, basket.size() );
    }

    @Test
    public void removeItemFromBasket() {
        basket = new ArrayList<Item>();
        basket.add(new Item("xbox one", 300));
        basket.add(item);
        basket.add(new Item("ps4", 300));
        basket.remove(0);
        assertEquals(2, basket.size() );
    }




}
