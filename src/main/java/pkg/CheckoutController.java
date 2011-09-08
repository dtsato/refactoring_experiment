package pkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckoutController {

    private final Cart cart;
    private final Upsell upsell;

    @Autowired
    public CheckoutController(Cart cart, Upsell upsell) {
        this.cart = cart;
        this.upsell = upsell;
    }

    @RequestMapping("/go/to/checkout/")
    public String goCheckout(ModelMap model) {
        // other stuff
        cart.addTo(upsell.findUpsell(cart));
        model.addAttribute("cart", cart);
        return "checkout";
    }

    String findUpsell(Cart cart) {
        return upsell.findUpsell(cart);
    }


}
