package Projeto.src.applcation;

import java.util.Date;

import Projeto.src.model.dao.DaoFactory;
import Projeto.src.model.dao.SellerDao;
import Projeto.src.model.entities.Department;
import Projeto.src.model.entities.Seller;

public class Program {
    
    public static void main(String[] args) {
        
        
        SellerDao sellerDao = DaoFactory.createSellerDao();//injeção de dependencia sem explicitar a implentação

        Seller seller = sellerDao.findById(3);

        System.out.println(seller);
    }
}
