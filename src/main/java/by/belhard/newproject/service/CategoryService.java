package by.belhard.newproject.service;

import by.belhard.newproject.dto.CategoryDTO;
import by.belhard.newproject.dto.ProductDTO;



import java.util.List;


public interface CategoryService {
    public CategoryDTO getCategoryByCategoryID(Integer categoryID);
    public List<CategoryDTO> getAllCategories();
    public List<CategoryDTO> searchCategory( String keyword);
    public void save (CategoryDTO category);
    public void delete (Integer categoryID);
   public void saveEntity (ProductDTO productDTO, CategoryDTO categoryDTO);
    public CategoryDTO getCategoryWithProducts(Integer categoryID);





}
