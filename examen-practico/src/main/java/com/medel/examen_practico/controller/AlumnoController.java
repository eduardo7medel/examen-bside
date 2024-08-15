package com.medel.examen_practico.controller;

import com.medel.examen_practico.dto.AlumnoDto;
import com.medel.examen_practico.dto.AlumnoUpdateDto;
import com.medel.examen_practico.dto.DeleteAlumnoRequest;
import com.medel.examen_practico.dto.GetAlumnoRequest;
import com.medel.examen_practico.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;

    @GetMapping(value = "getAlumno")
    public @ResponseBody Collection<AlumnoDto> getAlumno(@Validated @RequestBody GetAlumnoRequest request){
        return alumnoService.getAlumno(request);
    }

    @DeleteMapping(value = "eliminarAlumno")
    public void deleteAlumno(@RequestBody DeleteAlumnoRequest request){
        alumnoService.deleteAlumno(request);
    }

    @PutMapping(value = "actualizarAlumno")
    public @ResponseBody AlumnoDto updateAlumno(@RequestBody AlumnoUpdateDto alumnoDto){
        return alumnoService.updateAlumno(alumnoDto);
    }

    @PostMapping(value = "insertarAlumno")
    public @ResponseBody Object insertAlumno(@RequestBody AlumnoDto alumnoDto){
        return alumnoService.insertAlumno(alumnoDto);
    }

}
