package com.crud.jpa.service;

import com.crud.jpa.model.Mascota;
import com.crud.jpa.model.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMascotaService {

    //METODO PARA TRAER TODAS LAS PERSONAS
    //LECTURA
    public List<Mascota> getMascota();

    //ALTA
    public void saveMascota(Mascota masco);

    //BAJA
    public void deleteMascota(Long id);

    //LECTURA DE UN SOLO OBJETO
    public Mascota findMascota(Long id);

    //MODIFICACION
    public void editMascota(Long idOriginal, Long id_MascotaNuevo,
                            String nuevoNombre,
                            String nuevaEspecie,
                            String nuevaRaza,
                            String nuevoColor);
}
