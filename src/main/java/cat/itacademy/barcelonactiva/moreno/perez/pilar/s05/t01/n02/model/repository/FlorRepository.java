package cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n02.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n02.model.domain.FlorEntity;

@Repository
public interface FlorRepository extends JpaRepository<FlorEntity, Integer>{

}
