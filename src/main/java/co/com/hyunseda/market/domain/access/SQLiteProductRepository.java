package co.com.hyunseda.market.domain.access;

import co.com.hyunseda.market.domain.Category;
import co.com.hyunseda.market.domain.Product;
import co.com.hyunseda.market.service.ProductService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class SQLiteProductRepository implements IProductRepository {
    
    private final Connection conn;

    public SQLiteProductRepository(Connection conn) {
        this.conn = conn;
    }
    

    @Override
    public boolean save(Product newProduct) {
   
        try {
            if (newProduct == null || newProduct.getName().isEmpty()) {
                return false;
            }

            String sql = "INSERT INTO products (name, description) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newProduct.getName());
            pstmt.setString(2, newProduct.getDescription());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Product> findAll() {
    List<Product> products = new ArrayList<>();
        try {

            String sql = "SELECT * FROM products";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Product newProduct = new Product();
                newProduct.setProductId(rs.getLong("productId"));
                newProduct.setName(rs.getString("name"));
                newProduct.setDescription(rs.getString("description"));

                products.add(newProduct);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    @Override
    public boolean edit(long id, Product product) {
    try {
            //Validate product
            if (id <= 0 || product == null) {
                return false;
            }
            //this.connect();

            String sql = "UPDATE  products "
                    + "SET name=?, description=? "
                    + "WHERE productId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getDescription());
            pstmt.setLong(3, id);
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
    try {
            //Validate product
            if (id <= 0) {
                return false;
            }
            //this.connect();

            String sql = "DELETE FROM products "
                    + "WHERE productId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Product findById(Long id) {
        try {

                String sql = "SELECT * FROM products  "
                        + "WHERE productId = ?";

                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setLong(1, id);

                ResultSet res = pstmt.executeQuery();

                if (res.next()) {
                    Product prod = new Product();
                    prod.setProductId(res.getLong("productId"));
                    prod.setName(res.getString("name"));
                    prod.setDescription(res.getString("description"));
                    return prod;
                } else {
                    return null;
                }
                //this.disconnect();

            } catch (SQLException ex) {
                Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

    @Override
    public Product findByName(Long name) {
        
      List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE name LIKE ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();
            
          while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getLong("productId"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (Product) products;
        
    }

    @Override
    public List<Product> findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Product> findByCategory(Category category) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE categoryId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, category.getCategoryId());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getLong("productId"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;
    }
    
    
    
}
