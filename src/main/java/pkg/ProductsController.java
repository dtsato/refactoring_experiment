package pkg;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

public class ProductsController {
    private final CheckoutController checkoutController;

    public ProductsController(CheckoutController checkoutController) {
        this.checkoutController = checkoutController;
    }

    @RequestMapping("/see/suggested/products")
    public String seeSuggestedProducts(ModelMap model) {
        checkoutController.getCart().addTo(checkoutController.findUpsell(checkoutController.getCart()));
        checkoutController.getCart().addTo(checkoutController.findUpsell(checkoutController.getCart()));
        model.addAttribute("cart", checkoutController.getCart());
        return "suggestedProducts";
    }
}