package pkg;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

public class OrderController {
    private final CheckoutController checkoutController;
    private final Order order;

    public OrderController(CheckoutController checkoutController, Order order) {
        this.checkoutController = checkoutController;
        this.order = order;
    }

    @RequestMapping("/place/order")
    public String placeOrder(ModelMap model) {
        order.place(checkoutController.getCart());
        model.addAttribute("order", order);
        return "orderPlaced";
    }
}