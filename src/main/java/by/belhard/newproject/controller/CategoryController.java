package by.belhard.newproject.controller;

import by.belhard.newproject.dto.CategoryDTO;
import by.belhard.newproject.dto.ProductDTO;
import by.belhard.newproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@Controller
public class CategoryController  {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/categories-home")
    public String getAllProducts(ModelMap modelMap){
        List<CategoryDTO> categoryDTOList1 = categoryService.getAllCategories();
        modelMap.addAttribute("categoryDTOList1", categoryDTOList1);
        return "category-home";

    }
    @RequestMapping("/categories")
    public String getAllProductsWithOrder(@RequestParam("orderID") Integer orderID, ModelMap modelMap){
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategories();
        modelMap.addAttribute("categoryDTOList", categoryDTOList);
        modelMap.addAttribute("orderID", orderID);
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

    @RequestMapping("/new-product")
    public String addNewProductForm(@RequestParam("categoryID") Integer categoryID, ModelMap modelMap) {
    CategoryDTO categoryDTO = categoryService.getCategoryByCategoryID(categoryID);
    ProductDTO productDTO = new ProductDTO();
    productDTO.setCategory(categoryDTO);
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategories();
        modelMap.addAttribute("categoryDTOList", categoryDTOList);
        modelMap.addAttribute("product", productDTO);
        modelMap.addAttribute("category", categoryDTO);

        return "new-product";}

  @RequestMapping(value = "/save-product", method= RequestMethod.POST)
    public String saveProduct (@ModelAttribute("product") ProductDTO productDTO, @ModelAttribute("category") CategoryDTO categoryDTO){

       categoryService.saveEntity(productDTO, categoryDTO);
        return "redirect:/admin";
    }


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

    @RequestMapping(value = "/edit-product")
    public String editProduct(@RequestParam("productID") Integer productID, @RequestParam("categoryID") Integer categoryID, ModelMap modelMap) {
        ProductDTO productDTO = null;
        CategoryDTO categoryDTO = categoryService.getCategoryWithProducts(categoryID);
        for (ProductDTO x : categoryDTO.getProducts()) {
            if (x.getProductID() == productID) {
                productDTO = x; }
        }
        modelMap.addAttribute("product", productDTO);
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategories();
        modelMap.addAttribute("categoryDTOList", categoryDTOList);
        return "/edit-product";
    }
    @RequestMapping(value = "/save-pr", method= RequestMethod.POST)
    public String saveProductUpdate (@ModelAttribute("product") ProductDTO productDTO){
    CategoryDTO categoryDTO = categoryService.getCategoryByCategoryID(productDTO.getCategory().getCategoryID());
        categoryService.saveEntity(productDTO, categoryDTO);
        return "redirect:/admin";}


}
