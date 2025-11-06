
public class Array7 {
	public static void main(String[] args) {
		static Boolean validateWebsite(String website) {
			//Regex breakdown:
			String regex = "^https?://(www\\.)?[a-zA-Z]+\\.[a-z]{2,6}(\\.[a-z]{2-6})?$";
			return website.matches(regex);
			}
		static Boolean validateMobile(String mobileNo) {
			String regex = "^+91[0-9]{10}$";
			return mobileNo.matches(regex);
		}
	}

}
