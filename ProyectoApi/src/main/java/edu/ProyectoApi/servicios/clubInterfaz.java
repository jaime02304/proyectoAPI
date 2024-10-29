package edu.ProyectoApi.servicios;

import java.util.List;
import java.util.Optional;

import edu.ProyectoApi.Dtos.clubDto;

/**
 * Interfaz donde se encuentra la cabecera de los metodos con la gestion de la API
 * @author jpribio - 29/10/24
 */
public interface clubInterfaz {
	
	/**
	 * Metodo que crea un nuevo club
	 * @author jpribio - 29/10/24
	 * @param tiene como parametro el DTO del club para añadirlo a la Base de datos
	 * @return devuelve el DTO actualizado con el ID
	 */
	public clubDto crearClub(clubDto club);
	
	/**
	 * Metodo que muestra el club por el id
	 * @author jpribio - 29/10/24
	 * @param id del club a mostrar
	 * @return Devuelve el DTO
	 */
	public Optional<clubDto> obtenerClub(Long id);
	
	/**
	 * Metodo para listar todos los club
	 * @author jpribio - 29/10/24
	 * @return Devuelve una lista que contiene todos los clubs
	 */
	public List<clubDto> listarClub();
	
	/**
	 * Metodo que elimina el club por el ID
	 * @author jpribio - 29/10/24
	 * @param id del club para eliminar
	 */
	public void eliminarClub(Long id);

}