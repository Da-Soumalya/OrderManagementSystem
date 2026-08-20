public class InventoryService{
    public boolean isAvailable(String productName, int quantity){
        System.out.println(
            "Checking inventory for " + 
            quantity + " X " + productName
        );
        return true;
    }
}