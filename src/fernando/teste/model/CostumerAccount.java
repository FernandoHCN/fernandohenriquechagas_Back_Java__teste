/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fernando.teste.model;

/**
 *
 * @author fer_n
 */
public class CostumerAccount implements Comparable<CostumerAccount> {

    private int id_costumer;
    private String cpf_cnpj;
    private String nm_costumer;
    private Boolean is_active;
    private Double vl_total;

    public CostumerAccount(int id_costumer, String cpf_cnpj, String nm_costumer, Boolean is_active, Double vl_total) {
        this.id_costumer = id_costumer;
        this.cpf_cnpj = cpf_cnpj;
        this.nm_costumer = nm_costumer;
        this.is_active = is_active;
        this.vl_total = vl_total;
    }

    public int getId_costumer() {
        return id_costumer;
    }

    public void setId_costumer(int id_costumer) {
        this.id_costumer = id_costumer;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getNm_costumer() {
        return nm_costumer;
    }

    public void setNm_costumer(String nm_costumer) {
        this.nm_costumer = nm_costumer;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public Double getVl_total() {
        return vl_total;
    }

    public void setVl_total(Double vl_total) {
        this.vl_total = vl_total;
    }

    @Override
    public int compareTo(CostumerAccount o) {
        if (this.vl_total > o.vl_total) {
            return -1;
        }
        if (this.vl_total < o.vl_total) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        String isActive = is_active ? "Ativo" : "Inativo";
        return "CostumerAccount{" + "id_costumer=" + id_costumer + ", cpf_cnpj=" + cpf_cnpj + ", nm_costumer=" + nm_costumer + ", is_active=" + isActive + ", vl_total=" + vl_total + '}';
    }

}
