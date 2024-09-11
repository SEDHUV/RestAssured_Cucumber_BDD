package EcommerceE2E;

import java.util.List;

public class orders {


    public List<orderDetail> getOrders() {
        return orders;
    }

    public void setOrderdetails(List<orderDetail> orders) {
        this.orders = orders;
    }

    private List<orderDetail> orders;
}
