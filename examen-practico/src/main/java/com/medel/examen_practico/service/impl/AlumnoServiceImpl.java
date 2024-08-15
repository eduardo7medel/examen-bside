package com.medel.examen_practico.service.impl;

import com.medel.examen_practico.dto.AlumnoDto;
import com.medel.examen_practico.dto.AlumnoUpdateDto;
import com.medel.examen_practico.dto.DeleteAlumnoRequest;
import com.medel.examen_practico.dto.GetAlumnoRequest;
import com.medel.examen_practico.entity.Alumno;
import com.medel.examen_practico.repository.AlumnoRepository;
import com.medel.examen_practico.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public Collection<AlumnoDto> getAlumno(GetAlumnoRequest request){
        List<Alumno> alumno = alumnoRepository.findByNombre(request.getNombre());
        Collection<AlumnoDto> result = new ArrayList<AlumnoDto>();
        alumno.stream().forEach( (x) ->
            result.add(AlumnoDto.builder()
                    .matricula(x.getMatricula())
                    .nombre(x.getNombre())
                    .apellido(x.getApellido())
                    .fechaNacimiento(x.getFechaNacimiento())
                    .email(x.getEmail())
                    .telefono(x.getTelefono())
                    .direccion(x.getDireccion())
                    .fechaInscripcion(x.getFechaInscripcion())
                    .build())
        );
        return result;
    }

    @Override
    public void deleteAlumno(DeleteAlumnoRequest request) {
        alumnoRepository.deleteById(request.getMatricula());
    }

    @Override
    public AlumnoDto updateAlumno(AlumnoUpdateDto alumnoDto) {
        Optional<Alumno> alumno = alumnoRepository.findById(alumnoDto.getMatricula());
        if(alumno.isPresent()){
            alumno.get().setNombre( (alumnoDto.getNombre() != null && !alumnoDto.getNombre().isEmpty()) ? alumnoDto.getNombre() : alumno.get().getNombre());
            alumno.get().setApellido( (alumnoDto.getApellido() != null && !alumnoDto.getApellido().isEmpty()) ? alumnoDto.getApellido() : alumno.get().getApellido());
            alumno.get().setFechaNacimiento( (alumnoDto.getFechaNacimiento() != null) ? alumnoDto.getFechaNacimiento() : alumno.get().getFechaNacimiento());
            alumno.get().setEmail( (alumnoDto.getEmail() != null && !alumnoDto.getEmail().isEmpty()) ? alumnoDto.getEmail() : alumno.get().getEmail());
            alumno.get().setTelefono( (alumnoDto.getTelefono() != null && !alumnoDto.getTelefono().isEmpty()) ? alumnoDto.getTelefono() : alumno.get().getTelefono());
            alumno.get().setDireccion( (alumnoDto.getDireccion() != null && !alumnoDto.getDireccion().isEmpty()) ? alumnoDto.getDireccion() : alumno.get().getDireccion());
            alumno.get().setFechaInscripcion( (alumnoDto.getFechaInscripcion() != null) ? alumnoDto.getFechaInscripcion() : alumno.get().getFechaInscripcion());

            Alumno alumnoresult= alumnoRepository.save(alumno.get());
            return AlumnoDto.builder()
                    .matricula(alumnoresult.getMatricula())
                    .nombre(alumnoresult.getNombre())
                    .apellido(alumnoresult.getApellido())
                    .fechaNacimiento(alumnoresult.getFechaNacimiento())
                    .email(alumnoresult.getEmail())
                    .telefono(alumnoresult.getTelefono())
                    .direccion(alumnoresult.getDireccion())
                    .fechaInscripcion(alumnoresult.getFechaInscripcion())
                    .build();
        }
        return null;
    }

    @Override
    public Object insertAlumno(AlumnoDto alumnoDto) {
        return alumnoRepository.save(
                Alumno.builder()
                        .nombre(alumnoDto.getNombre())
                        .apellido(alumnoDto.getApellido())
                        .fechaNacimiento(alumnoDto.getFechaNacimiento())
                        .email(alumnoDto.getEmail())
                        .telefono(alumnoDto.getTelefono())
                        .direccion(alumnoDto.getDireccion())
                        .fechaInscripcion(alumnoDto.getFechaInscripcion())
                .build()
        );
    }

}
