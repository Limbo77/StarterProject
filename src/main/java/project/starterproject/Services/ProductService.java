package project.starterproject.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.starterproject.Models.Product;
import project.starterproject.Repositories.ProductRepository;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product addProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return productRepository.save(product);
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).orElse(new Product());
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(long id, Product product, MultipartFile imageFile) throws IOException {
        product.setImageData(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        return productRepository.save(product);
    }


    public List<Product> searchProducts(String keyword) {
        return productRepository.searchProducts(keyword);
    }
}
