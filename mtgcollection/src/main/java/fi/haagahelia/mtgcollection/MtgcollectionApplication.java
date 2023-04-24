package fi.haagahelia.mtgcollection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.haagahelia.mtgcollection.domain.AppUser;
import fi.haagahelia.mtgcollection.domain.AppUserRepository;
import fi.haagahelia.mtgcollection.domain.Card;
import fi.haagahelia.mtgcollection.domain.CardColor;
import fi.haagahelia.mtgcollection.domain.CardColorRepository;
import fi.haagahelia.mtgcollection.domain.CardRepository;
import fi.haagahelia.mtgcollection.domain.CardType;
import fi.haagahelia.mtgcollection.domain.CardTypeRepository;

@SpringBootApplication
public class MtgcollectionApplication {
	
	
	private static final Logger log = LoggerFactory.getLogger(MtgcollectionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MtgcollectionApplication.class, args);
	}

	
	
	@Bean
	public CommandLineRunner cardDemo(CardRepository repository, CardColorRepository crepository, CardTypeRepository ctrepository, AppUserRepository urepository) {
	return (args) -> {
		log.info("save couple cards");
		
		
		// Luodaan valmiit värit korteille
		
		crepository.save(new CardColor("Black"));
		crepository.save(new CardColor("White"));
		crepository.save(new CardColor("Green"));
		crepository.save(new CardColor("Blue"));
		crepository.save(new CardColor("Red"));
		crepository.save(new CardColor("Colorless"));
		
		
		// Luodaan valmiit Tyypit korteille
		ctrepository.save(new CardType("Artifact"));
		ctrepository.save(new CardType("Instant"));
		ctrepository.save(new CardType("Creature"));
		ctrepository.save(new CardType("Enchantment"));
		ctrepository.save(new CardType("Land"));
		ctrepository.save(new CardType("Sorcery"));
		ctrepository.save(new CardType("Planeswalker"));
		
		
		// Tallennetaan muutama kortti
		repository.save(new Card("Arcane Signet", ctrepository.findBycardType("Artifact").get(0), 2, false, crepository.findBycardColor("Colorless").get(0) ));
		repository.save(new Card("Sol Ring", ctrepository.findBycardType("Artifact").get(0), 1, false, crepository.findBycardColor("Colorless").get(0) ));
		repository.save(new Card("Sickening Dreams", ctrepository.findBycardType("Sorcery").get(0),2, false,crepository.findBycardColor("Black").get(0) ));
		
		
		// Luodaan 3 käyttäjää 2 admin käyttäjää admin salasana on admin ja alex käyttäjän salasana huonosalasana. Userilla salasana user
		AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
		AppUser user3 = new AppUser("alex", "$2y$10$yaFPfU9SbjgNUJcutXGFxerkP6A3RcnrAOrf7xueJpaSMFOxRwR.O", "ADMIN");
		urepository.save(user1);
		urepository.save(user2);
		urepository.save(user3);
		
		log.info("fetch all cards");
		for (Card card : repository.findAll()) {
			log.info(card.toString());
		}
	};
	
	}
}
