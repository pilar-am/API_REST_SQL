package cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n02.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n02.model.services.FlorService;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/flor")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
public class FlorController {
	
	
	@Autowired
	FlorService florService;
	
	@Operation(summary = "Retorna totes les flors")
	@GetMapping("/getAll")
	public ResponseEntity<List<FlorDTO>> getAllFlorsEntity (){
		try {
			List<FlorDTO> flors = florService.llistaFlors();
			if(flors.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				String tipusFlor;
				for(FlorDTO f : flors) {
					tipusFlor =  f.esUE(f.getPaisFlor());
					f.setTipusFlor(tipusFlor);
				}
				return new ResponseEntity<List<FlorDTO>>(flors, HttpStatus.OK);
			}
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	 @Operation(summary = "Retorna una flor segons el seu id")
	 @GetMapping("/getOne/{id}")
	 public ResponseEntity<FlorDTO> getFlorById(@PathVariable("id") Integer idFlor){
		try {
			FlorDTO florDTO = florService.getFlorDTOById(idFlor);
			String tipusFlor = florDTO.esUE(florDTO.getPaisFlor());
			 florDTO.setTipusFlor(tipusFlor);
			 return new ResponseEntity<>(florDTO, HttpStatus.OK);
		}catch (Exception e){
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	 }
	
	@Operation(summary = "Guarda una flor a la base de dades")
	@PostMapping("/add")
	public ResponseEntity<?> createFlor(@RequestBody FlorDTO florDTO){
		try {
			String tipusFlor = florDTO.esUE(florDTO.getPaisFlor());
			florDTO.setTipusFlor(tipusFlor);
			florService.saveFlorDTO(florDTO);
			return new ResponseEntity<>(florDTO, HttpStatus.CREATED);
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Operation(summary = "Actualitza una flor segons el seu id")
	@PutMapping("/update/{id}")
	public ResponseEntity<FlorDTO> updateFlor(@PathVariable("id") Integer idFlor, @RequestBody FlorDTO florDTO){
		try {
			FlorDTO florDTO2 = florService.updateFlorDTO(florDTO, idFlor);
			return new ResponseEntity<>(florDTO2, HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(summary = "Elimina una flor de la base de dades")
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFlor(@PathVariable("id") Integer idFlor){
    	try {
    		florService.deleteFlorById(idFlor);
    		return new ResponseEntity<>("Flor eliminada", HttpStatus.OK);
    	}catch (Exception e) {
    		return new ResponseEntity<>("No existeix l'id",HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}
