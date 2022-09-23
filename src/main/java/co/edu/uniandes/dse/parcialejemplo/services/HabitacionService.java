package co.edu.uniandes.dse.parcialejemplo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialejemplo.repositories.HabitacionRepository;
import co.edu.uniandes.dse.parcialejemplo.entities.HabitacionEntity;

import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HabitacionService {
    @Autowired
    HabitacionRepository habitacionRepository;

    @Transactional
    public HabitacionEntity createHabitacion(HabitacionEntity habitacion) throws IllegalOperationException {
        log.info("Inicia proceso de creacion de la habitacion");
        if(habitacion.getCapacidad() > (habitacion.getNumCamas()/2)) {
            throw new IllegalOperationException("La capacidad no va acorde con el numero de camas");
        }
        log.info("Termina proceso de creacion de hoteles");
        return habitacionRepository.save(habitacion);
    }

}
