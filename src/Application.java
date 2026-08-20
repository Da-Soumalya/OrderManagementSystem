public class Application{
    public OrderService createOrderService(){
        InventoryService inventoryService = new InventoryService();
        PaymentService paymentService = new PaymentService();

        return new OrderService(inventoryService, paymentService);
    }
}