package JDBC4.src;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;


import JDBC4.db.DB;

public class Program {
    public static void main(String[] args) {
        
        Connection conn = null;
        PreparedStatement st = null; 

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "UPDATE seller "
                    + "SET BaseSalary = BaseSalary + ? " //atualizar o salario*
                    + "WHERE " // faz um restrição para nao atualizar todo mundo
                    +"(DepartmentId = ?)"); //*do departmento especificado depois
        
            st.setDouble(1, 200.0); //1 é o primeiro ?
            st.setInt(2, 2);

            int rowsAffected = st.executeUpdate();
            
            System.out.println("Done! Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
