/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.repository;

import com.mycompany.bpr.entity.wilayah.Provinsi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author bubun
 */
public interface ProvinsiRepository extends CrudRepository<Provinsi, String> {

     List<Provinsi> findAll();
}
