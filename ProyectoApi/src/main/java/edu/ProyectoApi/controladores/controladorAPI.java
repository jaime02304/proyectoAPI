package edu.ProyectoApi.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ProyectoApi.Dtos.clubDto;
import edu.ProyectoApi.servicios.clubImplementacion;
import edu.ProyectoApi.servicios.clubInterfaz;

/**
 * Aqui es donde se encuentra la capa del controlador de la API
 * @author jpribio - 30/10/24
 */
@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api/club") // Establece la ruta base para las peticiones
public class controladorAPI {
	@Autowired // Inyección automatica del servicio de clubes
	clubInterfaz interfazClub = new clubImplementacion();
	
	/**
	 * Crea un nuevo club segun los parametros obtenidos
	 * @author jpribio - 30/10/24
	 * @param la informacion del club
	 * @return Devuelve la respuesta y el cuerpo del nuevo club
	 */
	@PostMapping
	public ResponseEntity<clubDto> crearClub(@RequestBody clubDto club){
		clubDto nuevoClub = interfazClub.crearClub(club);
		// Se crea una respuesta de codigo 200 y el objeto nuevoClub
		ResponseEntity<clubDto> response = ResponseEntity
				.status(HttpStatus.OK)  // Especifica el código de estado HTTP 200 OK
		        .body(nuevoClub); 
		return response; 
	}
	
	/**
	 * metodo que que coge la informacion especificada por el nombre del club
	 * @author jpribio - 30/10/24
	 * @param nombre especifico del club
	 * @return devuelve la respuesta
	 */
	@GetMapping("{nombreClub}") // Maneja las peticiones GET en /api/clubs/{nombreClub}
	public ResponseEntity<clubDto> obtenerClub(@PathVariable String nombreClub){
		// Llama al servicio para obtener el club por nombre
		Optional<clubDto> clubOpcional = interfazClub.obtenerClub(nombreClub);

		// Verifica si se encontró el club
		if (clubOpcional.isPresent()) {
		    // Si se encuentra, crea una respuesta con el club y estado 200 OK
		    return ResponseEntity.ok(clubOpcional.get());
		} else {
		    // Si no se encuentra, retorna un estado 404 Not Found
		    return ResponseEntity.notFound().build();
		}
		
	}
	
	/**
	 * Metodo que borra el club segun su nombre
	 * @author jpribio - 30/10/24
	 * @param nombre del club
	 * @return devuelve la respuyesdta
	 */
	@DeleteMapping("{nombreClub}")
	public ResponseEntity<Void> borrarClub(@PathVariable String nombreClub){
	    interfazClub.eliminarClub(nombreClub);
	    // Crea una respuesta con estado 204 No Content
	    ResponseEntity<Void> response = ResponseEntity.noContent().build();
	    // Retorna la respuesta
	    return response;
	}
	
}
