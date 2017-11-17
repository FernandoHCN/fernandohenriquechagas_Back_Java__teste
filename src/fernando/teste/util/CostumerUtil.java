/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fernando.teste.util;

import fernando.teste.control.DaoCostumerAccount;
import fernando.teste.model.CostumerAccount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author fer_n
 */
public class CostumerUtil {

    CostumerAccount costumerAccount;
    List<CostumerAccount> costumersAccounts;
    List<CostumerAccount> auxListCostumersAccounts;
    DaoCostumerAccount daoCostumerAccount;
    Stream<CostumerAccount> stream;

    public CostumerUtil(DaoCostumerAccount daoCostumerAccount) {
        this.daoCostumerAccount = daoCostumerAccount;
        this.costumersAccounts = new ArrayList<>();
        this.auxListCostumersAccounts = new ArrayList<>();

    }

    public Double mediaFinal() {
        this.costumersAccounts = this.daoCostumerAccount.consultar();
        this.auxListCostumersAccounts = this.costumersAccounts.stream()
                .filter(costumerAccount -> (costumerAccount.getVl_total() > 560) && (costumerAccount.getId_costumer() >= 1500 && costumerAccount.getId_costumer() <= 2700))
                .collect(Collectors.toCollection(ArrayList::new));
        double mediaFinal = this.auxListCostumersAccounts.stream()
                .mapToDouble(costumerAccount -> costumerAccount.getVl_total())
                .average()
                .getAsDouble();

        return mediaFinal;
    }
    
    public void imprimirClientes(){
        Collections.sort(this.auxListCostumersAccounts);
        System.out.println(this.auxListCostumersAccounts);
    }
}
