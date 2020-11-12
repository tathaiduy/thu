/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.Bean;

import Cake.DAO.BillDAO;
import Cake.DTO.BillDTO;
import Cake.DTO.BookDTO;
import Cake.DTO.CakeDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author tatha
 */
public class BillBean implements Serializable{
    private String search;
    
    private BillDAO dao = null;
    private BillDTO dto;
    private CakeDTO cake;
    public BillBean() {
        dao = new BillDAO();
    }

    public CakeDTO getCake() {
        return cake;
    }

    public void setBook(CakeDTO cake) {
        this.cake = cake;
    }
    
    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public BillDAO getDao() {
        return dao;
    }

    public void setDao(BillDAO dao) {
        this.dao = dao;
    }

    public BillDTO getDto() {
        return dto;
    }

    public void setDto(BillDTO dto) {
        this.dto = dto;
    }
      
    public List<BillDTO> getBillNumber() throws Exception
    {
        return dao.getBillNumber(search);
    }
    
    public boolean InsertBillOrderTable() throws Exception
    {
        return dao.InsertBillOrderTable(dto);
    }
    
    public boolean InsertBillDetailTable() throws Exception
    {
        return dao.InsertBillDetailTable(dto);
    }
    
    public List<BillDTO> findBillCustomerByFullname() throws Exception
    {
        return dao.findBillCustomerByFullname(search);
    }
    public HashMap getNumberOfEachBill() throws Exception
    {
        return dao.getNumberOfEachBill();
    }
}
