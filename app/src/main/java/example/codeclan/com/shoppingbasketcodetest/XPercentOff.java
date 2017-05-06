package example.codeclan.com.shoppingbasketcodetest;

import java.math.BigDecimal;

/**
 * Created by user on 06/05/2017.
 */

public class XPercentOff implements Discountable {

    public String discount() {
        return "spend £x amount, save y percent";
    }

    public double percentageOffDiscount(double basketValue) {
        double savingPercentage = 10;
        double minimumSpendtoQualify = 20;
        if(basketValue > minimumSpendtoQualify){
            double discountedBasketValue = basketValue * (1 - (savingPercentage/100));
            return discountedBasketValue;
        }
        return basketValue;
    }

}
