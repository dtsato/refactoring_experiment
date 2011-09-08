package pkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckoutController {

    private final Cart cart;

    @Autowired
    public CheckoutController(Cart cart) {
        this.cart = cart;
    }

    @RequestMapping("/go/to/checkout/")
    public String goCheckout(ModelMap model) {
        // other stuff
        cart.addTo(findUpsell(cart));
        model.addAttribute("cart", cart);
        return "checkout";
    }

    @RequestMapping("/see/suggested/products")
    public String seeSuggestedProducts(ModelMap model) {
        return new ProductsController(this, cart).seeSuggestedProducts(model);
    }

    String findUpsell(Cart cart) {
        if (cart.size() == 0) {
            return "iPad";
        } else {
            return "iPod Nano";
        }
    }


    public Cart getCart() {
        return cart;
    }
}
