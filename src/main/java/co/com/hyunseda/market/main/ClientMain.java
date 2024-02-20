package co.com.hyunseda.market.main;

import co.com.hyunseda.market.presentation.GUIProducts;
import co.com.hyunseda.market.service.ProductService;
import co.com.hyunseda.market.domain.access.SQLiteCategoryRepository;
import co.com.hyunseda.market.domain.access.SQLiteConnection;
import co.com.hyunseda.market.domain.access.SQLiteDataBaseInitializer;
import co.com.hyunseda.market.domain.access.SQLiteProductRepository;
import co.com.hyunseda.market.domain.access.IProductRepository;
import co.com.hyunseda.market.domain.access.ICategoryRepository;
import co.com.hyunseda.market.domain.access.IDataBaseConnection;
import co.com.hyunseda.market.domain.access.IDataBaseInitializer;
import co.com.hyunseda.market.presentation.GUIMainMenu;

/**
 *
 * @author Libardo Pantoja
 */
public class ClientMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Crear la conexión a la base de datos
        IDataBaseConnection dbConnection = new SQLiteConnection();
        dbConnection.connect();

        // Inicializar la base de datos utilizando el inicializador correspondiente
        IDataBaseInitializer dbInitializer = new SQLiteDataBaseInitializer(dbConnection.getConnection());

        // Crear el repositorio de productos con la conexión a la base de datos
        IProductRepository productR = new SQLiteProductRepository(dbConnection.getConnection());
        
        // Crear el repositorio de categorias con la conexión a la base de datos
        ICategoryRepository categoryR = new SQLiteCategoryRepository(dbConnection.getConnection());

        // Crear el servicio de productos con el repositorio y el inicializador
        ProductService productS = new ProductService(productR,categoryR, dbInitializer);

        GUIMainMenu menuForm = new GUIMainMenu(productS);
        
        menuForm.setVisible(true);
        
        /*// Crear la interfaz de usuario y pasar el servicio de productos
        GUIProducts guiProducts = new GUIProducts(productS);
        
        guiProducts.setVisible(true);// Hacer visible la interfaz de usuario*/
        
        
        /*// Crear la conexión a la base de datos (puede variar según la implementación específica)
        IDataBaseConnection dbConnection = (IDataBaseConnection) new SQLiteConnection();
        dbConnection.connect();
        
        
        // Inicializar la base de datos utilizando el inicializador correspondiente
        IDataBaseInitializer dbInitializer = new SQLiteDatabaseInitializer(dbConnection.getConnection());
        
        //Crear el servicio de productos con la conexión y el inicializador
        ProductService productService = new ProductService(dbConnection.getConnection(), productR, dbInitializer);*/
        
        //GUIProducts guiProducts = new GUIProducts(productS);
          
        
    }
    
}
