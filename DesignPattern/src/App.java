public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.out.println(OrderStatus.DELIVERED);
        OrderStatus status = OrderStatus.PAID;
        System.out.println(status);

    }
}

enum OrderStatus{
    CREATED,
    PAID,
    DELIVERING,
    DELIVERED,
    CANCELLED
}
