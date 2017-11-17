/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fernando.teste.control;

import fernando.teste.model.CostumerAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fer_n
 */
public class DaoCostumerAccount {

    private Connection conexao;
    public DaoCostumerAccount(Connection conexao){
        this.conexao = conexao;
        
    }
    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir(CostumerAccount costumeerAccount) throws SQLException {
        PreparedStatement ps = null;
        int is_active = costumeerAccount.getIs_active() ? 1 : 0;

        try {
            ps = conexao.prepareStatement("INSERT INTO COSTUMERS("
                    + " ID_COSTUMER,"
                    + "CPF_CNPJ,"
                    + "NM_COSTUMER,"
                    + "IS_ACTIVE,"
                    + "VL_TOTAL)"
                    + "VALUES(?,?,?,?,?)");

            ps.setInt(1, costumeerAccount.getId_costumer());
            ps.setString(2, costumeerAccount.getCpf_cnpj());
            ps.setString(3, costumeerAccount.getNm_costumer());
            ps.setInt(4, is_active);
            ps.setDouble(5, costumeerAccount.getVl_total());

            ps.execute();
        } catch (SQLException err) {
            System.out.println(err.toString());
        }

    }

    public List<CostumerAccount> consultar() {
        List<CostumerAccount> costummerAccouts = new ArrayList<>();
        CostumerAccount costumerAccount;
        PreparedStatement ps = null;
        boolean is_active;

        try {
            ps = conexao.prepareStatement("SELECT * FROM COSTUMERS");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                is_active = rs.getInt("IS_ACTIVE") == 1 ? true : false;
                costumerAccount = new CostumerAccount(rs.getInt("ID_COSTUMER"),
                        rs.getString("CPF_CNPJ"),
                        rs.getString("NM_COSTUMER"),
                        is_active,
                        rs.getDouble("VL_TOTAL"));
                
               costummerAccouts.add(costumerAccount);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString() + " Erro NO DAO ");
        }
        return costummerAccouts;
    }
    
    
}
