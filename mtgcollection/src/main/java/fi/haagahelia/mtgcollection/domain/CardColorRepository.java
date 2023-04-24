package fi.haagahelia.mtgcollection.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CardColorRepository extends CrudRepository<CardColor, Long>{
		
		List<CardColor> findBycardColor(String cardColor);

}
