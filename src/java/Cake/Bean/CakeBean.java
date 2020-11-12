/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.Bean;

import Cake.DAO.CakeDAO;
import Cake.DTO.CakeDTO;
import Cake.DTO.RegisterDTO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author DuyTT
 */
public class CakeBean implements Serializable {
    //----------User-------------------

    private String search;
    //////////////////////////////////////////////////////
    //----------Cake----------------
    private String cakeID;

    private CakeDAO cakeDAO = null;
    private CakeDTO cakeDTO;

    public CakeBean() {
        cakeDAO = new CakeDAO();
    }

    public List<CakeDTO> findByLikeCakeName() throws Exception {
        return cakeDAO.findByLikeCakeName(search);
    }
    
    public List<CakeDTO> searchDataCakeForDataTable() throws Exception
    {
        return cakeDAO.searchDataCakeForDataTable(search);
    }
    public boolean deleteCakeAdmin() throws Exception {
        return cakeDAO.deleteCakeAdmin(cakeID);
    }

    public boolean insert() throws Exception {
        return cakeDAO.insert(cakeDTO);
    }

    public CakeDTO findByMyPrimaryCakeID() throws Exception {
        return cakeDAO.findByMyPrimaryCakeID(cakeID);
    }

    public boolean updateCake(CakeDTO dto) throws Exception {
        return cakeDAO.updateCake(dto);
    }

    public CakeDAO getCakeDAO() {
        return cakeDAO;
    }

    public void setDao(CakeDAO cakeDAO) {
        this.cakeDAO = cakeDAO;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getCakeID() {
        return cakeID;
    }

    public void setCakeID(String cakeID) {
        this.cakeID = cakeID;
    }

    public CakeDTO getCakeDTO() {
        return cakeDTO;
    }

    public void setCakeDTO(CakeDTO cakeDTO) {
        this.cakeDTO = cakeDTO;
    }

}
