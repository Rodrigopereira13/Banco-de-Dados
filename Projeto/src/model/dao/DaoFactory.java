package Projeto.src.model.dao;

import Projeto.src.model.daoimpl.SellerDaoJDBC;

public class DaoFactory {
    
    public static SellerDao createSellerDao(){ //expor uma interface SellerDao 
                                               //mas internamente vai instanciar uma implementação 
        return new SellerDaoJDBC();
    }
}
