package com.Library.patron.service;

import com.Library.patron.dto.PatronDto;
import com.Library.patron.entity.Patron;
import com.Library.exceptions.PatronNotFoundException;
import com.Library.patron.mapper.PatronMapper;
import com.Library.patron.repo.PatronRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatronService {


   private final PatronRepo patronRepo ;

    @Transactional(readOnly = true)
    public List<PatronDto> getAllPatron(){

        List<Patron> patrons = patronRepo.findAll();
         List<PatronDto> patronDtos =PatronMapper.toListPatronDto(patrons);
         return patronDtos;
    }

    @Transactional(readOnly = true)
    public PatronDto getAPatron( Long id){

        Optional<Patron> byId = patronRepo.findById(id);
        if( byId.isPresent()){
            return PatronDto.toPatronDto(byId.get());
        }else {
            throw new PatronNotFoundException("no Patron with this id");
        }
    }


    @Transactional
    public void addPatron( PatronDto patronDto){
        Patron patron =PatronMapper.toPatronEntity((patronDto));
        patronRepo.save(patron);
    }

    @Transactional
    public void updatePatron( PatronDto patronDto )
    {
        Patron patron =PatronMapper.toPatronEntity((patronDto));
        patronRepo.save(patron);
    }

    @Transactional
    public void deletePatron( Long id){

        Optional<Patron> byId = patronRepo.findById(id);
        if( byId.isPresent()){
            Patron patron = byId.get();
            patronRepo.delete(patron);
        }else {
            throw new PatronNotFoundException("no patron with this id");
        }

    }



}
