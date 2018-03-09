/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.entity.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 *
 * @author bubun
 */
@Entity
@Table(name = "agama", schema = "master")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agama {

    @Id
    @GenericGenerator(name = "agama_id", strategy = "uuid2")
    @GeneratedValue(generator = "agama_id")
    @Column(name = "id", length = 64, nullable = false, unique = true)
    private String id;

    @NotEmpty
    @NotNull
    @Size(min = 5, max = 49, message = "Jumlah karakter tidak boleh lebih dari 5 sampe 49 karakter")
    @Column(name = "nama", nullable = false, unique = true, length = 50)
    private String nama;

    @Column(name = "deskripsi")
    private String deskripsi;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;
    @Column(name = "created_by", length = 50)
    private String createdBy;

}
