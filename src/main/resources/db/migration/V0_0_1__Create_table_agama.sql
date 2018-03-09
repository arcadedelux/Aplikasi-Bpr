/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  bubun
 * Created: Feb 24, 2018
 */

CREATE TABLE master_agama (
  kode_agama   CHARACTER VARYING(255) NOT NULL PRIMARY KEY,
  nama_agama   CHARACTER VARYING(50)  NOT NULL UNIQUE,
  deskripsi    CHARACTER VARYING(255),
  created_date TIMESTAMP              NOT NULL,
  created_by   CHARACTER VARYING(50)
);