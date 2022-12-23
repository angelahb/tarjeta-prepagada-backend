package com.tarjeta.prepagada.respository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tarjeta.prepagada.model.Recargas;

@Repository
public interface RecargasRepository extends JpaRepository<Recargas, Long>{

	List<Recargas> findBycuentaNro(Long cuentaNro);

}
