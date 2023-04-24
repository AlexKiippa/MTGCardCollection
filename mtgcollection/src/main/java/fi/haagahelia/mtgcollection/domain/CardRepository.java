package fi.haagahelia.mtgcollection.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {
	
	List<Card> findBycardName(String cardName);
	

}
