package co.com.hyunseda.market.domain.access;

import co.com.hyunseda.market.domain.Category;
import co.com.hyunseda.market.domain.Product;
//import co.com.hyunseda.market.domain.access.ICategoryRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class SQLiteCategoryRepository implements ICategoryRepository{
    
    private final Connection conn;
    
    public SQLiteCategoryRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean save(Category category) {
        String sql = "INSERT INTO categories (name) VALUES (?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category.getName());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            // Manejar la excepción adecuadamente (log, relanzar, etc.)
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Category category = new Category();
                category.setCategoryId(rs.getLong("categoryId"));
                category.setName(rs.getString("name"));
                categories.add(category);
            }
        } catch (SQLException ex) {
            // Manejar la excepción adecuadamente (log, relanzar, etc.)
            ex.printStackTrace();
        }

        return categories;
    }

    @Override
    public boolean edit(long categoryId, Category category) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Long categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Product findById(Long categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Product findByName(Long categoryName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
