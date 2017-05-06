package example.codeclan.com.shoppingbasketcodetest;

/**
 * Created by user on 06/05/2017.
 */

public class LoyaltyCard implements Discountable {

    public String discount() {
        return "if customer checking out has the loyalty card they save x%";
    }

    public double loyaltyCardDiscount(double basketValue, boolean value) {
        double savingPercentage = 2;
        if(value == true){
            double discountedBasketValue = basketValue * (1 - (savingPercentage/100));
            return discountedBasketValue;
        }

        return basketValue;
    }
}
