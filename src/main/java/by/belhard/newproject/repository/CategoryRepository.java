package by.belhard.newproject.repository;

import by.belhard.newproject.repository.entity.Category;
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






}
