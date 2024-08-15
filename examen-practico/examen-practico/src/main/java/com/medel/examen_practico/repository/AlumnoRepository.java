package com.medel.examen_practico.repository;

import com.medel.examen_practico.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    @Query(value = "SELECT A FROM Alumno A WHERE A.nombre LIKE %:nombre%")
    List<Alumno> findByNombre(String nombre);

}
