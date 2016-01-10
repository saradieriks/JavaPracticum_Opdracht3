package domain;

public class Korting {

	private static Korting uniekeKorting;
	
	private Korting() {}
	
	public static Korting getInstance () {
		if (uniekeKorting == null) {
			uniekeKorting = new Korting();
		}
		return uniekeKorting;
	}
}
