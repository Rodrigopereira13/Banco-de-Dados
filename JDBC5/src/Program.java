package JDBC5.src;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;


import JDBC4.db.DB;
import JDBC5.db.DbIntegrityException;

public class Program {
    public static void main(String[] args) {
        
        Connection conn = null;
        PreparedStatement st = null; 

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "DELETE FROM department "
                    + "WHERE "
                    + "id = ?");
            
            st.setInt(1, 5);

            int rowsAffected = st.executeUpdate();
            
            System.out.println("Done! Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
