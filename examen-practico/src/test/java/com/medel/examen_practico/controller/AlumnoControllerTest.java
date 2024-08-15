package com.medel.examen_practico.controller;

import com.medel.examen_practico.dto.AlumnoDto;
import com.medel.examen_practico.dto.GetAlumnoRequest;
import com.medel.examen_practico.service.IAlumnoService;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(AlumnoController.class)
public class AlumnoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IAlumnoService alumnoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAlumno() throws Exception {

        given(alumnoService.getAlumno(new GetAlumnoRequest("o"))).willReturn(new ArrayList<>());
        String json = "{\n" +
                "    \"nombre\":\"o\"\n" +
                "}";

        mockMvc.perform(get("/getAlumno")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"))
        ;
    }

    @Test
    void testDeleteAlumno() throws Exception {

        doNothing().when(alumnoService).deleteAlumno(any());
        String json = "{\"matricula\":\"2\"}";

        mockMvc.perform(delete("/eliminarAlumno")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk())
        ;
    }

    @Test
    void testUpdateAlumno() throws Exception {

        given(alumnoService.updateAlumno(any())).willReturn(new EasyRandom().nextObject(AlumnoDto.class));
        String json = "{ " +
                "\"matricula\" : 1, \"nombre\" : \"Antonio\", \"apellido\": \"Medel\", " +
                "\"email\": \"eduardo@correo.com\", \"telefono\": \"1234567890\", \"direccion\": \"direccion\", " +
                "\"fechaInscripcion\" : \"2024-08-15\"}";

        mockMvc.perform(put("/actualizarAlumno")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk())
        ;
    }

    @Test
    void testInsertAlumno() throws Exception {

        given(alumnoService.insertAlumno(any())).willReturn(new EasyRandom().nextObject(AlumnoDto.class));
        String json = "{ " +
                "\"nombre\" : \"Antonio\", \"apellido\": \"Medel\", " +
                "\"email\": \"eduardo@correo.com\", \"telefono\": \"1234567890\", \"direccion\": \"direccion\", " +
                "\"fechaInscripcion\" : \"2024-08-15\"}";

        mockMvc.perform(post("/insertarAlumno")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk())
        ;
    }

}
