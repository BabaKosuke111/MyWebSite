package beans;

import java.io.Serializable;

public class DeckDetailDataBeans implements Serializable {
	private int id;
	private String deckName;
	private String className;
	private int cardId;
	private String cardName;
	private int cardCost;
	private int cardCount;
	private int deckId;

	public DeckDetailDataBeans(int id,String cardName, int cardCost) {
		this.id=id;
		this.cardName=cardName;
		this.cardCost=cardCost;
	}

	public DeckDetailDataBeans(int cardId, String cardName, int cardCost, int cardCount) {
		this.cardId=cardId;
		this.cardName=cardName;
		this.cardCost=cardCost;
		this.cardCount=cardCount;
	}
	public DeckDetailDataBeans() {
		this.setDeckId(0);
		this.cardId=0;
		this.cardCount=0;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeckName() {
		return deckName;
	}
	public void setDeckName(String deckName) {
		this.deckName = deckName;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getCardCost() {
		return cardCost;
	}
	public void setCardCost(int cardCost) {
		this.cardCost = cardCost;
	}
	public int getCardCount() {
		return cardCount;
	}
	public void setCardCount(int cardCount) {
		this.cardCount = cardCount;
	}
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public int getDeckId() {
		return deckId;
	}

	public void setDeckId(int deckId) {
		this.deckId = deckId;
	}

}
