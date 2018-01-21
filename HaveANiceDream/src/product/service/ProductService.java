package product.service;

import java.sql.Connection;
import java.util.ArrayList;

import product.ProductDTO;

public interface ProductService {
	int insertProduct(ProductDTO product);
	ArrayList<ProductDTO>  product_List();
}
