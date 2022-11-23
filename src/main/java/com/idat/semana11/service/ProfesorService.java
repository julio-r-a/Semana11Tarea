package com.idat.semana11.service;

import com.idat.semana11.dto.ProfesorDTO;

import java.util.List;

public interface ProfesorService {

    List<ProfesorDTO> listar();
    ProfesorDTO obtenerId(Integer id);
    void guardar(ProfesorDTO profesor);
    void eliminar(Integer id);
    void actualizar(ProfesorDTO profesor);
}
