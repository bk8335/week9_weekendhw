package example.codeclan.com.shoppingbasketcodetest;

/**
 * Created by user on 05/05/2017.
 */

public class Item {

    private String title;
    private int price;

    public Item(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public String setTitle(String newTitle) {
        this.title = newTitle;
        return this.title;
    }

    public int getPrice() {
        return this.price;
    }

}
