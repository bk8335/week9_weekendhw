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
    ShoppingBasket basket;

    @Before
    public void before() {
        item = new Item("Amazon Kindle", 50);
        basket = new ShoppingBasket();
        basket.addItemtoBasket(new Item("xbox one", 300));
        basket.addItemtoBasket(item);
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
        assertEquals(2, basket.basketSize() );
    }

    @Test
    public void removeItemFromBasket() {
        basket.addItemtoBasket(new Item("ps4", 300));
        basket.removeItemFromBasket(0);
        assertEquals(2, basket.basketSize() );
    }

    @Test
    public void emptyBasket() {
        basket.addItemtoBasket(new Item("ps4", 300));
        basket.emptyBasket();
        assertEquals(0, basket.basketSize() );
    }




}
