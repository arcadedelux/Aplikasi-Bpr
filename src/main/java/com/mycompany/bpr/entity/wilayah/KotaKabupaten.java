/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.entity.wilayah;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bubun
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kota_kabupaten", schema = "wilayah")
@ToString(exclude = "listKecamatan")
public class KotaKabupaten {

    @Id
    @GenericGenerator(name = "uuid_kotakab", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_kotakab")
    @Column(name = "id", nullable = false, unique = true, length = 64)
    private String id;
    @NotEmpty(message = "Tidak boleh kosong")
    @Column(name = "nama", nullable = false, length = 150)
    private String nama;
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;
    @Column(name = "created_by", length = 20)
    private String createdBy;
    @NotNull(message = "belum dipilih!")
    @ManyToOne
    @JoinColumn(name = "provinsi_id", nullable = false)
    private Provinsi provinsi;
    @OneToMany(mappedBy = "kota")
    private List<Kecamatan> listKecamatan = new ArrayList<>();
}
