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
public class CardColor {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cardColorid;
	private String cardColor;
	
	
	
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER)
	private List<Card> cards;
	
	
	public CardColor() {
		
	}
	
	public CardColor(String cardColor) {
		super();
		this.cardColor= cardColor;
	}

	public Long getCardColorid() {
		return cardColorid;
	}

	public void setCardColorid(Long cardColorid) {
		this.cardColorid = cardColorid;
	}

	public String getCardColor() {
		return cardColor;
	}

	public void setCardColor(String cardColor) {
		this.cardColor = cardColor;
	}
	
	
	
	
	
	

}
