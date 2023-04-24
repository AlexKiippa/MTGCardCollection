package fi.haagahelia.mtgcollection.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Card {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String cardName;
	private	Integer manaCost;
	private Boolean multicolored;
	
	
	@ManyToOne
	@JoinColumn(name = "cardColorid")
	private CardColor cardcolor;
	
	@ManyToOne
	@JoinColumn(name = "cardTypeid")
	private CardType cardtype;
	
	
	public Card() {
		
	}
	
	
	public Card(String cardName, CardType cardtype, Integer manaCost, Boolean multicolored,  CardColor cardcolor) {
		super();
		this.cardName = cardName;
		this.cardtype = cardtype;
		this.manaCost = manaCost;
		this.multicolored = multicolored;
		this.cardcolor = cardcolor;
		
		
	}
	
	

	
	
	
	
	
	public Integer getManaCost() {
		return manaCost;
	}


	public void setManaCost(Integer manaCost) {
		this.manaCost = manaCost;
	}


	public CardColor getCardcolor() {
		return cardcolor;
	}


	public void setCardcolor(CardColor cardcolor) {
		this.cardcolor = cardcolor;
	}


	public Boolean getMulticolored() {
		return multicolored;
	}


	public void setMulticolored(Boolean multicolored) {
		this.multicolored = multicolored;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	public CardType getCardtype() {
		return cardtype;
	}
	public void setCardtype(CardType cardtype) {
		this.cardtype = cardtype;
	}


	@Override
	public String toString() {
		return "Card [id=" + id + ", cardName=" + cardName + ", cardType=" + cardtype + ", manaCost=" + manaCost
				+ ", multicolored=" + multicolored + ", cardcolor=" + cardcolor + "]";
	}

	
	
	
}
