ALTER TABLE wilayah.kode_pos
  ADD COLUMN created_date TIMESTAMP DEFAULT now() NOT NULL;
ALTER TABLE wilayah.kode_pos
  ADD COLUMN created_by CHARACTER VARYING(20) DEFAULT NULL;