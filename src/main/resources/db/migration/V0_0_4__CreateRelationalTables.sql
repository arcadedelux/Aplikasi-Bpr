create table master_provinsi(
  kode_provinsi CHARACTER VARYING(255) not null unique primary key,
  nama_provinsi CHARACTER VARYING(50) not null,
  created_date TIMESTAMP not null,
  created_by CHARACTER VARYING(20)
);

create table master_kota_kabupaten(
  kode_kota CHARACTER VARYING(255) not null UNIQUE  primary key,
  nama_kota CHARACTER VARYING(50) not null,
  created_date TIMESTAMP not null,
  created_by CHARACTER VARYING(20),
  provinsi_id CHARACTER VARYING(255) not null REFERENCES master_provinsi(kode_provinsi)
)