package fi.haagahelia.mtgcollection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.haagahelia.mtgcollection.domain.Card;
import fi.haagahelia.mtgcollection.domain.CardColor;
import fi.haagahelia.mtgcollection.domain.CardColorRepository;
import fi.haagahelia.mtgcollection.domain.CardRepository;
import fi.haagahelia.mtgcollection.domain.CardType;
import fi.haagahelia.mtgcollection.domain.CardTypeRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RepositoryTest {
	
	
	@Autowired
	private CardRepository crepository;
	
	@Autowired
	private CardColorRepository ccrepository;
	
	@Autowired
	private CardTypeRepository ctrepository;
	
	
	
	@Test
	public void findbycardShouldreturnColor() {
		List<Card> cards = crepository.findBycardName("Arcane Signet");
		assertThat(cards.get(0).getCardcolor()).isEqualTo("Colorless");
	}
	
	@Test
	public void findbycardShouldreturnType() {
		List<Card> cards = crepository.findBycardName("Arcane Signet");
		assertThat(cards.get(0).getCardtype()).isEqualTo("Artifact");
	}
	
	
	@Test
	public void createNewCard() {
		Card card = new Card("Regress", ctrepository.findBycardType("Instant").get(0)
				,3 , false,ccrepository.findBycardColor("Blue").get(0));
		crepository.save(card);
		assertThat(card.getId()).isNotNull();
	}
	
	@Test
	public void deleteNewCard() {
		List<Card> cards = crepository.findBycardName("Sol Ring");
		Card card = cards.get(0);
		crepository.delete(card);
		List<Card> newCards = crepository.findBycardName("Sol Ring");
		assertThat(newCards).hasSize(0);
	}
	
	@Test
	public void findbyCardColor() {
		List<CardColor> cardcolors = ccrepository.findBycardColor("Blue");
		assertThat(cardcolors).hasSize(1);
	}
	
	@Test
	public void findbyCardType() {
		List<CardType> cardtypes = ctrepository.findBycardType("Instant");
		assertThat(cardtypes).hasSize(1);
	}
	
	
	
	

}
