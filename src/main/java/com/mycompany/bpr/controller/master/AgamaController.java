/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr.controller.master;

import com.mycompany.bpr.entity.master.Agama;
import com.mycompany.bpr.service.AgamaService;
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
@RequestMapping("/agama")
public class AgamaController {

    private final Logger console = LoggerFactory.getLogger(AgamaController.class);

    @Autowired
    private AgamaService agamaService;

    /**
     * localhost:8080/agama/ atau localhost:8080/agama/list
     *
     * @return
     */
    @GetMapping(value = {"/", "/list"})
    public String listAgama(ModelMap params) {
        params.addAttribute("listAgama", agamaService.findAll());
        return "/pages/agama/list";
    }

    @GetMapping("/form")
    public String formAgama(Agama agama, ModelMap params) {
        params.addAttribute("agama", agama);
        return "/pages/agama/form";
    }

    @GetMapping("/form/{id}")
    public String formAgamaById(@PathVariable("id") String kodeAgama, ModelMap params, RedirectAttributes redirectAttrs) {
        Agama agama = agamaService.findById(kodeAgama);
        if (agama != null) {
            params.addAttribute("agama", agama);
            return "/pages/agama/form";
        } else {
            redirectAttrs.addFlashAttribute("notAvailabel", "Data Tidak ditemukan");
            return "redirect:/agama/list";
        }
    }

    @PostMapping("/submit")
    public String submitAgama(@Valid @ModelAttribute Agama agama,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        agama.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        agama.setCreatedBy("admin");

        if (bindingResult.hasErrors()) {
            return "pages/agama/form";
        }

        agamaService.save(agama);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil disimpan");
        return "redirect:/agama/list";

    }

    @GetMapping("/hapus/{id}")
    public String removeAgamaById(@PathVariable("id") String kodeAgama) {
        agamaService.delete(kodeAgama);
        return "redirect:/agama/list";
    }
}
