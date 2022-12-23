package com.tarjeta.prepagada.respository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tarjeta.prepagada.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>  {

}
