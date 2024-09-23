package project.starterproject.Controllers;

import org.springframework.web.bind.annotation.*;
import project.starterproject.Models.Product;
import project.starterproject.Services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(){
        return "Hello World";
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/products/add")
    public String addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return "Product added";
    }
}
