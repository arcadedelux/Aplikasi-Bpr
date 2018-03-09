/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.service;

import com.mycompany.bpr.entity.wilayah.Kecamatan;
import com.mycompany.bpr.entity.wilayah.Kelurahan;
import com.mycompany.bpr.entity.wilayah.KodePos;
import com.mycompany.bpr.entity.wilayah.KotaKabupaten;
import com.mycompany.bpr.entity.wilayah.Provinsi;
import com.mycompany.bpr.repository.KecamatanRepository;
import com.mycompany.bpr.repository.KelurahanRepository;
import com.mycompany.bpr.repository.KodePosRepository;
import com.mycompany.bpr.repository.KotaKabupatenRepository;
import com.mycompany.bpr.repository.ProvinsiRepository;
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
public class WilayahService {

    @Autowired
    private KotaKabupatenRepository kotaRepository;
    @Autowired
    private ProvinsiRepository propRepository;
    @Autowired
    private KecamatanRepository kecamatanRepository;
    @Autowired
    private KelurahanRepository kelurahanRepository;
    @Autowired
    private KodePosRepository kodePosRepository;

    public List<Provinsi> findAllProvinsi() {
        return this.propRepository.findAll();
    }

    @Transactional
    public KotaKabupaten save(KotaKabupaten kota) {
        return this.kotaRepository.save(kota);
    }

    @Transactional
    public Provinsi save(Provinsi provinsi) {
        return this.propRepository.save(provinsi);
    }

    @Transactional
    public void deleteKotaKabupaten(String id) {
        this.kotaRepository.delete(id);
    }

    @Transactional
    public void deleteProvinsi(String id) {
        this.propRepository.delete(id);
    }

    public KotaKabupaten findKotaKabupatenById(String id) {
        return this.kotaRepository.findOne(id);
    }

    public List<KotaKabupaten> findAllKotaKabupaten() {
        return this.kotaRepository.findAll();
    }

    public Provinsi findProvinsiById(String id) {
        return this.propRepository.findOne(id);
    }

    public List<Kecamatan> findAllKecamatan() {
        return this.kecamatanRepository.findAll();
    }

    public Kecamatan findKecamatanById(String id) {
        return this.kecamatanRepository.findOne(id);
    }

    @Transactional
    public Kecamatan save(Kecamatan kecamatan) {
        return this.kecamatanRepository.save(kecamatan);
    }

    @Transactional
    public void deleteKecamatanById(String id) {
        this.kecamatanRepository.delete(id);
    }

    public List<Kelurahan> findAllKelurahan() {
        return this.kelurahanRepository.findAll();
    }

    @Transactional
    public Kelurahan save(Kelurahan kelurahan) {
        return this.kelurahanRepository.save(kelurahan);
    }

    public Kelurahan findKelurahanById(String id) {
        return this.kelurahanRepository.findOne(id);
    }

    public KodePos findKodePosByKelurahanId(String id) {
        return this.kodePosRepository.findByKelurahanId(id);
    }

    @Transactional
    public void deleteKelurahanById(String id) {
        KodePos kodePos = this.kodePosRepository.findByKelurahanId(id);
        if (kodePos != null)
            this.kodePosRepository.delete(kodePos);
        this.kelurahanRepository.delete(id);
    }

    public List<KodePos> findKodepos() {
        return this.kodePosRepository.findAll();
    }

    @Transactional
    public KodePos update(KodePos pos) {
        this.kodePosRepository.updateKodePos(pos.getKodePos(), pos.getId());
        Kelurahan kel = pos.getKelurahan();
        this.kelurahanRepository.updateNamaKelurahanAndKecamatanId(kel.getNama(), kel.getKecamatan().getId(), kel.getId());

        return pos;
    }

    @Transactional
    public KodePos save(KodePos pos) {
        Kelurahan kelurahanSave = this.kelurahanRepository.save(pos.getKelurahan());
        pos.setKelurahan(kelurahanSave);
        return this.kodePosRepository.save(pos);
    }
}
