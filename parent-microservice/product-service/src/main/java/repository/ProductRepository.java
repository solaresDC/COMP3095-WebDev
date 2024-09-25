package repository;

import dto.ProductRequest;
import dto.ProductResponse;
import model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {




}
