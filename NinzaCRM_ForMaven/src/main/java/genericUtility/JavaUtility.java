package genericUtility;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	//To generate Random Number
	public int generateRandomNumber() {
		Random ran= new Random();
		int randomNum = ran.nextInt(5000);
		return randomNum;
	}

	//To Capture the current system Date
	public String getSystemDateddMMyyyy() {
		Date dateObj= new Date();
		SimpleDateFormat simple= new SimpleDateFormat("yyyy-MM-dd");
		String date = simple.format(dateObj);
		return date;
	}
	
	//To Get Required Date
	public String getRequiredDateddMMyyyy(int days) {

		Date dateObj= new Date();
		SimpleDateFormat simple= new SimpleDateFormat("yyyy-MM-dd");
		simple.format(dateObj);
		Calendar cal = simple.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = simple.format(cal.getTime());
		return reqDate;
				
	}
	
	public String getSystemDateAndTimeForScreenshot() {
		String dateAndTime = new Date().toString();
				//Tue Jun 10 11:31:36 IST 2025
		String dateForSS = dateAndTime.replace(" ", "_").replace(":", "_");
		return dateForSS;
	}
}
