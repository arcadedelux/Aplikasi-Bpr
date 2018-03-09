/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.entity.master.kriteria;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 *
 * @author bubun
 */
@Data
@Entity
@Table(name = "kriteria_tabungan", schema = "master")
public class ProdukTabungan {

    @Id
    @GenericGenerator(name = "uuid_kriteri_tabungan", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_kriteri_tabungan")
    @Column(nullable = false, unique = true, length = 64)
    private String id;

    @Column(nullable = false, unique = true, length = 50)
    private String kode;

    @Column(nullable = false, length = 150)
    private String nama;

    @Column(name = "suku_bunga", nullable = false, scale = 2, length = 3)
    private Double sukuBunga;

    @Column(name = "setoran_awal", nullable = false)
    private BigDecimal setoranAwal;

    @Column(name = "biaya_administrasi", nullable = false)
    private BigDecimal biayaAdministrasi;

    @Column(name = "is_active", nullable = false)
    private boolean active;

}
