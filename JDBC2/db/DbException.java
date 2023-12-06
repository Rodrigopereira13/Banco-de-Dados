package JDBC2.db;

public class DbException extends RuntimeException{ //exceção 
    
    private static final long serialVersionUID = 1L;
    public DbException(String msg){
        super(msg);
    }
}
