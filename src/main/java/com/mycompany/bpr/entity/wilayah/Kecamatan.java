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
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bubun
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kecamatan", schema = "wilayah")
@Data
@ToString(exclude = "listKelurahan")
public class Kecamatan {

    @Id
    @GenericGenerator(name = "uuid_kelurahan", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_kelurahan")
    @Column(name = "id", nullable = false, unique = true, length = 64)
    private String id;
    @NotEmpty(message = "Tidak boleh kosong")
    @Size(message = "Tidak boleh lebih dari 150", max = 150)
    @Column(nullable = false, length = 150)
    private String nama;
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;
    @Column(name = "created_by", length = 20)
    private String createdBy;
    @NotNull(message = "Kota / Kabupaten tidak boleh kosong!")
    @ManyToOne
    @JoinColumn(name = "kota_id", nullable = false)
    private KotaKabupaten kota;
    @OneToMany(mappedBy = "kecamatan")
    private List<Kelurahan> listKelurahan = new ArrayList<>();

}
