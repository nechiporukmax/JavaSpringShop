package org.example.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String Id;
    private String Name;
    private String Description;
    private double Price;
    private String Status;
    private String Manufacture;
    private double Discount;
    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    private Category Category;

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double discount) {
        Discount = discount;
    }

    public Boolean getWishList() {
        return WishList;
    }

    public void setWishList(Boolean wishList) {
        WishList = wishList;
    }

    private Boolean WishList=false;
    @Transient
    private MultipartFile Image;

    public void setImage(MultipartFile image) {
        Image = image;
    }

    public MultipartFile getImage() {
        return Image;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCategory(Category category) {
        Category = category;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setStatus(String Status) {
        Status = Status;
    }

    public void setManufacture(String manufacture) {
        Manufacture = manufacture;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public Category getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }

    public double getPrice() {
        return Price;
    }

    public String getStatus() {
        return Status;
    }

    public String getManufacture() {
        return Manufacture;
    }
}
