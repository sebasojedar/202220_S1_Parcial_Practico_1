package co.edu.uniandes.dse.parcialejemplo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialejemplo.repositories.HotelRepository;
import co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;
import co.edu.uniandes.dse.parcialejemplo.repositories.HabitacionRepository;
import co.edu.uniandes.dse.parcialejemplo.entities.HabitacionEntity;

import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HotelHabitacionService {
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    HabitacionRepository habitacionRepository;


    @Transactional
    public HotelEntity addHabitacion(HotelEntity hotel, HabitacionEntity habitacion) throws IllegalOperationException {
        log.info("Empieza proceso de adicion de habitacion");
        if (hotel.getHabitaciones().contains(habitacion)){
            throw new IllegalOperationException("Ya existe la habitacion");
        }
        log.info("Termina proceso de adicion de habitacion");
        return hotelRepository.save(hotel);
    }

    
}