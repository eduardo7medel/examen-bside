package com.medel.examen_practico.service;

import com.medel.examen_practico.dto.AlumnoDto;
import com.medel.examen_practico.dto.AlumnoUpdateDto;
import com.medel.examen_practico.dto.DeleteAlumnoRequest;
import com.medel.examen_practico.dto.GetAlumnoRequest;

import java.util.Collection;

public interface IAlumnoService {

    Collection<AlumnoDto> getAlumno(GetAlumnoRequest request);

    void deleteAlumno(DeleteAlumnoRequest request);

    AlumnoDto updateAlumno(AlumnoUpdateDto alumnoDto);

    Object insertAlumno(AlumnoDto alumnoDto);

}
