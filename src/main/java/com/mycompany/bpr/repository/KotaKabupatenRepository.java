/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.repository;

import com.mycompany.bpr.entity.wilayah.KotaKabupaten;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author bubun
 */
public interface KotaKabupatenRepository extends CrudRepository<KotaKabupaten, String> {
    List<KotaKabupaten> findAll();
}
