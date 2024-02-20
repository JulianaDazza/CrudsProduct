package co.com.hyunseda.market.service;


import co.com.hyunseda.market.domain.Category;
import co.com.hyunseda.market.domain.Product;
import co.com.hyunseda.market.domain.access.ICategoryRepository;
import co.com.hyunseda.market.domain.access.IProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import co.com.hyunseda.market.domain.access.IDataBaseInitializer;

/**
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public class ProductService {

    //private Connection conn;
    private final IProductRepository productR;
    private final ICategoryRepository categoryR;
    private final IDataBaseInitializer databaseInitializer;
    
    public ProductService(IProductRepository productR, ICategoryRepository categoryR, IDataBaseInitializer databaseInitializer) {
        //this.conn = conn;
        this.productR = productR;
        this.categoryR = categoryR;
        this.databaseInitializer = databaseInitializer;
        this.databaseInitializer.initDatabase();
    }
    
  
    public boolean saveProduct(String name, String description) {
        
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setDescription(description);
        
        //Validate product
        if (newProduct.getName().isEmpty() ) {
            return false;
        }

        return productR.save(newProduct);

    }
    
    public List<Category> findAllCategories() {
        return categoryR.findAll();
    }
    
    public boolean saveCategory(String categoryName) {
        Category category = new Category();
        category.setName(categoryName);
        return categoryR.save(category);
    }
    
    public boolean editCategory(Long categoryId, Category cat) {
        
        //Validate product
        if (cat == null || cat.getName().isEmpty() ) {
            return false;
        }
        return categoryR.edit(categoryId, cat);
    }
    
    ///////////////////////////////////////////////////////////////////
    /////////////////////   REVISAR  //////////////////////////////////
    /*public List<Product> findProductsByCategory(Long categoryId) {
       
    }*/
    
    ///////////////////////////////////////////////////////////////////

    public List<Product> findAllProducts() {
        /*List<Product> products = new ArrayList<>();
        products = findAll();*/

        return productR.findAll();
    }
    
    public Product findProductById(Long id){
        return productR.findById(id);
    }
    
    public List<Product> findProductsByName(Long name) {
        return (List<Product>) productR.findByName(name);
    }

    
    public boolean deleteProduct(Long id){
        return productR.delete(id);
    }

    public boolean editProduct(Long productId, Product prod) {
        
        //Validate product
        if (prod == null || prod.getName().isEmpty() ) {
            return false;
        }
        return productR.edit(productId, prod);
    }

}
