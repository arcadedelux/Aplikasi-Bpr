-- drop tabel
DROP TABLE IF EXISTS master_kota_kabupaten;
DROP TABLE IF EXISTS master_provinsi;
-- recreate schema tabel wilayah
CREATE SCHEMA wilayah;
CREATE TABLE wilayah.provinsi (
  id           CHARACTER VARYING(64)  NOT NULL PRIMARY KEY,
  nama         CHARACTER VARYING(150) NOT NULL,
  created_date TIMESTAMP              NOT NULL,
  created_by   CHARACTER VARYING(20)
);
CREATE TABLE wilayah.kota_kabupaten (
  id           CHARACTER VARYING(64)  NOT NULL PRIMARY KEY,
  nama         CHARACTER VARYING(150) NOT NULL,
  created_date TIMESTAMP              NOT NULL,
  created_by   CHARACTER VARYING(20),
  provinsi_id  CHARACTER VARYING(64)  NOT NULL
);
ALTER TABLE wilayah.kota_kabupaten
  ADD CONSTRAINT fk_provinsi_kota FOREIGN KEY (provinsi_id) REFERENCES wilayah.provinsi (id)
ON UPDATE RESTRICT ON DELETE RESTRICT;
CREATE TABLE wilayah.kelurahan (
  id           CHARACTER VARYING(64)  NOT NULL PRIMARY KEY,
  nama         CHARACTER VARYING(150) NOT NULL,
  created_date TIMESTAMP              NOT NULL,
  created_by   CHARACTER VARYING(20),
  kota_id      CHARACTER VARYING(64)  NOT NULL
);
ALTER TABLE wilayah.kelurahan
  ADD CONSTRAINT fk_kota_kelurahan FOREIGN KEY (kota_id) REFERENCES wilayah.kota_kabupaten (id)
ON UPDATE RESTRICT ON DELETE RESTRICT;
CREATE TABLE wilayah.kecamatan (
  id           CHARACTER VARYING(64)  NOT NULL PRIMARY KEY,
  nama         CHARACTER VARYING(150) NOT NULL,
  created_date TIMESTAMP              NOT NULL,
  created_by   CHARACTER VARYING(20),
  kelurahan_id CHARACTER VARYING(64)  NOT NULL
);
ALTER TABLE wilayah.kecamatan
  ADD CONSTRAINT fk_kecamatan_kelurahan FOREIGN KEY (kelurahan_id) REFERENCES wilayah.kelurahan (id)
ON UPDATE RESTRICT ON DELETE RESTRICT;
-- inject data
INSERT INTO wilayah.provinsi
(id, nama, created_date, created_by)
VALUES
  ('001', 'Jawa Barat', now(), 'migration'),
  ('003', 'DKI Jakarta', now(), 'migration'),
  ('002', 'Jawa Timur', now(), 'migration');

INSERT INTO wilayah.kota_kabupaten (id, nama, created_date, created_by, provinsi_id)
VALUES
  ('001', 'Bandung', now(), 'migration', '001'),
  ('002', 'Jakarta Selatan', now(), 'migration', '003'),
  ('003', 'Jakarta Timur', now(), 'migration', '003'),
  ('004', 'Jakarta Pusat', now(), 'migration', '003'),
  ('005', 'Banten', now(), 'migration', '001');
INSERT INTO wilayah.kelurahan (id, nama, created_date, created_by, kota_id) VALUES
  ('001', 'Dago', now(), 'migration', '001'),
  ('002', 'Cihampelas', now(), 'migration', '001'),
  ('003', 'Mangga Dua', now(), 'migration', '002');
INSERT INTO wilayah.kecamatan (id, nama, created_date, created_by, kelurahan_id) VALUES
  ('001', 'Bojong Soang', now(), 'migration', '001'),
  ('002', 'Blok M', now(), 'migration', '003');



