/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.entity.nasabah;

import com.mycompany.bpr.entity.master.Agama;
import com.mycompany.bpr.entity.master.Pendidikan;
import com.mycompany.bpr.entity.wilayah.KodePos;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 *
 * @author bubun
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@DiscriminatorValue(value = "P")
public class NasabahPerorangan extends Nasabah {

    @Column(name = "nomor_identitas", length = 64)
    private String nomorIdentitas;

    @Column(name = "jenis_kelamin", length = 1)
    private String jenisKelamin;

    @OneToOne
    @JoinColumn(name = "agama_id")
    private Agama agama;

    @Column(name = "alamat_domisili")
    private String alamatDomisili;

    @OneToOne
    @JoinColumn(name = "kodepos_domisili")
    private KodePos domisili;

    @OneToOne
    @JoinColumn(name = "pendidikan_terakhir")
    private Pendidikan pendidikanTerakhir;
}
