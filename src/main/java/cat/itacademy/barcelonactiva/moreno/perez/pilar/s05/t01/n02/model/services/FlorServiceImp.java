package cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n02.model.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n02.model.repository.FlorRepository;

@Service
public class FlorServiceImp implements FlorService{

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	FlorRepository florRepository;
	
	@Override
	public List<FlorDTO> llistaFlors() {
		return florRepository.findAll()
				.stream()
        		.map(this::convertEntityToDto)
        		.collect(Collectors.toList());
	}

	@Override
	public FlorDTO getFlorDTOById(int id) {
		
		FlorEntity florEntity = florRepository.findById(id).orElseThrow();
		FlorDTO florDTO = modelMapper.map(florEntity, FlorDTO.class);
		
		return florDTO;
		
	}

	@Override
	public void saveFlorDTO(FlorDTO florDTO) {
		FlorEntity florEntity = new FlorEntity();
		
		florEntity.setNomFlor(florDTO.getNomFlor());
		florEntity.setPaisFlor(florDTO.getPaisFlor());
				
		florRepository.save(florEntity);
	}

	@Override
	public FlorDTO updateFlorDTO(FlorDTO florDTO, int idFlor) {
		
		FlorEntity florEntity = florRepository.findById(idFlor).orElseThrow();
		florEntity.setNomFlor(florDTO.getNomFlor());
		florEntity.setPaisFlor(florDTO.getPaisFlor());
		
		FlorEntity florActualitzada = florRepository.save(florEntity);
		return convertEntityToDto(florActualitzada);

	}

	@Override
	public void deleteFlorById(int id) {
		FlorEntity florEntity = florRepository.findById(id).orElseThrow();
		florRepository.delete(florEntity);
	}

	//De Entity a DTO
	private FlorDTO convertEntityToDto(FlorEntity flor) {
		FlorDTO florDTO = modelMapper.map(flor, FlorDTO.class);
		return florDTO;
	}
	
}
