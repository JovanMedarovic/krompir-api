package com.dragacevoshop.krompirApi.services;

import com.dragacevoshop.krompirApi.models.Product;
import com.dragacevoshop.krompirApi.repositories.ProductRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    public static String FILE_URL = "https://docs.google.com/document/d/182-tFDVkGZjMeYTdV-CC1yUcpffz--ZvMJOuP8cLEqQ/export?format=txt";

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> addProducts() {
        List<Product> products = new ArrayList<>();
        try {
            URL url = new URL(FILE_URL);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Skip empty lines
                    if (line.trim().isEmpty()) continue;

                    String[] parts = line.split(",", -1);
                    if (parts.length != 5) {
                        System.out.println("Skipping invalid line: " + line);
                        continue;
                    }

                    Product product = new Product();
                    product.setName(parts[0].trim());
                    product.setDescription(parts[1].trim());
                    product.setImageUrl(parts[2].trim());
                    product.setPrice(Float.parseFloat(parts[3].trim()));
                    product.setUnit(parts[4].trim());

                    products.add(product);
                }
            }

            productRepository.deleteAll();
            return productRepository.saveAll(products);
        } catch (Exception e) {
            e.printStackTrace(); // You can use a logger here
        }

        return products;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void scheduledAddProducts() {
        System.out.println("Scheduled addProducts triggered...");
        addProducts();
    }
}
