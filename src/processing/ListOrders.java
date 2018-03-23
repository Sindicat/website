package processing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;

public class ListOrders implements Serializable {
    final static Logger logger = Logger.getLogger(ListOrders.class.getName());
    public ListOrders(){
        list = new ArrayList<Order>();
    }
    private ArrayList<Order> list;
    public boolean isEmpty()
    {
        for (Order order: list) {
            if(!order.getNum().equals("0"))
            {
                return false;
            }
        }
        return true;
    }
    public void addOrder(Order order){
        logger.info("Adding order to ListOrders");
        this.list.add(order);
    }

    public Order getOrder(int pos)
    {
        logger.info("Getting order from ListOrders with ID:" + list.get(pos).getId());
        return list.get(pos);
    }

    public ArrayList<Order> getList()
    {
        return this.list;
    }

    public void setList(ArrayList<Order> list) {
        this.list = list;
    }
}
