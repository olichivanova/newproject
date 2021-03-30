package by.belhard.newproject;

import by.belhard.newproject.controller.ProductController;
import by.belhard.newproject.dto.CategoryDTO;
import by.belhard.newproject.dto.ProductDTO;
import by.belhard.newproject.repository.*;
import by.belhard.newproject.repository.entity.*;
import by.belhard.newproject.service.CategoryService;
import by.belhard.newproject.service.ProductService;
import by.belhard.newproject.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class NewprojectApplication implements CommandLineRunner{
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;


    public static void main(String[] args) {
        SpringApplication.run(NewprojectApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {







    }
}
