package processing;

import org.apache.log4j.Logger;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DataBase implements Serializable {
    final static Logger logger = Logger.getLogger(DataBase.class);
    public DataBase() {
    }

    private ArrayList<Product> productsList;

    public ArrayList<Product> getProductsList() {
        return this.productsList;
    };
    public void addProduct(Product product){
        logger.info("Add product to DB: "+product.getName());
        productsList.add(product);
    }

    public void setProductsList(ArrayList<Product> newlist){
        this.productsList= newlist;
    }

}