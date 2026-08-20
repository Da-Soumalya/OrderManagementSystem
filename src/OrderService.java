import java.util.ArrayList;
import java.util.List;

public class OrderService{
    private final List<Order> orders = new ArrayList<>();
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private int nextId = 1;

    // Question: Why am I spending my application entry point assembling an object graph?
    public OrderService(){
        this.inventoryService = new InventoryService();
        this.paymentService = new PaymentService();
    }

    public void createOrder(String customerName, String productName, int quantity){
        if(!inventoryService.isAvailable(productName, quantity)){
            System.out.println("Insufficient inventory.");
            return;
        }

        if(!paymentService.processPayment(1000)){
            System.out.println("Payment failed.");
            return;
        }
        
        Order order = new Order(
            nextId++,
            customerName,
            productName,
            quantity
        );

        orders.add(order);

        System.out.println("Order created successfully!");
        System.out.println(order);
    }

    public void listOrders(){
        if (orders.isEmpty()){
            System.out.println("No orders found.");
            return;
        }

        for (Order order : orders){
            System.out.println(order);
        }
    }

    public void cancelOrder(int orderId){
        for (Order order : orders){ // fetching the order iteratively rather than O(1)
            if(order.getId() == orderId){
                if(order.isCancelled()){
                    System.out.println("Order is already cancelled.");
                }
                else{
                    order.cancel();
                    System.out.println("Order cancelled successfully.");
                }
                return;
            }
        }
        System.out.println("Order not found.");
    }
}