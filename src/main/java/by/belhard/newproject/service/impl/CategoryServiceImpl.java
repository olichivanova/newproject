package by.belhard.newproject.service.impl;

import by.belhard.newproject.dto.CategoryDTO;
import by.belhard.newproject.dto.ProductDTO;
import by.belhard.newproject.repository.CategoryRepository;
import by.belhard.newproject.repository.entity.Category;
import by.belhard.newproject.repository.entity.Product;
import by.belhard.newproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
   public CategoryServiceImpl(CategoryRepository categoryRepository) { this.categoryRepository = categoryRepository;}

    @Override
    public CategoryDTO getCategoryByCategoryID(Integer categoryID) {
        return convertFromEntityToDTO(categoryRepository.getCategoryByCategoryID(categoryID));
    }



    @Override
    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> categoryDTOList = convertFromListEntityToListDTO(categoryRepository.getAllCategories());
        return categoryDTOList;
    }

   @Override
    public void saveEntity(Category category) {
        saveEntity(category);
   }



    private List<CategoryDTO> convertFromListEntityToListDTO(List<Category> categoryList){
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category x: categoryList){
           categoryDTOList.add(convertFromEntityToDTO(x) ) ;

        }
        return categoryDTOList;
    }

    @Override
    public List<CategoryDTO> searchCategory(String keyword) {
        List<CategoryDTO> categoryDTOList = convertFromListEntityToListDTO(categoryRepository.searchCategory(keyword));
        return categoryDTOList;
    }

    @Override
    @Transactional
    public void save(CategoryDTO category) {

            Category category1 = convertFromDTOToEntity(category);

            categoryRepository.save(category1); }





    @Override
    @Transactional
    public void delete(Integer categoryID) {
        categoryRepository.deleteById(categoryID);
    }

    private CategoryDTO convertFromEntityToDTO (Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryID(category.getCategoryID());
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setDescription(category.getDescription());
        return categoryDTO;}

       /*private List<CategoryDTO> convertFromListEntityToListDTOWithProducts(List<Category> categories){
            List<CategoryDTO> categoryDTOList = new ArrayList<>();
            for (Category x: categories){
                categoryDTOList.add( convertFromListEntityToListDTOWithProducts(x));
            }
            return categoryDTOList;}*/

     /*  private CategoryDTO convertFromEntityToDTOWithProducts (Category category){
            CategoryDTO categoryDTO1 = new CategoryDTO();
            categoryDTO1.setCategoryID(category.getCategoryID());
            categoryDTO1.setCategoryName(category.getCategoryName());
            categoryDTO1.setDescription(category.getDescription());
            List<ProductDTO> productDTOList = new ArrayList<>();
            for (Product x: category.getProducts()) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setProductName(x.getProductName());
                productDTO.setCategoryID(x.getCategoryID());
                productDTO.setUnit(x.getUnit());
                productDTO.setPrice(x.getPrice());
                productDTO.setInStock(x.getInStock());
                productDTOList.add(productDTO);
            }
           categoryDTO1.setProductDTOList(productDTOList);



            return categoryDTO1;}*/

   public Category convertFromDTOToEntity (CategoryDTO categoryDTO){
        Category category1 = new Category();
        if(categoryDTO.getCategoryID() != null){
            category1.setCategoryID(categoryDTO.getCategoryID());
        }
        category1.setCategoryName(categoryDTO.getCategoryName());
        category1.setDescription(categoryDTO.getDescription());
        return category1;
    }

    public Category convertFromDTOToEntityWithProducts (CategoryDTO categoryDTO, ProductDTO productDTO){
        Category category1 = new Category();
        if(categoryDTO.getCategoryID() != null){
            category1.setCategoryID(categoryDTO.getCategoryID());
        }
        category1.setCategoryName(categoryDTO.getCategoryName());
        category1.setDescription(categoryDTO.getDescription());
        List<ProductDTO> productDTOList = new ArrayList<>();
        productDTOList.add(productDTO);
        List<Product> products= new ArrayList<>();
        for(ProductDTO x: productDTOList){
            Product product = new Product();
            product.setProductID(x.getProductID());
            product.setProductName(x.getProductName());
          //  product.setCategoryID(category1.getCategoryID());
            product.setPrice(x.getPrice());
            product.setUnit(x.getUnit());
            product.setInStock(x.getInStock());
            products.add(product);
        }
        category1.setProducts(products);
        return category1;
    }
}
