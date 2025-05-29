package com.crud.jpa.service;

import com.crud.jpa.model.Persona;
import com.crud.jpa.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonaService {

    //METODO PARA TRAER TODAS LAS PERSONAS
    //LECTURA
    public List<Persona> getPersonas();

    //ALTA
    public void savePersona(Persona perso);

    //BAJA
    public void deletePersona(Long id);

    //LECTURA DE UN SOLO OBJETO
    public Persona findPersona(Long id);

    //MODIFICACION
    public void editPersona(Long idOriginal, Long idNueva,
                            String nuevoNombre,
                            String nuevoApellido,
                            int nuevaEdad);
}
//prueba
