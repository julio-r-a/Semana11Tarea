package com.idat.semana11.controller;

import com.idat.semana11.dto.ProfesorDTO;
import com.idat.semana11.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/profesor/v1")
public class ProfesorController {

    @Autowired
    private ProfesorService service;

    @GetMapping("/listar")
    public @ResponseBody
    List<ProfesorDTO> listar(){
        return service.listar();
    }

    @GetMapping("/listar/{id}")
    public @ResponseBody ProfesorDTO obtenerId(@PathVariable Integer id){
        return  service.obtenerId(id);
    }

    @PostMapping("/guardar")
    public @ResponseBody void guardar(@RequestBody ProfesorDTO dto){
        service.guardar(dto);
    }

    @PutMapping("/actualizar")
    public @ResponseBody void actualizar (@RequestBody ProfesorDTO dto){
        service.actualizar(dto);
    }

    @DeleteMapping("/eliminar/{id}")
    public @ResponseBody void eliminar(@PathVariable Integer id){
        service.eliminar(id);
    }
}
