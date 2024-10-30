package edu.ProyectoApi.servicios;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio que permite realizar operaciones CRUD
 * @author jpribio - 29/10/24
 */
public interface clubRepositorio extends JpaRepository<entidadClub, Long>{
	
	 entidadClub findByNombreClub(String nombreClub);

}
