/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.repository;

import com.mycompany.bpr.entity.nasabah.NasabahPerorangan;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author bubun
 */
public interface NasabahPeroranganRepository extends CrudRepository<NasabahPerorangan, String> {
      List<NasabahPerorangan> findAll();
}
