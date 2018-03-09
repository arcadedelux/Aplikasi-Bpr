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

import javax.persistence.*;
import java.sql.Timestamp;

/**
 *
 * @author bubun
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kode_pos", schema = "wilayah")
public class KodePos {

    @Id
    @GenericGenerator(name = "uuid_kodepos", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_kodepos")
    @Column(name = "id", nullable = false, unique = true, length = 64)
    private String id;

    @Column(nullable = false, name = "kode_pos", length = 5)
    private Integer kodePos;

    @ManyToOne
    @JoinColumn(name = "kelurahan_id")
    private Kelurahan kelurahan;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @Column(name = "created_by", length = 20)
    private String createdBy;

}
