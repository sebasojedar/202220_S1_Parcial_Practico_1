package co.edu.uniandes.dse.parcialejemplo.entities;

import java.util.List;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.OneToMany;
import javax.persistence.Entity;

@Getter
@Setter
@Entity

public class HotelEntity extends BaseEntity {

    private String nombre;
    private String direccion;
    private Integer numEstrellas;

    //Asociacion con HabitacionEntity
    @PodamExclude
    @OneToMany(mappedBy = "hotel")
    private List<HabitacionEntity> habitaciones = new ArrayList<>();
}
