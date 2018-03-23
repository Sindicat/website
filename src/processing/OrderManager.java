package processing;

import dao.OrderDAO;
//import org.apache.log4j.Logger;
import dao.OrderPurchasesEntity;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.*;

public class OrderManager implements Serializable{
    final static Logger logger = Logger.getLogger(OrderManager.class);
    public void addOrder(String userID,String customer_name, String customer_address, ListOrders list) {
        logger.info("adding customers Order to SQL DB");
        OrderPurchasesEntity orderPurchasesEntity = new OrderPurchasesEntity();
        CustomersHash customers = new CustomersHash();
        String orderID = UUID.randomUUID().toString();
        for (int i = 0; i < list.getList().size(); i++) {
            Date date = new Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(date);
            orderPurchasesEntity.setCustomerIdItem(customers.getMap().get(userID));
            orderPurchasesEntity.setOrderIdItem(orderID);
            orderPurchasesEntity.setOrderAddressItem(customer_address);
            orderPurchasesEntity.setCustomerNameItem(customer_name);
            orderPurchasesEntity.setQuantityItem(Integer.parseInt(list.getOrder(i).getNum()));
            orderPurchasesEntity.setProductIdItem(Integer.parseInt(list.getOrder(i).getId()));
            orderPurchasesEntity.setOrderDateItem(currentTime);
            try {
                logger.info("Sending OrderPurchasesEntity to DAO layer");
                OrderDAO.addData(orderPurchasesEntity);
                logger.info("Order was added to DB!");
            } catch (SQLException e) {
                logger.error("EXEPTION!");
                e.printStackTrace();
            }
        }
    }

    public ListOrders getOrders(String userID){
        CustomersHash customersHash = new CustomersHash();
        int customerID = customersHash.getMap().get(userID);
        logger.info("Gettin all orders from DB");
        List<OrderPurchasesEntity> items = (List<OrderPurchasesEntity>)OrderDAO.getCustomerOrdersByID(customerID);
        logger.info("Gettin all orders from DB -> Success!");
        ListOrders list = new ListOrders();
        for (OrderPurchasesEntity item : items) {
            Order order = new Order();
            order.setId((new Integer(item.getProductIdItem())).toString());
            order.setNum((new Integer(item.getQuantityItem())).toString());
            order.setDate(item.getOrderDateItem());
            list.addOrder(order);
        }
        logger.info("list with  ListOrders ready to return to servlet");
        return list;
    }
}
