package co.edu.uniandes.dse.parcialejemplo.entities;

import lombok.Getter;
import lombok.Setter;

import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.ManyToOne;
import javax.persistence.Entity;

@Getter
@Setter
@Entity

public class HabitacionEntity extends BaseEntity {

    private Integer numiD;
    private Integer capacidad;
    private Integer numCamas;
    private Integer numBanios;

    //Asociacion con HotelEntity
    @PodamExclude
    @ManyToOne
    private HotelEntity hotel;
}
