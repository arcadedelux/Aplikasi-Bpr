/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.repository;

import com.mycompany.bpr.entity.wilayah.Kelurahan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author bubun
 */
public interface KelurahanRepository extends CrudRepository<Kelurahan, String> {

    List<Kelurahan> findAll();

    @Modifying
    @Query("update Kelurahan kel set kel.nama = ?1, kel.kecamatan.id = ?2 where kel.id = ?3")
    int updateNamaKelurahanAndKecamatanId(String namaKelurahan, String kecamatanId, String kelurahanId);
}
