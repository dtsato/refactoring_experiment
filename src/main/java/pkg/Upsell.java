package pkg;

public class Upsell {
    public Upsell() {
    }

    String findUpsell(Cart cart) {
        if (cart.size() == 0) {
            return "iPad";
        } else {
            return "iPod Nano";
        }
    }
}