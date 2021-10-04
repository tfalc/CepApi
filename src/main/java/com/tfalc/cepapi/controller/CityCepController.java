package com.tfalc.cepapi.controller;

import com.tfalc.cepapi.exception.ResourceNotFoundException;
import com.tfalc.cepapi.model.CityCep;
import com.tfalc.cepapi.service.CityCepService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CityCepController {

    @Autowired
    CityCepService cityCepService;

    @GetMapping("/cidade")
    public ResponseEntity<List<CityCep>> getCityCep() {
        try {
            List<CityCep> cityCepList = cityCepService.getAllCityCep();
            return ResponseEntity
                    .ok()
                    .body(cityCepList);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }
    }

    @GetMapping("/cidade/{id}")
    public ResponseEntity<CityCep> getCityByCep(@PathVariable(value = "id") Long cityId)
            throws NotFoundException {
        try {
            CityCep cityCep = cityCepService.getCityByCep(cityId);
            return ResponseEntity
                    .ok()
                    .body(cityCep);
        } catch (NotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @PostMapping("/cidade")
    public ResponseEntity<Void> createCity(@RequestBody CityCep cityCep) throws ResourceNotFoundException {
        try {
            CityCep cityCepToSave = cityCepService.createCity(cityCep);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @PutMapping("/cidade/{id}")
    public ResponseEntity<?> updateCity(@PathVariable(value = "id") Long cityId,
                                        @RequestBody CityCep cityDetails) throws NotFoundException {
        try {
            CityCep cityCep = cityCepService.updateCity(cityId, cityDetails);
            return ResponseEntity
                    .ok()
                    .body("");
        } catch (NotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        } catch (ResourceNotFoundException e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @DeleteMapping("/cidade/{id}")
    public ResponseEntity<Void> deleteCityCep(@PathVariable(value = "id") Long cityId) {
        try {
            cityCepService.deleteCityCep(cityId);
            return ResponseEntity
                    .ok()
                    .build();
        } catch (NotFoundException | ResourceNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}
