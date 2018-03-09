/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.service;

import com.mycompany.bpr.entity.nasabah.Nasabah;
import com.mycompany.bpr.entity.nasabah.NasabahBadanUsaha;
import com.mycompany.bpr.entity.nasabah.NasabahPerorangan;
import com.mycompany.bpr.repository.NasabahBadanUsahaRepository;
import com.mycompany.bpr.repository.NasabahPeroranganRepository;
import com.mycompany.bpr.repository.NasabahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author bubun
 */
@Service
@Transactional(readOnly = true)
public class NasabahService {

    @Autowired
    private NasabahRepository nasabahRepository;
    @Autowired
    private NasabahPeroranganRepository peroranganRepository;
    @Autowired
    private NasabahBadanUsahaRepository badanUsahaRepository;


    public List<Nasabah> findAll(){
        return this.nasabahRepository.findAll();
    }

    @Transactional
    public NasabahPerorangan save(NasabahPerorangan nasabah) {
        return this.nasabahRepository.save(nasabah);
    }

    @Transactional
    public NasabahBadanUsaha save(NasabahBadanUsaha nasabah) {
        return this.nasabahRepository.save(nasabah);
    }

    @Transactional
    public void delete(Nasabah nasabah) {
        this.nasabahRepository.delete(nasabah);
    }

    public NasabahPerorangan findPeroranganById(String id) {
        return this.peroranganRepository.findOne(id);
    }

    public NasabahBadanUsaha findBadanUsahaById(String id) {
        return this.badanUsahaRepository.findOne(id);
    }

}
