package by.belhard.newproject.service.impl;

import by.belhard.newproject.dto.CategoryDTO;
import by.belhard.newproject.dto.ProductDTO;
import by.belhard.newproject.repository.ProductRepository;
import by.belhard.newproject.repository.entity.Category;
import by.belhard.newproject.repository.entity.Product;
import by.belhard.newproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;



    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }





    @Override
    public List<ProductDTO> getAllProducts() {
        return convertFromListEntityToListDTO(productRepository.getAllProducts());
    }

    @Override
    public List<ProductDTO> getAllProductsWithCategories() {
        return convertFromListEntityToListDTOWithCategories(productRepository.getAllProductsWithCategories());
    }

    @Override
    public ProductDTO getProductsByName(String productName) {
        return convertFromEntityToDTO(productRepository.getProductsByName( productName));
    }

    @Override
    @Transactional

    public void save(ProductDTO productDTO, CategoryDTO categoryDTO) {
        Product product = convertFromDTOToEntityWithCategory(productDTO, categoryDTO);
        productRepository.save(product);
    }

  /*  @Override
    public ProductDTO getProductByCategoryID(Integer categoryID) {
        return convertFromEntityToDTOWithCategories(productRepository.getProductByCategoryID(categoryID));
    }*/

    @Override
    public ProductDTO getProductByProductID(Integer productID) {
        return convertFromEntityToDTO(productRepository.getProductByProductID(productID));
    }


  @Override
    public ProductDTO getProductWithCategories(Integer categoryID) {
        return convertFromEntityToDTO(productRepository.getProductByProductID(categoryID));
    }

    @Override
    @Transactional
    public void delete(Integer productID) {
        productRepository.deleteByProductID(productID);

    }

    @Override
    public List<ProductDTO> search(String keyword) {
        return  convertFromListEntityToListDTO(productRepository.search(keyword));
    }

    @Override
    public String getGreeting() {
        return "Hello, my dear client. Let me show you our products.";
    }

    @Override
    public ProductDTO getProductByProductIDAndCategory(Integer productID) {
        if (productRepository.getProductByProductIDWithCategory(productID) == null);
        System.out.println("no such products");
        return convertFromEntityToDTOWithCategories(productRepository.getProductByProductIDWithCategory(productID));
    }

    @Override
    public ProductDTO getProductByProductIDWithCategory(Integer productID) {
        return convertFromEntityToDTOWithCategories(productRepository.getProductByProductIDWithCategory(productID));
    }

    @Override
    public List<ProductDTO> getAllProductsByCategoryWithCategory(Integer categoryID) {
        List<ProductDTO> productDTOList = convertFromListEntityToListDTO(productRepository.getAllProductsByCategoryWithCategory( categoryID));
        return productDTOList;
    }

    @Override
    @Transactional
    public void save(ProductDTO productDTO, Integer categoryID) {
        Product product = convertFromDTOToEntity(productDTO, categoryID);
        productRepository.save(product);
    }
    /*  @Override
    public ProductDTO getProductWithCategories(Integer categoryID) {
        ProductDTO productDTO = convertFromEntityToDTOWithCategories(productRepository.getProductWithCategories(categoryID));
        return null;
    }*/

    /*  @Override
    public ProductDTO getProductByProductIDWithCategory(Integer productID) {
        if (productRepository.getProductByProductIDWithCategory(productID) == null);
        System.out.println("no such products");
        return convertFromEntityToDTOWithCategories(productRepository.getProductByProductIDWithCategory(productID));
    }*/

    private List<ProductDTO> convertFromListEntityToListDTOWithCategories(List<Product> products){
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product: products){
            productDTOList.add(convertFromEntityToDTOWithCategories(product));
        }
        return productDTOList;
    }
    private ProductDTO convertFromEntityToDTOWithCategories(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductID(product.getProductID());
        productDTO.setProductName(product.getProductName());
       // productDTO.setCategoryID(product.getCategoryID());
        productDTO.setUnit(product.getUnit());
        productDTO.setPrice(product.getPrice());
        productDTO.setInStock(product.getInStock());
        productDTO.setCategory(new CategoryDTO(product.getCategory().getCategoryID(), product.getCategory().getCategoryName(), product.getCategory().getDescription()));
        return productDTO;
    }
    private List<ProductDTO> convertFromListEntityToListDTO(List<Product> products){
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product: products){
            productDTOList.add(convertFromEntityToDTO(product));
        }
        return productDTOList;}
    private ProductDTO convertFromEntityToDTO(Product product){
        ProductDTO productDTO1 = new ProductDTO();
        productDTO1.setProductID(product.getProductID());
        productDTO1.setProductName(product.getProductName());
       // productDTO1.setCategoryID(product.getCategoryID());
        productDTO1.setUnit(product.getUnit());
        productDTO1.setPrice(product.getPrice());
        productDTO1.setInStock(product.getInStock());
       // productDTO1.setCategory(new CategoryDTO());

        return productDTO1;}

   /* private List<Product> convertFromListDTOToListEntity(List<ProductDTO> productDTOS){
        List<Product> products = new ArrayList<>();
        for (ProductDTO product: productDTOS){
            products.add(convertFromDTOToEntity(product));
        }
        return products;}*/

       private Product convertFromDTOToEntity(ProductDTO productDTO, Integer categoryID){
        Product product = new Product();
        if(productDTO.getProductID()!= null)
        {product.setProductName(productDTO.getProductName());}

       // product.setCategoryID(categoryID);
        product.setUnit(productDTO.getUnit());
        product.setPrice(productDTO.getPrice());
        product.setInStock(productDTO.getInStock());
        return product;
        }

    private Product convertFromDTOToEntityWithCategory(ProductDTO productDTO, CategoryDTO categoryDTO){
        Product product = new Product();
        if (productDTO.getProductID() != null){
            product.setProductID(productDTO.getProductID());
        }
        product.setProductName(productDTO.getProductName());
       // product.setCategoryID(productDTO.getCategoryID());
        product.setUnit(productDTO.getUnit());
        product.setPrice(productDTO.getPrice());
        product.setInStock(productDTO.getInStock());
        product.setCategory(convertFromDTOToEntity(categoryDTO, product));
        return product;
    }
    private Category convertFromDTOToEntity ( CategoryDTO categoryDTO, Product product){
        Category category1 = new Category();
        if(categoryDTO.getCategoryID() != null){
            category1.setCategoryID(categoryDTO.getCategoryID());
        }
        category1.setCategoryName(categoryDTO.getCategoryName());
        category1.setDescription(categoryDTO.getDescription());
        List<Product> products = new ArrayList<>();
        products.add(product);
        category1.setProducts(products);
        return category1;
}}
