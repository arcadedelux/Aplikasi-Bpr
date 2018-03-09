CREATE TABLE wilayah.kode_pos (
  id           CHARACTER VARYING(64) NOT NULL PRIMARY KEY,
  kode_pos     NUMERIC(5)            NOT NULL,
  kecamatan_id CHARACTER VARYING(64),
  kelurahan_id CHARACTER VARYING(64)
);

ALTER TABLE wilayah.kode_pos
  ADD CONSTRAINT fk_kodepost_kecamatan FOREIGN KEY
  (kecamatan_id) REFERENCES wilayah.kecamatan (id)
ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE wilayah.kode_pos
  ADD CONSTRAINT fk_kodepost_kelurahan FOREIGN KEY
  (kelurahan_id) REFERENCES wilayah.kelurahan (id)
ON UPDATE RESTRICT ON DELETE RESTRICT;