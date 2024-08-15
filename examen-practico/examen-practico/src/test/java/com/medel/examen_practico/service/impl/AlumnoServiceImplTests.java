package com.medel.examen_practico.service.impl;

import com.medel.examen_practico.dto.AlumnoDto;
import com.medel.examen_practico.dto.AlumnoUpdateDto;
import com.medel.examen_practico.dto.DeleteAlumnoRequest;
import com.medel.examen_practico.dto.GetAlumnoRequest;
import com.medel.examen_practico.entity.Alumno;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AlumnoServiceImplTests {

    @Autowired
    private AlumnoServiceImpl service;

    EasyRandom easyRamdon = new EasyRandom();


    @Test
    public void getAlumno (){
        Collection<AlumnoDto> collection =service.getAlumno(easyRamdon.nextObject(GetAlumnoRequest.class));
        assertNotNull(collection);
    }

    @Test
    public void deleteAlumno(){
        service.deleteAlumno(easyRamdon.nextObject(DeleteAlumnoRequest.class));
    }

    @Test
    public void updateAlumno(){
        service.updateAlumno(easyRamdon.nextObject(AlumnoUpdateDto.class));
    }

    @Test
    public void insertAlumno(){
        service.insertAlumno(easyRamdon.nextObject(AlumnoDto.class));
    }
}
