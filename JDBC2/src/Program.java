package JDBC2.src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import JDBC2.db.DB;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null; // consulta
        ResultSet rs = null; // resultado da consulta

        try {
            conn = DB.getConnection();

            st = conn.createStatement(); // instancia objeto do tipo statement

            rs = st.executeQuery("select * from department"); // executa a consulta trazendo o department

            while (rs.next()) { // enquanto tiver next imprimir rs com o nome do cmapo id e name
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            DB.closeResulSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
