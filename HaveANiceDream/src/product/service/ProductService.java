package product.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import product.ProductDTO;

public interface ProductService {
	int insertProduct(ProductDTO product, String imageSrc);
	ArrayList<ProductDTO>  product_List(String title);
	ProductDTO productSelect(int productNo);
	String productSelect_Image(int productNo);
	int updateProduct(ProductDTO product, String imageSrc);
}
