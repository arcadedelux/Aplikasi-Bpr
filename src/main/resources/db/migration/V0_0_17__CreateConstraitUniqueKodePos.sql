ALTER TABLE wilayah.kode_pos
  ADD CONSTRAINT uq_kodepos_kelurahan UNIQUE (kode_pos, kelurahan_id);