package by.belhard.newproject.service;

import by.belhard.newproject.dto.CategoryDTO;
import by.belhard.newproject.dto.ProductDTO;
import by.belhard.newproject.repository.entity.Category;
import by.belhard.newproject.repository.entity.Product;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface CategoryService {
    public CategoryDTO getCategoryByCategoryID(Integer categoryID);
    public List<CategoryDTO> getAllCategories();
    public List<CategoryDTO> searchCategory( String keyword);
    public void save (CategoryDTO category);
    public void delete (Integer categoryID);
   public void saveEntity (Category category);





}
