package com.crud.jpa.controller;

import com.crud.jpa.model.Persona;
import com.crud.jpa.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class PersonaController {

    @Autowired
    private IPersonaService persoServ;

    //endpoints
    @GetMapping("/personas/traer")
    public List<Persona> getPersonas() {
        return persoServ.getPersonas();
    }

    @PostMapping("/personas/crear")
    public String savePersona(@RequestBody Persona perso) {
        persoServ.savePersona(perso);

        return "La persona fue creada correctamente";
    }

    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        persoServ.deletePersona(id);

        return "La persona fue eliminada correctamente";
    }

    @PutMapping("/personas/editar/{id_original}")
    public Persona editPersona(@PathVariable Long id_original,
                               @RequestParam (required = false, name = "id") Long idnueva,
                               @RequestParam (required = false, name = "nombre") String nuevoNombre,
                               @RequestParam (required = false, name = "apellido") String nuevoApellido,
                               @RequestParam (required = false, name = "edad") int nuevaEdad) {

        persoServ.editPersona(id_original,idnueva,nuevoNombre,nuevoApellido,nuevaEdad);

        Persona perso = persoServ.findPersona(idnueva);

        return perso;
    }
}
