INSERT INTO wilayah.provinsi
(id, nama, created_date, created_by)
VALUES
  ('001', 'Jawa Barat', now(), 'migration'),
  ('003', 'DKI Jakarta', now(), 'migration'),
  ('002', 'Jawa Timur', now(), 'migration');
INSERT INTO wilayah.kota_kabupaten (id, nama, created_date, created_by, provinsi_id)
VALUES
  ('001', 'Bandung', now(), 'migration', '001'),
  ('002', 'Kota Jakarta Selatan', now(), 'migration', '003'),
  ('003', 'Kota Jakarta Timur', now(), 'migration', '003'),
  ('004', 'Kota Jakarta Pusat', now(), 'migration', '003');
INSERT INTO wilayah.kecamatan (id, nama, created_date, created_by, kota_id) VALUES
  ('001', 'Panghegar', now(), 'migration', '001'),
  ('002', 'Cileunyi', now(), 'migration', '001'),
  ('003', 'Kebayoran Baru', now(), 'migration', '002');
INSERT INTO wilayah.kelurahan (id, nama, created_date, created_by, kecamatan_id) VALUES
  ('001', 'Permata Hijau', now(), 'migration', '001'),
  ('002', 'Cibiru', now(), 'migration', '001'),
  ('003', 'Pondok Indah', now(), 'migration', '003');
