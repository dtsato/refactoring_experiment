package pkg;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

public class OrderController {
    private final CheckoutController checkoutController;
    private final Order order;
    private final Cart cart;

    public OrderController(CheckoutController checkoutController, Order order, Cart cart) {
        this.checkoutController = checkoutController;
        this.order = order;
        this.cart = cart;
    }

    @RequestMapping("/place/order")
    public String placeOrder(ModelMap model) {
        order.place(cart);
        model.addAttribute("order", order);
        return "orderPlaced";
    }
}