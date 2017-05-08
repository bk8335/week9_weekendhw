package example.codeclan.com.shoppingbasketcodetest;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 05/05/2017.
 */

public class ShoppingBasketTest {

    Item item;
    ShoppingBasket basket;
    XPercentOff tenPercentOff;
    LoyaltyCard loyaltyCard;
    BOGOF bOGOF;


    @Before
    public void before() {
        item = new Item("kindle", 50);
        basket = new ShoppingBasket();
        basket.addItemtoBasket(new Item("xbox one", 300));
        basket.addItemtoBasket(item);
        tenPercentOff = new XPercentOff();
        loyaltyCard = new LoyaltyCard();
        bOGOF = new BOGOF();
    }

    @Test
    public void hasTitle() {
        assertEquals("kindle", item.getTitle() );
    }

    @Test
    public void getPrice() {
        assertEquals(50, item.getPrice(), 0.01 );
    }

    @Test
    public void addItemtoBasket() {
        assertEquals(2, basket.basketSize() );
    }

    @Test
    public void removeItemFromBasket() {
        basket.addItemtoBasket(new Item("ps4", 400));
        basket.removeItemFromBasket(0);
        assertEquals(2, basket.basketSize() );
    }

    @Test
    public void emptyBasket() {
        basket.addItemtoBasket(new Item("ps4", 400));
        assertEquals(3, basket.basketSize() );

        basket.emptyBasket();
        assertEquals(0, basket.basketSize() );
    }

    @Test
    public void valueofShoppingbasketis350() {
        double cost = basket.basketValue();
        assertEquals(350, cost, 0.01 );
    }

    @Test
    public void findItemInBasketbyTitle() {
        basket.addItemtoBasket(new Item("ps4", 400));
        Item searched = basket.findItemInBasket("kindle");
        assertEquals("kindle", searched.getTitle());
    }

//    @Test
//    public void removeItembyTitle() {
//        basket.removeItemFromBasketByTitle("kindle");
//        assertEquals(1, basket.basketSize());
//    }
//
////    creates null pointer exception, which is what we want (as can only return an item type - better way out there?)
//    @Test
//    public void findItemDoesNotExist() {
//        Item searched = basket.findItemInBasket("bla bla bla");
//        assertEquals(null, searched.getTitle());
//    }

    @Test
    public void findItemReturnPrice() {
        Item searched = basket.findItemInBasket("xbox one");
        assertEquals(300, searched.getPrice(), 0.01);
    }

    @Test
    public void saveTenPercent() {
        double undiscounted = basket.basketValue();
        assertEquals(350, undiscounted, 0.01);

        double discountedBasket = tenPercentOff.percentageOffDiscount(undiscounted);

        assertEquals(315, discountedBasket, 0.01);
    }

    @Test
    public void loyaltyCardSaveTwoPercent() {
        double undiscounted = basket.basketValue();
        double discountedBasket = loyaltyCard.loyaltyCardDiscount(undiscounted, true);
        assertEquals(343, discountedBasket, 0.01 );
    }

    @Test
    public void saveTenPercentandTwoPercentLoaylty() {
        double undiscounted = basket.basketValue();
        double discountedBasket1 = tenPercentOff.percentageOffDiscount(undiscounted);
        double discountedBasket2 = loyaltyCard.loyaltyCardDiscount(discountedBasket1, true);
        assertEquals(308.7, discountedBasket2, 0.01);
    }


    @Test
    public void convertBasketToHash() {
        HashMap result = bOGOF.basketToHash(basket.getBasket());
        assertEquals(2, result.size());
    }

    @Test
    public void cannotAddTwoOfSameItemToHash() {
        basket.addItemtoBasket(new Item("kindle", 50));
        basket.addItemtoBasket(new Item("batman", 500));
        HashMap result = bOGOF.basketToHash(basket.getBasket());
        assertEquals(3, result.size());
    }

    @Test
    public void basketToHashValue() {
        HashMap input = bOGOF.basketToHash(basket.getBasket());
        assertEquals(350, bOGOF.basketToHashValue(input), 0.01);
    }

    @Test
    public void basketToHashValueWithTwoOfSameItem() {
        basket.addItemtoBasket(new Item("kindle", 50));
        HashMap startingBasket = bOGOF.basketToHash(basket.getBasket());
        double hashValue = bOGOF.basketToHashValue(startingBasket);
        assertEquals(350, hashValue, 0.01);
    }

    @Test
    public void applyAllDiscountsAtOnce() {
        basket.addItemtoBasket(new Item("kindle", 50));
        basket.addItemtoBasket(new Item("kindle2", 50));
        basket.addItemtoBasket(new Item("kindle2", 50));
        HashMap startingBasket = bOGOF.basketToHash(basket.getBasket());
        double hashValue = bOGOF.basketToHashValue(startingBasket);
        double discountedBasket1 = tenPercentOff.percentageOffDiscount(hashValue);
        double discountedBasket2 = loyaltyCard.loyaltyCardDiscount(discountedBasket1, true);
        assertEquals(352.8, discountedBasket2, 0.01);
    }

}
