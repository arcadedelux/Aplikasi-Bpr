ALTER TABLE nasabah.data_nasabah
  RENAME COLUMN alamat_rumah TO alamat_identitas;
ALTER TABLE nasabah.data_nasabah
  ALTER COLUMN alamat_identitas TYPE TEXT;
ALTER TABLE nasabah.data_nasabah
  ADD COLUMN kodepos_identatitas CHARACTER VARYING(64) NOT NULL;
ALTER TABLE nasabah.data_nasabah
  ADD CONSTRAINT fk_nasabah_identitas FOREIGN KEY (kodepos_identatitas)
REFERENCES wilayah.kode_pos (id) ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE nasabah.data_nasabah
  ADD COLUMN kodepos_domisili CHARACTER VARYING(64);
ALTER TABLE nasabah.data_nasabah
  ADD CONSTRAINT fk_nasabah_domisili FOREIGN KEY (kodepos_domisili)
REFERENCES wilayah.kode_pos (id) ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE nasabah.data_nasabah
  ADD COLUMN pendidikan_terakhir CHARACTER VARYING(5);
ALTER TABLE nasabah.data_nasabah
  ADD CONSTRAINT fk_nasabah_pendidikan FOREIGN KEY (pendidikan_terakhir)
REFERENCES master.pendidikan (id) ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE nasabah.data_nasabah
  ADD COLUMN agama_id CHARACTER VARYING(64);
ALTER TABLE nasabah.data_nasabah
  ADD CONSTRAINT fk_nasabah_agama FOREIGN KEY (agama_id)
REFERENCES master.agama (id) ON UPDATE RESTRICT ON DELETE RESTRICT;
