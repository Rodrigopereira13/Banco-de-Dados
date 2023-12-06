package JDBC3.src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import JDBC3.db.DB;

public class Program {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                "INSERT INTO seller "
                + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                + "VALUES "
                + "(?, ?, ?, ?, ?)", //depois vou colocar os valores
                Statement.RETURN_GENERATED_KEYS);  //sobrecarga para retornar o id do novo objeto inserido
            
            st.setString(1, "Carl Purple");
            st.setString(2, "carl@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            st.setDouble(4, 3000.0);
            st.setInt(5, 4);
            
            int rowsAffected = st.executeUpdate(); //executa o  comando para inserir o novo dado
            
            if (rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys(); //pega o valor da key que é um resulset
                
                while(rs.next()){  //percorre o resultset pq pode ter mais de 1 valor
                    int id = rs.getInt(1); //quer o valor da primeira coluna que é o id
                    System.out.println("Done! Id = " + id);
                }
            }
            else {
                System.out.println("No rown affected!");
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e){
            e.printStackTrace();
        }

        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
