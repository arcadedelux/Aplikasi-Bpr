/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.controller.wilayah;

import com.mycompany.bpr.entity.wilayah.KotaKabupaten;
import com.mycompany.bpr.service.WilayahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author bubun
 */
@Controller
@RequestMapping("/kota")
public class KotaController {

    @Autowired
    private WilayahService wilayahService;

    @GetMapping(value = {"/", "/list"})
    public String listHtml(ModelMap params) {
        params.addAttribute("listKota", wilayahService.findAllKotaKabupaten());
        return "/pages/wilayah/kota/list";
    }

    @GetMapping("/form")
    public String form(ModelMap modelMap, KotaKabupaten kota) {
        modelMap.addAttribute("listProvinsi", wilayahService.findAllProvinsi());
        modelMap.addAttribute("kotaKabupaten", kota);
        return "/pages/wilayah/kota/form";
    }

    @GetMapping("/form/{id}")
    public String formKotaByID(@PathVariable("id") String kodeKota, ModelMap params, RedirectAttributes redirectAttrs) {
        KotaKabupaten kotaKabupatenById = wilayahService.findKotaKabupatenById(kodeKota);
        if (kotaKabupatenById != null) {
            params.addAttribute("kotaKabupaten", kotaKabupatenById);
            params.addAttribute("listProvinsi", wilayahService.findAllProvinsi());
            return "/pages/wilayah/kota/form";
        } else {
            redirectAttrs.addFlashAttribute("notAvailabel", "Data Tidak ditemukan");
            return "redirect:/kota/list";
        }
    }

    @PostMapping("/submit")
    public String submitData(@Valid KotaKabupaten kota, BindingResult bindingResult, ModelMap params, RedirectAttributes redirectAttributes) {
        kota.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        kota.setCreatedBy("admin");

        if (bindingResult.hasErrors()) {
            params.addAttribute("listProvinsi", wilayahService.findAllProvinsi());
            return "/pages/wilayah/kota/form";
        }

        this.wilayahService.save(kota);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil di simpan!");
        return "redirect:/kota/list";
    }

    @GetMapping("/hapus/{kodeKota}")
    public String deleteData(@PathVariable("kodeKota") String kode, RedirectAttributes redirectAttributes) {
        this.wilayahService.deleteKotaKabupaten(kode);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil dihapus!");
        return "redirect:/kota/list";
    }
}
