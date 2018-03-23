package processing;

import org.apache.log4j.Logger;

import java.io.Serializable;

public class Interface implements Serializable {
    final static Logger logger = Logger.getLogger(Interface.class);
    public Interface(){
        logger.info("Producing InterFace");
    };
    private String login;
    private String cart;
    private String purchases;
    private String filterFrom;
    private String filterTo;
    private String filter;
    private String addToCart;

    public void setAddToCart(String addToCart) {
        this.addToCart = addToCart;
    }

    public String getAddToCart() {
        return addToCart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPurchases(String purchases) {
        this.purchases = purchases;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public void setFilterFrom(String filterFrom) {
        this.filterFrom = filterFrom;
    }

    public void setFilterTo(String filterTo) {
        this.filterTo = filterTo;
    }

    public String getCart() {
        return cart;
    }

    public String getLogin() {
        return login;
    }

    public String getPurchases() {
        return purchases;
    }

    public String getFilter() {
        return filter;
    }

    public String getFilterFrom() {
        return filterFrom;
    }

    public String getFilterTo() {
        return filterTo;
    }
}
