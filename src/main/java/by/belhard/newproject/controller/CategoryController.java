package by.belhard.newproject.controller;

import by.belhard.newproject.dto.CategoryDTO;
import by.belhard.newproject.dto.ProductDTO;
import by.belhard.newproject.repository.entity.Category;
import by.belhard.newproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;
import java.util.Map;

@Controller
public class CategoryController  {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/categories")
    public String getAllProducts(ModelMap modelMap){
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategories();
        modelMap.addAttribute("categoryDTOList", categoryDTOList);
        return "category";

    }
    @RequestMapping("/search-category")
    public String searchCategory(@RequestParam String keyword, ModelMap modelMap) {
        List<CategoryDTO> result = categoryService.searchCategory(keyword);
        modelMap.addAttribute("result", result);
        return "search-category";}

    @RequestMapping("/admin")
    public String getAllCategories(ModelMap modelMap){
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategories();

        modelMap.addAttribute("categoryDTOList", categoryDTOList);
        return "admin";

}

   /* @RequestMapping("/admin-open")
    public String getCategory(@RequestParam Integer categoryID,  ModelMap modelMap){
        CategoryDTO categoryDTO = categoryService.getCategoryByCategoryID(categoryID);
        modelMap.addAttribute("categoryDTO", categoryDTO);
        return "admin-open";}*/

@RequestMapping("/new-category")
    public String addNewCategoryForm(ModelMap modelMap){
        CategoryDTO category = new CategoryDTO();
        modelMap.addAttribute("category", category);
        return "new-category";
}
    @RequestMapping(value = "/save", method= RequestMethod.POST)
    public String updateCategory (@ModelAttribute("category") CategoryDTO category ){
        categoryService.save(category);
        return "redirect:/admin";
    }



   /* @RequestMapping(value = "/save-product", method= RequestMethod.POST)
    public String saveProduct (@ModelAttribute("product") ProductDTO productDTO, @RequestParam("categoryID") Integer categoryID ){
        CategoryDTO categoryDTO = categoryService.getCategoryByCategoryID(categoryID);

        categoryService.saveEntity(categoryDTO, productDTO);
        return "redirect:/admin";
    }*/


    @RequestMapping("/delete-category")
    public String deleteCategory(@RequestParam("categoryID") Integer categoryID) {
        categoryService.delete(categoryID);
        return "redirect:/admin";
    }
    @RequestMapping(value = "/edit-category")
    public String editCategory(@RequestParam("categoryID") Integer categoryID, ModelMap modelMap) {
        CategoryDTO categoryDTO = categoryService.getCategoryByCategoryID(categoryID);
        modelMap.addAttribute("category", categoryDTO);
        return "/edit-category";
    }



}
