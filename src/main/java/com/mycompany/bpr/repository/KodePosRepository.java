/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.repository;

import com.mycompany.bpr.entity.wilayah.KodePos;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author bubun
 */
public interface KodePosRepository extends CrudRepository<KodePos, String> {

    List<KodePos> findAll();

    KodePos findByKelurahanId(String kelurahanId);

    @Modifying
    @Query("update KodePos pos set pos.kodePos = ?1 where pos.id = ?2")
    int updateKodePos(Integer kodePos, String id);
}
