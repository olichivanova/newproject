package by.belhard.newproject.service;

import by.belhard.newproject.dto.CategoryDTO;
import by.belhard.newproject.dto.ProductDTO;
import by.belhard.newproject.repository.entity.Category;
import by.belhard.newproject.repository.entity.Product;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {
    public List<ProductDTO> getAllProducts();
    public List<ProductDTO> getAllProductsWithCategories();
    public ProductDTO getProductsByName(String productName);
    public void save(ProductDTO productDTO, CategoryDTO categoryDTO);
    public void save(ProductDTO productDTO, Integer categoryID);
    public void delete(Integer productID);
    public ProductDTO getProductByProductID(Integer productID);
    public ProductDTO getProductWithCategories( Integer categoryID );
    public String getGreeting ();
    public List<ProductDTO> search(String keyword) ;
    public ProductDTO getProductByProductIDAndCategory( Integer productID);
    public List<ProductDTO> getAllProductsByCategoryWithCategory( Integer categoryID);
    public ProductDTO getProductByProductIDWithCategory( Integer productID);
}
