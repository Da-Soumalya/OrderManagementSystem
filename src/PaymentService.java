public class PaymentService{
    public boolean processPayment(double amount){
        System.out.println(
            "Processing payment: " + amount
        );
        
        return true;
    }
}