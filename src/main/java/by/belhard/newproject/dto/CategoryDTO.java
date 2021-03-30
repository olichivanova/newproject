package by.belhard.newproject.dto;


import by.belhard.newproject.repository.entity.Product;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {

    private Integer categoryID;
    private String categoryName;
    private String description;

    public CategoryDTO(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public CategoryDTO() {
    }

    public CategoryDTO(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public CategoryDTO(Integer categoryID, String categoryName, String description) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.description = description;
    }


    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "categoryID=" + categoryID +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
