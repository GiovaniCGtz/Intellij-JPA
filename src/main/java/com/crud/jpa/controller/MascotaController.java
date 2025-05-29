package com.crud.jpa.controller;

import com.crud.jpa.model.Mascota;
import com.crud.jpa.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MascotaController {

    @Autowired
    private IMascotaService mascotService;

    //endpoints
    @GetMapping("/mascotas/traer")
    public List<Mascota> getMascotas(){
        return mascotService.getMascota();
    }

    @PostMapping("/mascotas/crear")
    public String saveMascota(@RequestBody Mascota mascot){
        mascotService.saveMascota(mascot);

        return "La mascota fue creada correctamente";
    }

    @DeleteMapping("/mascotas/borrar/{id}")
    public String deleteMascota(@PathVariable Long id){
        mascotService.deleteMascota(id);

        return "La mascota fue eliminada correctamete";
    }

    @PutMapping("/personas/editar{id_original}")
    public Mascota editMascota(@PathVariable Long id_original,
                               @RequestParam (required = false, name = "id") Long id_MascotaNuevo,
                               @RequestParam (required = false, name = "nombre") String nuevoNombre,
                               @RequestParam (required = false, name = "especie") String nuevaEspecie,
                               @RequestParam (required = false, name = "raza") String nuevaRaza,
                               @RequestParam (required = false, name = "color") String nuevoColor){

        mascotService.editMascota(id_original,id_MascotaNuevo,nuevoNombre,nuevaEspecie,nuevaRaza,nuevoColor);

        Mascota mascot = mascotService.findMascota(id_MascotaNuevo);

        return mascot;

    }
}
