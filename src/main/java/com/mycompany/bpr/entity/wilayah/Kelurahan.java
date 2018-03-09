/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.entity.wilayah;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 *
 * @author bubun
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kelurahan", schema = "wilayah")
@Data
public class Kelurahan {

    @Id
    @GenericGenerator(name = "uuid_kelurahan", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_kelurahan")
    @Column(name = "id", nullable = false, unique = true, length = 64)
    private String id;
    @Column(nullable = false, length = 150)
    @NotEmpty(message = "Nama tidak boleh kosong!")
    private String nama;
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;
    @Column(name = "created_by", length = 20)
    private String createdBy;
    @NotNull(message = "Kecamatan belum dipilih!")
    @ManyToOne
    @JoinColumn(name = "kecamatan_id", nullable = false)
    private Kecamatan kecamatan;

}
