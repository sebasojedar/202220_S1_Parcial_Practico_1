package co.edu.uniandes.dse.parcialejemplo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialejemplo.repositories.HotelRepository;
import co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;

import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    @Transactional
    public HotelEntity createHotel(HotelEntity hotel) throws IllegalOperationException {
        log.info("Inicia proceso de creacion del hotel");
        if(!hotelRepository.findByNombre(hotel.getNombre()).isEmpty()) {
            throw new IllegalOperationException("El hotel con ese nombre ya existe");
        }
        log.info("Termina proceso de creacion de hoteles");
        return hotelRepository.save(hotel);
    }

    
}
