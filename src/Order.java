public class Order{
    private int id;
    private String customerName;
    private String productName;
    private int quantity;
    private boolean cancelled;

    public Order(int id, String customerName, String productName, int quantity){
        this.id = id;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.cancelled = false;
    }

    public int getId(){
        return id;
    }

    public String getCustomerName(){
        return customerName;
    }

    public String getProductName(){
        return productName;
    }

    public int getQuantity(){
        return quantity;
    }

    public boolean isCancelled(){
        return cancelled;
    }

    public void cancel(){ // only setter among the getters
        this.cancelled = true;
    }

    @Override
    public String toString(){
        return "Order #" + id + 
               " | Customer: " + customerName +
               " | Product: " + productName + 
               " | Quantity: " + quantity + 
               " | Status: " + (cancelled ? "CANCELLED":"ACTIVE");
    }
}