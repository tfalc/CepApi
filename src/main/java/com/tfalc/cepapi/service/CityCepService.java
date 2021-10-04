package com.tfalc.cepapi.service;

import com.tfalc.cepapi.exception.ResourceNotFoundException;
import com.tfalc.cepapi.model.CityCep;
import com.tfalc.cepapi.repository.CityCepRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityCepService {

    @Autowired
    CityCepRepository cityCepRepository;

    public List<CityCep> getAllCityCep() throws ResourceNotFoundException {
        List<CityCep> cityCepList = cityCepRepository.findAll();
        if (cityCepList.size() == 0){
            throw new ResourceNotFoundException("Dados não encontrados!");
        }
        return cityCepList;
    }

    public CityCep getCityByCep(Long cityId) throws NotFoundException {
        return cityCepRepository.findById(cityId)
                .orElseThrow(() -> new NotFoundException("CEP de ID " + cityId + " não encontrado."));
    }

    public CityCep createCity(CityCep cityCep) throws ResourceNotFoundException {
        validateCep(cityCep);
        return cityCepRepository.save(cityCep);
    }

    public CityCep updateCity(Long cityId, CityCep cityDetails)
            throws NotFoundException, ResourceNotFoundException {
        CityCep cityCep = getCityByCep(cityId);
        cityDetails.setId(cityId);
        cityCep.setCityCep(cityDetails.getCityCep());
        cityCep.setCityName(cityDetails.getCityName());
        cityCep.setFaixaInicial(cityDetails.getFaixaInicial());
        cityCep.setFaixaFinal(cityDetails.getFaixaFinal());

        cityCep = cityCepRepository.save(cityCep);

        return cityCep;
    }

    public void deleteCityCep(Long cityId) throws ResourceNotFoundException, NotFoundException {
        CityCep cityCep = getCityByCep(cityId);
        cityCepRepository.delete(cityCep);
    }

    public void validateCep(CityCep cityCep) throws ResourceNotFoundException {
        List<CityCep> validateCep = getAllCityCep();

        if(cityCep.getFaixaInicial() > cityCep.getFaixaFinal()){
            throw new ResourceNotFoundException("CEP inical maior do que o finial!");
        }

        for (CityCep cepValidation : validateCep) {
            if (cepValidation.getFaixaInicial() <= cityCep.getFaixaInicial()
                    && cepValidation.getFaixaFinal() >= cityCep.getFaixaInicial()) {
                throw new ResourceNotFoundException("Faixa de CEP já cadastrada!");
            }
            if (cepValidation.getFaixaInicial() >= cityCep.getFaixaFinal()
                && cepValidation.getFaixaFinal() <= cityCep.getFaixaFinal()){
                throw new ResourceNotFoundException("Faixa de CEP já cadastrada!");
            }
            if (cepValidation.getFaixaInicial() >= cityCep.getFaixaInicial()
                && cepValidation.getFaixaFinal() <= cityCep.getFaixaFinal()){
                throw new ResourceNotFoundException("Faixa de CEP já cadastrada!");
            }
        }

    }


}
