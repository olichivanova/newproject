package by.belhard.newproject.repository;

import by.belhard.newproject.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p")
    public List<Product> getAllProducts();

    @Query("SELECT p FROM Product p WHERE p.productName = :productName")
    public Product getProductsByName(@Param( "productName") String productName );

    @Query("SELECT DISTINCT p FROM Product p LEFT JOIN FETCH p.category")
    public List<Product> getAllProductsWithCategories();

   // @Query("SELECT DISTINCT p FROM Product p LEFT JOIN FETCH p.category WHERE p.categoryID= :categoryID")
  // public Product getProductWithCategories(@Param( "categoryID") Integer categoryID );
  // @Query("SELECT DISTINCT p FROM Product p LEFT JOIN FETCH p.category WHERE p.categoryID =:categoryID")
  //  public Product getProductByCategoryID(@Param( "categoryID") Integer categoryID );

    public Product getProductByProductID(@Param("productID") Integer productID);
    public void deleteByProductID(@Param("productID") Integer productID);
    @Query(value = "SELECT p FROM Product p WHERE p.productName LIKE concat('%', :keyword,  '%') "
            )
    public List<Product> search(@Param("keyword") String keyword);

    @Query("SELECT DISTINCT p FROM Product p LEFT JOIN FETCH p.category WHERE p.productID= :productID")
    public Product getProductByProductIDWithCategory(@Param("productID") Integer productID);

    @Query("SELECT DISTINCT p FROM Product p LEFT JOIN FETCH p.category WHERE p.category.categoryID =:categoryID")
    public List<Product> getAllProductsByCategoryWithCategory(@Param("categoryID") Integer categoryID);




}
