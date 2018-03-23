package processing;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String price;
    private String name;
    private String briefly;
    private String fully;
    private String pathToImages;
    private String reference;

    public String getId() { return this.id;}

    public String getPathToImages() {
        return pathToImages;
    }

    public String getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public String getBriefly() {
        return this.briefly;
    }

    public String getFully() {
        return this.fully;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Product(String id, String price, String name, String briefly, String fully, String pathToImages, String reference){
        this.id=id;
        this.name=name;
        this.price=price;
        this.briefly=briefly;
        this.fully=fully;
        this.pathToImages=pathToImages;
        this.reference = reference;

    }

}
