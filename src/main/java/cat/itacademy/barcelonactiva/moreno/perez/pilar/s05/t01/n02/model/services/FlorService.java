package cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n02.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n02.model.dto.FlorDTO;

public interface FlorService {
	List<FlorDTO> llistaFlors();
	FlorDTO getFlorDTOById(int id);
	void saveFlorDTO(FlorDTO florDTO);
	FlorDTO updateFlorDTO(FlorDTO florDTO, int idFlor);
	void deleteFlorById(int id);
}
