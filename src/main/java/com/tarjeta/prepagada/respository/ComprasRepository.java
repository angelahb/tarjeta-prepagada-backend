package com.tarjeta.prepagada.respository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tarjeta.prepagada.model.Compras;

@Repository
public interface ComprasRepository extends JpaRepository<Compras, Long> {

	List<Compras> findBycuentaNro(Long cuentaNro);

}
