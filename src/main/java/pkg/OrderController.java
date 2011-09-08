package pkg;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

public class OrderController {
    private final CheckoutController checkoutController;

    public OrderController(CheckoutController checkoutController) {
        this.checkoutController = checkoutController;
    }

    @RequestMapping("/place/order")
    public String placeOrder(ModelMap model) {
        checkoutController.getOrder().place(checkoutController.getCart());
        model.addAttribute("order", checkoutController.getOrder());
        return "orderPlaced";
    }
}