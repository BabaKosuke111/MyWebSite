package beans;

public class CardDetailDataBeans {
	private int id;
	private String cardName;
	private int cardCost;
	private String cardEffect;
	private String fileName;

	private String className;

	public CardDetailDataBeans(int id,String cardName,String className) {
		this.id=id;
		this.cardName=cardName;
		this.className=className;
	}
	public CardDetailDataBeans(String cardName,int cardCost,String cardEffect,String fileName,String className) {
		this.cardName=cardName;
		this.cardCost=cardCost;
		this.cardEffect=cardEffect;
		this.fileName=fileName;
		this.className=className;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public int getCardCost() {
		return cardCost;
	}

	public void setCardCost(int cardCost) {
		this.cardCost = cardCost;
	}

	public String getCardEffect() {
		return cardEffect;
	}

	public void setCardEffect(String cardEffect) {
		this.cardEffect = cardEffect;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
