
package com.Reto.Reto3.CrudRepository;

import com.Reto.Reto3.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    
}
