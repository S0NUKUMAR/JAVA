package DesignPatterns.StandardProblems.StrategyPatternDemo;

public class StrategyPatternExample {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Item item1 = new Item("UPC01", 9.25);
        shoppingCart.addToShoppingCart(item1);
        shoppingCart.addToShoppingCart(new Item("UPC02", 15.75));

        shoppingCart.pay(new CreditCardStrategy("Sonu Kumar Singh" , "9876543210", "987" , "28-10-1997"));
        shoppingCart.removeFromShoppingCart(item1);
        shoppingCart.pay(new PaypalStrategy("kumarshanu062@gmail.com", "password"));

    }
}
