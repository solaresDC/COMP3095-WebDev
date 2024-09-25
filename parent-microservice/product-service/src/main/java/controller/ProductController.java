package controller;

import dto.ProductRequest;
import dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProduct(){
        return  productService.getAllProducts();
    }
    //http://localhost:8080/api/product/queryetc....
    @PutMapping("/productId")
    //@ResponseStatus(HttpStatus.NO_CONTENT) // OPTION 1
    public ResponseEntity<?> updateProduct(@PathVariable("prductId")String productId,
                                           @PathVariable ProductRequest productRequest){

        String updatedProductId = productService.updateProduct(productId, productRequest);

        //set the loction header attribute
        HttpHeaders headers = new HttpHeaders();
        headers.add("Loaction", "/api/product" + updatedProductId);

        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT); //OPTION 2
    }
@DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("prductId")String productId){

        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
