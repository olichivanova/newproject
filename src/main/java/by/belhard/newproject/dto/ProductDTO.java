package by.belhard.newproject.dto;

import by.belhard.newproject.repository.entity.Category;


public class ProductDTO {
    private Integer productID;
    private String productName;
    private Integer categoryID;
    private String unit;
    private float price;
    private float inStock;
    private CategoryDTO category;

    public ProductDTO() {
    }

    public ProductDTO(Integer productID, String productName, Integer categoryID, String unit, float price, float inStock) {
        this.productID = productID;
        this.productName = productName;
        this.categoryID = categoryID;
        this.unit = unit;
        this.price = price;
        this.inStock = inStock;
    }

    public ProductDTO(Integer productID, String productName, Integer categoryID, String unit, float price, float inStock, CategoryDTO category) {
        this.productID = productID;
        this.productName = productName;
        this.categoryID = categoryID;
        this.unit = unit;
        this.price = price;
        this.inStock = inStock;
        this.category = category;
    }

    public ProductDTO(Integer productID, String productName, String unit, float price, float inStock, CategoryDTO category) {
        this.productID = productID;
        this.productName = productName;
        this.unit = unit;
        this.price = price;
        this.inStock = inStock;
        this.category = category;
    }

    public ProductDTO(Integer productID, String soap, String kg, float v, float v1) {
        this.productID = productID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getInStock() {
        return inStock;
    }

    public void setInStock(float inStock) {
        this.inStock = inStock;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", categoryID=" + categoryID +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", inStock=" + inStock +
                ", category=" + category +
                '}';
    }
}
