INSERT INTO master.agama (id, nama, deskripsi, created_date, created_by) VALUES
  ('001', 'Islam', NULL, now(), 'migration');

INSERT INTO nasabah.data_nasabah (
  tipe_nasabah, nasabah_id, nama_lengkap, alamat_identitas, nomor_identitas, jenis_kelamin,
  kodepos_identatitas, kodepos_domisili, pendidikan_terakhir, agama_id, alamat_domisili
) VALUES (
  'P',
  'robo',
  'Robo Merchan',
  'Jl.Bojongkenyod',
  '620423423433',
  'L',
  '001',
  NULL,
  's1',
  '001',
  NULL
);