/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.entity.aplikasi;

import com.mycompany.bpr.entity.master.kriteria.ProdukTabungan;
import com.mycompany.bpr.entity.nasabah.Nasabah;
import com.mycompany.bpr.entity.transaksi.MutasiTabungan;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bubun
 */
@Data
@Entity
@Table(name = "tabungan", schema = "aplikasi")
public class Tabungan {

    @Id
    @GenericGenerator(strategy = "uuid2", name = "uuid_tabungan")
    @GeneratedValue(generator = "uuid_tabungan")
    @Column(name = "id", nullable = false, unique = true, length = 64)
    private String id;

    @NotEmpty
    @Size(max = 15, min = 15, message = "nomor rekening harus 15 karaketer")
    @Column(name = "nomor_rekening", nullable = false, unique = true, length = 15)
    private String nomorRekening;

    @NotNull(message = "nasabah belum dipilih")
    @OneToOne
    @JoinColumn(name = "nasabah_id", nullable = false)
    private Nasabah nasabah;

    @Column(name = "tanggal_opening", nullable = false)
    private Date opening;

    @Column(nullable = false)
    private BigDecimal saldo;

    @NotNull(message = "kriteria produk belum dipilih")
    @OneToOne
    @JoinColumn(name = "kriteria_id", nullable = false)
    private ProdukTabungan kriteriaProduk;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @OneToMany(mappedBy = "tabungan")
    private List<MutasiTabungan> listMutasi = new ArrayList<>();

}
