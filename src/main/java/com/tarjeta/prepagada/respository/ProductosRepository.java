package com.tarjeta.prepagada.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarjeta.prepagada.model.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long>{

}
