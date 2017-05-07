package example.codeclan.com.shoppingbasketcodetest;

/**
 * Created by user on 05/05/2017.
 */

public class Item {

    private String title;
    private double price;

    public Item(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public double setPrice(double newPrice) {
        this.price = newPrice;
        return this.price;
    }

    public String setTitle(String newTitle) {
        this.title = newTitle;
        return this.title;
    }

    public double getPrice() {
        return this.price;
    }

}
