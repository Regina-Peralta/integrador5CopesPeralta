package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.entity.Career;
import org.example.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/career")
public class CareerController {

	@Autowired
    private CareerService careerService;
    @GetMapping("/sortedByStudent")
    @Operation(summary = "Devolver carreras Ordenadas",
            description = "Devuelve todas las carreras ordenadas descendentemente segun la cantidad de estudiantes",
            tags = "carreras")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de carreras ordenadas por #estudiantes",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class)) }),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content) })
    public List<Career> getCareersOrderByStudents() {
        return careerService.getCareersOrderByStudents();
    }

    @GetMapping("/")
    @Operation(summary = "Devolver carreras",
            description = "Devuelve todas las carreras",
            tags = "carreras")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de carreras",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class)) }),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content) })
    public List<Career> getCareers() {
        return careerService.getCareers();
    }

    @PostMapping("/")
    @Operation(summary = "Añadir carrera",
            description = "Devuelve todas las carreras",
            tags = "carreras")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carrera insertada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Career.class)) }),
            @ApiResponse(responseCode = "503", description = "Bad Request",
                    content = @Content) })
    public Career addCareer(@RequestBody Career c) {
        return careerService.addCareer(c);
    }
}