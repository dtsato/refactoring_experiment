package pkg;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

public class ProductsController {
    private final CheckoutController checkoutController;
    private final Cart cart;

    public ProductsController(CheckoutController checkoutController, Cart cart) {
        this.checkoutController = checkoutController;
        this.cart = cart;
    }

    @RequestMapping("/see/suggested/products")
    public String seeSuggestedProducts(ModelMap model) {
        cart.addTo(checkoutController.findUpsell(cart));
        cart.addTo(checkoutController.findUpsell(cart));
        model.addAttribute("cart", cart);
        return "suggestedProducts";
    }
}