package domain;

public abstract class KassaBon {
	private int nummer = 0;
	
	public KassaBon(){
		this.nummer = this.nummer + 1;
	}
	
	public int getNummer(){
		return this.nummer;
	}
	
	public void setNummer(int nummer){
		this.nummer = nummer;
	}
	
	public void Body(){}

}
