/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.service;

import com.mycompany.bpr.entity.aplikasi.Tabungan;
import com.mycompany.bpr.entity.master.kriteria.ProdukTabungan;
import com.mycompany.bpr.entity.transaksi.MutasiTabungan;
import com.mycompany.bpr.repository.AplikasiTabunganRepository;
import com.mycompany.bpr.repository.MutasiTabunganRepository;
import com.mycompany.bpr.repository.ProdukTabunganRepository;
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
public class TabunganService {

    @Autowired
    private AplikasiTabunganRepository tabunganRepository;
    @Autowired
    private ProdukTabunganRepository kriteriaRepository;
    @Autowired
    private MutasiTabunganRepository mutasiRepository;

    public Tabungan findById(String id) {
        return this.tabunganRepository.findOne(id);
    }

    public List<Tabungan> findAll() {
        return this.tabunganRepository.findAll();
    }

    public List<ProdukTabungan> findKriteriaProduk() {
        return this.kriteriaRepository.findAll();
    }

    @Transactional
    public Tabungan save(MutasiTabungan mutasi) {
        Tabungan tabungan = mutasi.getTabungan();
        tabungan = this.tabunganRepository.save(tabungan);
        mutasi.setTabungan(tabungan);
        this.mutasiRepository.save(mutasi);
        this.tabunganRepository.updateSaldoTabungan(mutasi.getCredit(), tabungan.getId());
        return tabungan;
    }


    @Transactional
    public MutasiTabungan setoran(MutasiTabungan mutasi) {
        this.mutasiRepository.save(mutasi);
        this.tabunganRepository.updateSaldoTabungan(mutasi.getCredit(), mutasi.getTabungan().getId());
        return mutasi;
    }

    @Transactional
    public MutasiTabungan tarikan(MutasiTabungan mutasi) {
        this.mutasiRepository.save(mutasi);
        this.tabunganRepository.updateSaldoTabunganTarik(mutasi.getDebet(), mutasi.getTabungan().getId());
        return mutasi;
    }
}
