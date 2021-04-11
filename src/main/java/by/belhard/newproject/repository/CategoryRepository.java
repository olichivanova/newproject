package by.belhard.newproject.repository;

import by.belhard.newproject.dto.CategoryDTO;
import by.belhard.newproject.repository.entity.Category;
import by.belhard.newproject.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
   public Category getCategoryByCategoryID(@Param("categoryID") Integer categoryID);

   @Query("SELECT c FROM Category c")
   public List<Category> getAllCategories();

   @Query( value = "SELECT c FROM Category c WHERE c.categoryName LIKE concat('%', :keyword,  '%') or c.description LIKE concat('%', :keyword,  '%')  ")
   public List<Category> searchCategory(@Param("keyword") String keyword);
   @Query("SELECT DISTINCT c FROM Category c LEFT JOIN FETCH c.products WHERE c.categoryID =:categoryID")
   public Category getCategoryWithProducts(@Param("categoryID") Integer categoryID);



}
