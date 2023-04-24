package fi.haagahelia.mtgcollection.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CardTypeRepository  extends CrudRepository<CardType, Long>{

	List<CardType> findBycardType(String cardType);

}
