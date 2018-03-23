package dao;

import javax.persistence.*;

@Entity
@Table(name = "purchases", schema = "db", catalog = "")
public class OrderPurchasesEntity {
    private int idItem;
    private String orderIdItem;
    private Integer productIdItem;
    private Integer customerIdItem;
    private Integer quantityItem;
    private String orderAddressItem;
    private String orderDateItem;
    private String customerNameItem;

    @Id
    @Column(name = "idItem")
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    @Basic
    @Column(name = "order_idItem")
    public String getOrderIdItem() {
        return orderIdItem;
    }

    public void setOrderIdItem(String orderIdItem) {
        this.orderIdItem = orderIdItem;
    }

    @Basic
    @Column(name = "product_idItem")
    public Integer getProductIdItem() {
        return productIdItem;
    }

    public void setProductIdItem(Integer productIdItem) {
        this.productIdItem = productIdItem;
    }

    @Basic
    @Column(name = "customer_idItem")
    public Integer getCustomerIdItem() {
        return customerIdItem;
    }

    public void setCustomerIdItem(Integer customerIdItem) {
        this.customerIdItem = customerIdItem;
    }

    @Basic
    @Column(name = "quantityItem")
    public Integer getQuantityItem() {
        return quantityItem;
    }

    public void setQuantityItem(Integer quantityItem) {
        this.quantityItem = quantityItem;
    }

    @Basic
    @Column(name = "order_addressItem")
    public String getOrderAddressItem() {
        return orderAddressItem;
    }

    public void setOrderAddressItem(String orderAddressItem) {
        this.orderAddressItem = orderAddressItem;
    }

    @Basic
    @Column(name = "order_dateItem")
    public String getOrderDateItem() {
        return orderDateItem;
    }

    public void setOrderDateItem(String orderDateItem) {
        this.orderDateItem = orderDateItem;
    }

    @Basic
    @Column(name = "customer_nameItem")
    public String getCustomerNameItem() {
        return customerNameItem;
    }

    public void setCustomerNameItem(String customerNameItem) {
        this.customerNameItem = customerNameItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderPurchasesEntity that = (OrderPurchasesEntity) o;

        if (idItem != that.idItem) return false;
        if (orderIdItem != null ? !orderIdItem.equals(that.orderIdItem) : that.orderIdItem != null) return false;
        if (productIdItem != null ? !productIdItem.equals(that.productIdItem) : that.productIdItem != null)
            return false;
        if (customerIdItem != null ? !customerIdItem.equals(that.customerIdItem) : that.customerIdItem != null)
            return false;
        if (quantityItem != null ? !quantityItem.equals(that.quantityItem) : that.quantityItem != null) return false;
        if (orderAddressItem != null ? !orderAddressItem.equals(that.orderAddressItem) : that.orderAddressItem != null)
            return false;
        if (orderDateItem != null ? !orderDateItem.equals(that.orderDateItem) : that.orderDateItem != null)
            return false;
        if (customerNameItem != null ? !customerNameItem.equals(that.customerNameItem) : that.customerNameItem != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idItem;
        result = 31 * result + (orderIdItem != null ? orderIdItem.hashCode() : 0);
        result = 31 * result + (productIdItem != null ? productIdItem.hashCode() : 0);
        result = 31 * result + (customerIdItem != null ? customerIdItem.hashCode() : 0);
        result = 31 * result + (quantityItem != null ? quantityItem.hashCode() : 0);
        result = 31 * result + (orderAddressItem != null ? orderAddressItem.hashCode() : 0);
        result = 31 * result + (orderDateItem != null ? orderDateItem.hashCode() : 0);
        result = 31 * result + (customerNameItem != null ? customerNameItem.hashCode() : 0);
        return result;
    }
}
