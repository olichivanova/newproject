package by.belhard.newproject;

import by.belhard.newproject.controller.ProductController;
import by.belhard.newproject.dto.*;
import by.belhard.newproject.repository.*;
import by.belhard.newproject.repository.entity.*;
import by.belhard.newproject.service.*;
import by.belhard.newproject.service.impl.CategoryServiceImpl;
import by.belhard.newproject.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class NewprojectApplication implements CommandLineRunner{
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ClientServiceImpl clientService;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderDetailService orderDetailService;


    public static void main(String[] args) {
        SpringApplication.run(NewprojectApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {


    }}