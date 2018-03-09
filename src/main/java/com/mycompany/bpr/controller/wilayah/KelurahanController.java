/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.controller.wilayah;

import com.mycompany.bpr.entity.wilayah.Kelurahan;
import com.mycompany.bpr.entity.wilayah.KodePos;
import com.mycompany.bpr.service.WilayahService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author bubun
 */
@Controller
@RequestMapping("/kelurahan")
public class KelurahanController {

    private final static Logger console = LoggerFactory.getLogger(KelurahanController.class);

    @Autowired
    private WilayahService wilayahService;

    @GetMapping(value = {"/", "/list"})
    public String listHtml(ModelMap params) {
        params.addAttribute("listKelurahan", wilayahService.findAllKelurahan());
        return "/pages/wilayah/kelurahan/list";
    }

    @GetMapping("/form")
    public String form(ModelMap modelMap, KodePos pos) {
        pos.setKelurahan(new Kelurahan());
        modelMap.addAttribute("listKecamatan", wilayahService.findAllKecamatan());
        modelMap.addAttribute("kodepos", pos);
        return "/pages/wilayah/kelurahan/form";
    }

    @GetMapping("/form/{id}")
    public String formKelurahanById(@PathVariable("id") String kodeKelurahan, ModelMap params, RedirectAttributes redirectAttrs) {
        KodePos kelurahanById = wilayahService.findKodePosByKelurahanId(kodeKelurahan);
        if (kelurahanById != null) {
            params.addAttribute("kodepos", kelurahanById);
            params.addAttribute("listKecamatan", wilayahService.findAllKecamatan());
            return "/pages/wilayah/kelurahan/form-updated";
        } else {
            redirectAttrs.addFlashAttribute("notAvailabel", "Data Tidak ditemukan");
            return "redirect:/kelurahan/list";
        }
    }

    @PostMapping("/submit")
    public String submit(
            @Valid @ModelAttribute KodePos pos,
            BindingResult bindingResult,
            ModelMap params,
            RedirectAttributes redirectAttributes) {
        pos.getKelurahan().setCreatedBy("admin");
        pos.getKelurahan().setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        pos.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        pos.setCreatedBy("admin");

        console.info("{}", pos, toString());
        if (bindingResult.hasErrors()) {
            params.addAttribute("listKecamatan", wilayahService.findAllKecamatan());
            return "/pages/wilayah/kelurahan/form";
        }

        this.wilayahService.save(pos);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil di simpan!");
        return "redirect:/kelurahan/list";
    }

    @PostMapping("/submit-edit")
    public String submitEdit(
            @Valid @ModelAttribute KodePos pos,
            BindingResult bindingResult,
            ModelMap params,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            params.addAttribute("listKecamatan", wilayahService.findAllKecamatan());
            return "/pages/wilayah/kelurahan/form";
        }

        this.wilayahService.update(pos);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil di simpan!");
        return "redirect:/kelurahan/list";
    }

    @GetMapping("/hapus/{kodeKelurahan}")
    public String deleteData(@PathVariable("kodeKelurahan") String kode, RedirectAttributes redirectAttributes) {
        this.wilayahService.deleteKelurahanById(kode);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil dihapus!");
        return "redirect:/kelurahan/list";
    }
}
