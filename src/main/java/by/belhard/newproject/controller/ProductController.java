package by.belhard.newproject.controller;


import by.belhard.newproject.dto.ProductDTO;
import by.belhard.newproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String getProductByID(@RequestParam("productID") Integer id, @RequestParam("orderID") Integer orderID, ModelMap modelMap) {
        ProductDTO productDTO = productService.getProductByProductIDWithCategory(id);
        modelMap.addAttribute("productDTO", productDTO);
       modelMap.addAttribute("category", productDTO.getCategory());
        String message = String.valueOf(orderID);
        modelMap.addAttribute("orderID",message );


        return "open";
    }
    @RequestMapping("/products-home")
    public String getAllProducts(  ModelMap modelMap) {
        List<ProductDTO> productDTOList = productService.getAllProducts();
        modelMap.addAttribute("productDTOList", productDTOList);
        return "products-home";

    }

    @RequestMapping("/products-home/open")
    public String getProductByIDHome(@RequestParam("productID") Integer id, ModelMap modelMap) {
        ProductDTO productDTO = productService.getProductByProductIDWithCategory(id);
        modelMap.addAttribute("productDTO", productDTO);

        return "open-home";
    }

    @RequestMapping("/products")
    public String getAllProductsHome(@ModelAttribute("message")String message1, @RequestParam("orderID") Integer orderID, ModelMap modelMap) {
        List<ProductDTO> productDTOList = productService.getAllProducts();
        modelMap.addAttribute("productDTOList", productDTOList);
        String message = String.valueOf(orderID);
        modelMap.addAttribute("orderID",message );
        return "products";

    }

    @RequestMapping("/categories-home/next-home")
    public String getAllProductsByCategory(@RequestParam("categoryID") Integer id, ModelMap modelMap) {
        List<ProductDTO> products = productService.getAllProductsByCategoryWithCategory(id);
        modelMap.addAttribute("products", products);
        return "next-home";

    }
    @RequestMapping("/categories/next")
    public String getAllProductsByCategoryWithOrder(@RequestParam("orderID") Integer orderID, @RequestParam("categoryID") Integer id, ModelMap modelMap) {
        List<ProductDTO> products = productService.getAllProductsByCategoryWithCategory(id);
        modelMap.addAttribute("products", products);
        String message = String.valueOf(orderID);
        modelMap.addAttribute("orderID",message );
        return "next";

    }

    @RequestMapping("/admin-products")
    public String getAllProductsByCategoryAdmin(@RequestParam("categoryID") Integer id, ModelMap modelMap) {
        List<ProductDTO> products = productService.getAllProductsByCategoryWithCategory(id);
        modelMap.addAttribute("products", products);
        modelMap.addAttribute("categoryID", String.valueOf(id));

        return "admin-products";
    }



    @RequestMapping("/delete-product")
    public String deleteProduct(@RequestParam("productID") Integer productID) {
        productService.delete(productID);
        return "redirect:/admin";
    }

}



