/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.repository;

import com.mycompany.bpr.entity.transaksi.MutasiTabungan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author bubun
 */
public interface MutasiTabunganRepository extends CrudRepository<MutasiTabungan, String> {
    List<MutasiTabungan> findAll();
}
