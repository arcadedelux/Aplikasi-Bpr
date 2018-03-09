ALTER TABLE wilayah.kelurahan
  DROP CONSTRAINT fk_kelurahan_kecamatan;
ALTER TABLE wilayah.kelurahan
  ADD CONSTRAINT fk_kelurahan_kecamatan FOREIGN KEY
  (kecamatan_id) REFERENCES wilayah.kecamatan (id);