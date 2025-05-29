package com.crud.jpa.service;

import com.crud.jpa.model.Mascota;
import com.crud.jpa.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService implements IMascotaService{

    @Autowired
    private IMascotaRepository mascotaRepo;

    @Override
    public List<Mascota> getMascota() {

        List<Mascota> listaMascotas = mascotaRepo.findAll();
        return listaMascotas;
    }

    @Override
    public void saveMascota(Mascota mascot) {
        mascotaRepo.save(mascot);
    }

    @Override
    public void deleteMascota(Long id) {
        mascotaRepo.deleteById(id);
    }

    @Override
    public Mascota findMascota(Long id) {
        Mascota mascot = mascotaRepo.findById(id).orElse(null);
        return mascot;
    }

    @Override
    public void editMascota(Long idOriginal, Long id_MascotaNuevo, String nuevoNombre, String nuevaEspecie, String nuevaRaza, String nuevoColor) {
        //busco el objeto original
        Mascota mascot = this.findMascota(idOriginal);

        //proceso de modificacion a nivel logico
        mascot.setId_mascota(id_MascotaNuevo);
        mascot.setNombre(nuevoNombre);
        mascot.setEspecies(nuevaEspecie);
        mascot.setRaza(nuevaRaza);
        mascot.setColor(nuevoColor);

        //guardar los cambios
        this.saveMascota(mascot);
    }
}
