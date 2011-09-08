package pkg;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

public class ProductsController {
    private final CheckoutController checkoutController;
    private final Cart cart;
    private final Upsell upsell;

    public ProductsController(CheckoutController checkoutController) {
        this.checkoutController = checkoutController;
        cart = this.checkoutController.getCart();
        upsell = this.checkoutController.getUpsell();
    }

    @RequestMapping("/see/suggested/products")
    public String seeSuggestedProducts(ModelMap model) {
        cart.addTo(upsell.findUpsell(cart));
        cart.addTo(upsell.findUpsell(cart));
        model.addAttribute("cart", cart);
        return "suggestedProducts";
    }
}