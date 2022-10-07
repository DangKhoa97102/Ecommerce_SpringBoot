package com.ecommerce.library.service;

import com.ecommerce.library.dto.ProductDto;
import com.ecommerce.library.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    /* ADMIN */
    List<ProductDto> findAll();
    Product save(ProductDto productDto, MultipartFile imageProduct);
    Product update(ProductDto productDto, MultipartFile imageProduct);
    void deletedById(Long id);
    void enableById(Long id);
    ProductDto getById(Long id);
    Page<ProductDto> pageProducts(int pageNo);
    Page<ProductDto> searchProducts(int pageNo, String keyword);
    List<ProductDto> transfer(List<Product> products);

    /* CUSTOMER */
    List<Product> getAllProducts();
    List<Product> listViewProducts();
    Product getProductById(Long id);
    List<Product> getRelatedProducts(Long categoryId);
    List<Product> getProductsInCategory(Long categoryId);
    List<Product> filterHighPrice();
    List<Product> filterLowPrice();

}
