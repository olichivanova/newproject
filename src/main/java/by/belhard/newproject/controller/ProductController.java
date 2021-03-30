package by.belhard.newproject.controller;

import by.belhard.newproject.dto.CategoryDTO;
import by.belhard.newproject.dto.ProductDTO;
import by.belhard.newproject.repository.entity.Category;
import by.belhard.newproject.repository.entity.Product;
import by.belhard.newproject.service.ProductService;
import by.belhard.newproject.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller

public class ProductController {

    private ProductService productService;




    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;

    }

    @RequestMapping("/search")
    public String search(@RequestParam String keyword, ModelMap modelMap) {
        List<ProductDTO> result = productService.search(keyword);
        modelMap.addAttribute("result", result);
        return "search";
    }

    @RequestMapping("/products/open")
    public String getProductByID(@RequestParam("productID") Integer id, ModelMap modelMap) {
        ProductDTO productDTO = productService.getProductByProductIDWithCategory(id);
        modelMap.addAttribute("productDTO", productDTO);
        return "open";
    }


    @RequestMapping("/products")
    public String getAllProducts(ModelMap modelMap) {
        List<ProductDTO> productDTOList = productService.getAllProducts();
        modelMap.addAttribute("productDTOList", productDTOList);
        return "products";

    }

    @RequestMapping("/categories/next")
    public String getAllProductsByCategory(@RequestParam("categoryID") Integer id, ModelMap modelMap) {
        List<ProductDTO> products = productService.getAllProductsByCategoryWithCategory(id);
        modelMap.addAttribute("products", products);
        return "next";

    }

    @RequestMapping("/admin-products")
    public String getAllProductsByCategoryAdmin(@RequestParam("categoryID") Integer id, ModelMap modelMap) {
        List<ProductDTO> products = productService.getAllProductsByCategoryWithCategory(id);
        modelMap.addAttribute("products", products);

        return "admin-products";
    }

    @RequestMapping("/new-product")
    public String addNewCategoryForm(@RequestParam("categoryID") Integer id, ModelMap modelMap) {
        ProductDTO productDTO = new ProductDTO();
        List <ProductDTO> list = productService.getAllProductsByCategoryWithCategory(id);
        ProductDTO productDTO1 =productService.getProductByProductIDAndCategory(list.get(0).getProductID()) ;
        CategoryDTO categoryDTO1 = productDTO1.getCategory();
        productDTO.setCategoryID(id);
        productDTO.setCategory(categoryDTO1);
        modelMap.addAttribute("product", productDTO);
        return "new-product";
    }

    @RequestMapping(value = "/save-product", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") ProductDTO productDTO, @RequestParam("categoryID") Integer categoryID) {
    List <ProductDTO> list = productService.getAllProductsByCategoryWithCategory(categoryID);
   ProductDTO productDTO1 =productService.getProductByProductIDAndCategory(list.get(0).getProductID()) ;
   CategoryDTO categoryDTO1 = productDTO1.getCategory();
      productService.save(productDTO, categoryDTO1);
        return "redirect:/admin";

    }

    @RequestMapping("/delete-product")
    public String deleteProduct(@RequestParam("productID") Integer productID) {
        productService.delete(productID);
        return "redirect:/admin";
    }

   @RequestMapping(value = "/edit-product")
    public String editCategory(@RequestParam("productID") Integer productID, ModelMap modelMap) {
        ProductDTO productDTO = productService.getProductByProductIDAndCategory(productID);

        modelMap.addAttribute("product", productDTO);
        return "/edit-product";
    }
    @RequestMapping(value = "/save-entity", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") ProductDTO productDTO) {
        ProductDTO productDTO1 = productDTO;
       /* Integer categoryID = productDTO.getCategoryID();
        List <ProductDTO> list = productService.getAllProductsByCategoryWithCategory(categoryID);
        ProductDTO productDTO1 =productService.getProductByProductIDAndCategory(list.get(0).getProductID()) ;
        CategoryDTO categoryDTO1 = productDTO1.getCategory();
        productService.save(productDTO, categoryDTO1);*/
        return "redirect:/admin";

    }
}



