DELETE FROM wilayah.kecamatan;
DELETE FROM wilayah.kelurahan;
DELETE FROM wilayah.kota_kabupaten;
DELETE FROM wilayah.provinsi;

-- drop contraint
ALTER TABLE wilayah.kecamatan
  DROP CONSTRAINT fk_kecamatan_kelurahan;
ALTER TABLE wilayah.kelurahan
  DROP CONSTRAINT fk_kota_kelurahan;

-- rename column
ALTER TABLE wilayah.kecamatan
  RENAME COLUMN kelurahan_id TO kota_id;
ALTER TABLE wilayah.kelurahan
  RENAME COLUMN kota_id TO kecamatan_id;

-- create contraint
ALTER TABLE wilayah.kecamatan
  ADD CONSTRAINT fk_kecamatan_kota_id FOREIGN KEY
  (kota_id) REFERENCES wilayah.kota_kabupaten (id)
ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE wilayah.kelurahan
  ADD CONSTRAINT fk_kelurahan_kecamatan FOREIGN KEY
  (kecamatan_id) REFERENCES wilayah.kelurahan (id)
ON UPDATE RESTRICT ON DELETE RESTRICT;


