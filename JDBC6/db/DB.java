package JDBC6.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

    private static Connection conn = null; //variavel de conexao 

    public static Connection getConnection(){
        if(conn == null){
            try{
                Properties props = loadProperties(); //carrega as propriedades
                String url = props.getProperty("dburl");  //carrega a url do mysql
                conn =  DriverManager.getConnection(url, props);
            }
            catch(SQLException e){
                throw new DbException(e.getMessage());
            }
            
        }
        return conn;
    }

    public static void closeConnection(){
        if(conn != null){
            try{
                conn.close();
            }
            catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
    
    private static Properties loadProperties(){ //carregar as propriedades do arquivo db.properties

        try (FileInputStream fs = new FileInputStream("C:\\Users\\rodri\\Documents\\MeusProjetos\\Banco-de-Dados\\JDBC\\db\\db.properties")) {
            //le o arquivo
            
            Properties props = new Properties(); // faz uma classe
            props.load(fs); //faz a leitura e coloca fs em props 
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatement(Statement st){
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResulSet(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }


}
