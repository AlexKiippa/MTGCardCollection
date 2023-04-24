package fi.haagahelia.mtgcollection.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CardType {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cardTypeid;
	private String cardType;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER)
	private List<Card> cards;
	
	public CardType() {
		
	}
	
	public CardType(String cardType) {
		super();
		this.cardType = cardType;
	}

	public Long getCardTypeid() {
		return cardTypeid;
	}

	public void setCardTypeid(Long cardTypeid) {
		this.cardTypeid = cardTypeid;
	}
	

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	
	
	
}
