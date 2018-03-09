/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr;

import com.mycompany.bpr.service.NasabahService;
import com.mycompany.bpr.service.UserService;
import com.mycompany.bpr.service.PendidikanService;
import com.mycompany.bpr.service.AgamaService;
import com.mycompany.bpr.service.WilayahService;
import com.mycompany.bpr.entity.master.Agama;
import com.mycompany.bpr.entity.master.Pendidikan;
import com.mycompany.bpr.entity.nasabah.Nasabah;
import com.mycompany.bpr.entity.nasabah.NasabahBadanUsaha;
import com.mycompany.bpr.entity.nasabah.NasabahPerorangan;
import com.mycompany.bpr.entity.security.RoleSecurity;
import com.mycompany.bpr.entity.security.UserSecurity;
import com.mycompany.bpr.entity.wilayah.KotaKabupaten;
import com.mycompany.bpr.entity.wilayah.Provinsi;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author bubun
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AplikasiBprApplicationTests extends TestCase {

    @Autowired
    private AgamaService agamaService;
    @Autowired
    private PendidikanService pendidikanService;
    @Autowired
    private WilayahService wilayahService;
    @Autowired
    private UserService userService;
    @Autowired
    private NasabahService nasabahService;

    @Test
    public void contextLoads() {
    }

    @Ignore
    @Test
    public void testSimpanAgama() {
        Agama islam = new Agama(null, "Islam", "Muslim", Timestamp.valueOf(LocalDateTime.now()), "admin");
        agamaService.save(islam);

        Agama kristen = new Agama(null, "Kristen", "Kristen Protestan", Timestamp.valueOf(LocalDateTime.now()), "admin");
        agamaService.save(kristen);

        List<Agama> daftarAgama = agamaService.findAll();
        assertEquals(daftarAgama.size(), 2);

        islam = agamaService.findByNama("Islam");
        assertNotNull(islam);

        List<Agama> daftarAgamaByNamaOrDesk =
                agamaService.mencariBerdasarkanNamaAtauDeskripsi("Islam");
        assertEquals(daftarAgamaByNamaOrDesk.size(), 1);

        Agama islam2 = new Agama();
        islam2.setId(islam.getId());
        islam2.setNama("ISIS");
        islam2.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        agamaService.save(islam2);
        islam2 = agamaService.findById(islam.getId());

        agamaService.updateById(kristen.getId(), "Budha", "Chinese");
        kristen = agamaService.findById(kristen.getId());
        assertEquals(kristen.getNama(), "Budha");
        assertEquals(kristen.getDeskripsi(), "Chinese");

        assertEquals(islam2.getNama(), "ISIS");

        agamaService.deleteByName("i");

        agamaService.delete(daftarAgama);
        daftarAgama = agamaService.findAll();
        assertEquals(daftarAgama.size(), 0);
    }

    @Test
    public void testPendidikan() {
        List<Pendidikan> daftarPendidikan = pendidikanService.findAll();
        assertEquals(daftarPendidikan.size(), 3);
    }

    @Test
    public void testKotaProvinsi() {
        List<Provinsi> daftarWilayah = this.wilayahService.findAllProvinsi();
        assertEquals(3, daftarWilayah.size());

        Provinsi jawaBarat = this.wilayahService.findProvinsiById("001");
        assertNotNull(jawaBarat);
        assertEquals(1, jawaBarat.getListKota().size());

        List<KotaKabupaten> daftarKota = this.wilayahService.findAllKotaKabupaten();
        assertEquals(4, daftarKota.size());
    }

    @Test
    public void testUser() {

        List<RoleSecurity> roles = this.userService.listRole();
        assertEquals(2, roles.size());

        List<UserSecurity> users = this.userService.findUsers();
        assertEquals(2, users.size());

        UserSecurity admin = this.userService.findByUsername("admin");
        assertNotNull(admin);
        assertEquals(2, admin.getListRole().size());

        UserSecurity dimas = this.userService.findByUsername("arief");
        assertNotNull(dimas);
        assertEquals(1, dimas.getListRole().size());

    }

    @Test
    public void testNasabahPerorangan() {
        NasabahPerorangan nasabah = this.nasabahService.findPeroranganById("arief");
        assertNotNull(nasabah);
        assertEquals("Arief Setya", nasabah.getNamaLengkap());
        assertEquals("620423423433", nasabah.getNomorIdentitas());
        assertNull(nasabah.getDomisili());
        assertEquals("001", nasabah.getIdentitas().getId());
    }

    @Ignore
    @Test
    public void testSimpanNasabah() {
        NasabahPerorangan arief = new NasabahPerorangan();
        arief.setNamaLengkap("Arief Setya");
        arief.setJenisKelamin("L");
        arief.setNomorIdentitas("6212423408234");
        arief = this.nasabahService.save(arief);
        assertNotNull(arief.getId());

        arief = this.nasabahService.findPeroranganById(arief.getId());
        assertNotNull(arief);
        Nasabah coba = this.nasabahService.findBadanUsahaById(arief.getId());
        assertNull(coba);

        NasabahBadanUsaha mycompany = new NasabahBadanUsaha();
        mycompany.setNamaLengkap("Usaha Maju Jaya");
        mycompany.setNomorNpwp("1242421423");
//        mycompany.setAlamat("Jl. margawangi raya no 8");
        mycompany = this.nasabahService.save(mycompany);
        assertNotNull(mycompany.getId());
//        this.nasabahService.delete(mycompany);

    }

}
