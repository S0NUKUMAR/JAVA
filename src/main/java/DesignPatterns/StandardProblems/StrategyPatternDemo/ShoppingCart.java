package DesignPatterns.StandardProblems.StrategyPatternDemo;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public List<Item> shoppingCart;

    public ShoppingCart(){
        shoppingCart = new ArrayList<>();
    }

    public void addToShoppingCart(Item item){
        shoppingCart.add(item);
    }

    public void removeFromShoppingCart(Item item){
        shoppingCart.remove(item);
    }

    public double getTotalPrice(){
        return shoppingCart.stream().mapToDouble(Item::getPrice).sum();
    }

    public void pay(PaymentStrategy paymentStrategy){
        paymentStrategy.pay((int) getTotalPrice());
    }

}
