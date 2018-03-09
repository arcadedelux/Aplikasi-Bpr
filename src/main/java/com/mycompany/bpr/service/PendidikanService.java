/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.service;

import com.mycompany.bpr.entity.master.Pendidikan;
import com.mycompany.bpr.repository.PendidikanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author bubun
 */
@Repository
@Transactional(readOnly = true)
public class PendidikanService {


    @Autowired
    private PendidikanRepository repo;

    @Transactional(readOnly = false)
    public Pendidikan save(Pendidikan p){
        return  this.repo.save(p);
    }

    public Pendidikan findById(String id){
        return  this.repo.findOne(id);
    }

    public List<Pendidikan> findAll(){
        return this.repo.findAll();
    }

    public void delete(Pendidikan p){
        this.repo.delete(p);
    }

    public void delete(String id){
        this.repo.delete(id);
    }

    public void delete(List<Pendidikan> list){
        this.repo.delete(list);
    }


}
