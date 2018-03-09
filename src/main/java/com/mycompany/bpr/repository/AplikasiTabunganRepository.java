/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.repository;

import com.mycompany.bpr.entity.aplikasi.Tabungan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author bubun
 */
public interface AplikasiTabunganRepository extends CrudRepository<Tabungan, String> {

    List<Tabungan> findAll();

    @Modifying
    @Query("update Tabungan tab set tab.saldo = (tab.saldo + ?1) where tab.id = ?2")
    int updateSaldoTabungan(BigDecimal saldo, String idTabungan);

    @Modifying
    @Query("update Tabungan tab set tab.saldo = (tab.saldo - ?1) where tab.id = ?2")
    int updateSaldoTabunganTarik(BigDecimal saldo, String idTabungan);
}
