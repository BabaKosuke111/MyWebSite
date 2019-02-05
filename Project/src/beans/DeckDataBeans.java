package beans;

import java.io.Serializable;

public class DeckDataBeans implements Serializable {

	private int id;
	private String deckName;
	private String classId;
	private int userId;
	private int voteCount;

	private String className;

	public DeckDataBeans(int id, String deckName,int voteCount, String className) {
		this.id=id;
		this.deckName=deckName;
		this.voteCount=voteCount;
		this.className=className;
	}
	public DeckDataBeans(String deckName, String className) {
		this.deckName=deckName;
		this.className=className;
	}
	public DeckDataBeans(int userId,String deckName,String className) {
		this.userId=userId;
		this.deckName=deckName;
		this.className=className;
	}
	public DeckDataBeans(){
		this.deckName="";
		this.classId="";
		this.userId=0;
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
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}

}
