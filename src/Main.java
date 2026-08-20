import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        OrderService orderService = new OrderService();
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