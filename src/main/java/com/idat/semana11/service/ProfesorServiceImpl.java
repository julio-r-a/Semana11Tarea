package com.idat.semana11.service;

import com.idat.semana11.dto.ProfesorDTO;
import com.idat.semana11.model.Profesor;
import com.idat.semana11.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository repository;

    @Override
    public List<ProfesorDTO> listar() {
        List<ProfesorDTO> listadto = new ArrayList<>();
        ProfesorDTO dto = null;

        for (Profesor profesor : repository.findAll()) {
            dto = new ProfesorDTO();
            dto.setCod(profesor.getIdProfesor());
            dto.setNom(profesor.getNombre());
            dto.setApe(profesor.getApellido());
            dto.setEd(profesor.getEdad());
            listadto.add(dto);
        }
        return listadto;
    }

    @Override
    public ProfesorDTO obtenerId(Integer id) {
        Profesor profesor = repository.findById(id).orElse(null);

        ProfesorDTO dto = new ProfesorDTO();
        dto.setCod(profesor.getIdProfesor());
        dto.setNom(profesor.getNombre());
        dto.setApe(profesor.getApellido());
        dto.setEd(profesor.getEdad());

        return dto;
    }

    @Override
    public void guardar(ProfesorDTO profesor) {
        Profesor pro = new Profesor();
        pro.setIdProfesor(profesor.getCod());
        pro.setNombre(profesor.getNom());
        pro.setApellido(profesor.getApe());
        pro.setEdad(profesor.getEd());

        repository.save(pro);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void actualizar(ProfesorDTO profesor) {

        Profesor pro = new Profesor();
        pro.setIdProfesor(profesor.getCod());
        pro.setNombre(profesor.getNom());
        pro.setApellido(profesor.getApe());
        pro.setEdad(profesor.getEd());

        repository.saveAndFlush(pro);
    }
}
