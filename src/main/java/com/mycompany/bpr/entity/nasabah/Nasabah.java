/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.entity.nasabah;

import com.mycompany.bpr.entity.wilayah.KodePos;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 *
 * @author bubun
 */
@Data
@Entity
@Table(name = "data_nasabah", schema = "nasabah")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipe_nasabah", discriminatorType = DiscriminatorType.STRING, length = 50)
public class Nasabah {

    @Id
    @GenericGenerator(name = "nasabah_uuid", strategy = "uuid2")
    @Column(name = "nasabah_id", nullable = false, unique = true, length = 64)
    @GeneratedValue(generator = "nasabah_uuid")
    private String id;

    @Column(name = "nama_lengkap", nullable = false, length = 50)
    private String namaLengkap;

    @Column(name = "alamat_identitas")
    private String alamatIdentitas;

    @OneToOne
    @JoinColumn(name = "kodepos_identatitas")
    private KodePos identitas;
}
