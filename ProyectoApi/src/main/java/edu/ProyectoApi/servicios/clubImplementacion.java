package edu.ProyectoApi.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import edu.ProyectoApi.Dtos.clubDto;
import edu.ProyectoApi.utilidades.utiles;

public class clubImplementacion implements clubInterfaz {
	utiles util = new utiles();

	/**
	 * Inyecta automaticamente el repositorio del club en esta clase
	 * 
	 * @author jpribio - 29/10/24
	 */
	@Autowired
	private clubRepositorio repositorioDelClub;
	private Gson gson = new Gson();

	public clubDto crearClub(clubDto club) {
		entidadClub clubEntidad = new entidadClub();
		// Se establece los atributos del club desde el DTO
		clubEntidad.setNombreClub(club.getNombreClub());
		clubEntidad.setCorreoElectronicoClub(club.getCorreoElectronicoClub());
		clubEntidad.setPaisClub(club.getPaisClub());
		clubEntidad.setLocalidadClub(club.getLocalidadClub());
		clubEntidad.setSedePrincipal(club.getSedePrincipal());
		String contraEncriptada = util.encriptacionContra(club.getContraseniaClub());
		clubEntidad.setContraseniaClub(contraEncriptada);

		// Guarda el club y obtiene el club guardado
		entidadClub guardarClub = repositorioDelClub.save(clubEntidad);
		// Establece el ID del club guardado en el DTO.
		club.setId(guardarClub.getId());
		return club;
	}

	@Override
	public Optional<clubDto> obtenerClub(String nombreClub) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}


	@Override
	public void eliminarClub(String nombreClub) {
	    // Busca el club por nombre
	    entidadClub clubEntidad = repositorioDelClub.findByNombreClub(nombreClub); 

	    if (clubEntidad != null) {
	        repositorioDelClub.delete(clubEntidad); 
	    } else {
	        throw new RuntimeException("Club no encontrado"); // Lanza una excepción si no se encuentra el club
	    }
	}


}
