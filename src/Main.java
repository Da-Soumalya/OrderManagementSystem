import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        InventoryService inventoryService = new InventoryService();
        PaymentService paymentService = new paymentService();
        OrderService orderService = new OrderService(inventoryService, paymentService);
        // Is Main actually the right place to know how the entire application is constructed?
        // No new service were created. But if this trend is followed OrderService constructor
        // will have other dependencies like: TaxRepository, TaxService, PricingRepository, PricingService, EmailClient, NotificationService, PaymentGateway, PaymentService, InventoryService, OrderService

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n===== ORDER MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Order");
            System.out.println("2. List Orders");
            System.out.println("3. Cancel Order");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.print("Customer name: ");
                    String customerName = sc.nextLine();

                    System.out.print("Product name: ");
                    String productName = sc.nextLine();

                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    orderService.createOrder(
                        customerName,
                        productName,
                        quantity
                    );
                    break;
                case 2:
                    orderService.listOrders();
                    break;
                case 3:
                    System.out.print("Order ID: ");
                    int orderId = sc.nextInt();
                    sc.nextLine();

                    orderService.cancelOrder(orderId);
                    break;
                case 4:
                    System.out.println("Exiting OMS...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}