package page_helper;

public class locators_values {

	public String signInLinkLoc 		= "//*[@id=\"ybar-inner-wrap\"]/div[3]/div/div[3]/div[1]/div/a"; // xpath
	public String emailLoc 				= "//*[@id=\"login-username\"]"; 
	public String nextButtonBeforePass  ="//*[@id='login-signin']";
	//public String nextButtonBeforePass  = "#login-signin";//css 
	public String passwordLoc			= "//*[@id=\"login-passwd\"]";
	public String nextButton		    = "//*[@id='login-signin']";
	public String myActualNameLoc	    = "//*[@id=\"header-profile-menu\"]";
	public String inlinelocator         ="//*[@id=\"password-challenge\"]/form/p";
	public String Nothanksloc           ="//*[@id=\"mega-banner-close\"]";
	public String maillinkloc           ="//*[@id=\"ybar-inner-wrap\"]/div[3]/div/div[3]/div[3]/div";
	public String Composelink           ="//*[@data-test-id='compose-button']";
	public String To_link               ="//*[@id='message-to-field']";
	public String Subject_link          ="//*[@id=\"mail-app-component\"]/div[1]/div/div[1]/div[3]/div/div/input";
	public String Send_button           ="//*[@id=\"mail-app-component\"]/div[1]/div/div[2]/div[2]/div/button";
	public String sent_buttonloc        ="//*[@id=\"app\"]/div[2]/div/div[1]/nav/div/div[3]/div[1]/ul/li[5]/div/a/span[1]/span/span/span";
	public String delete_loc            ="//*[@id=\"app\"]/div[7]/div/div[1]/div/div/ul/li[9]/a/span";
	public String page_title_loc        ="//*[@id=\"ybar-logo\"]/img[2]";
	public String successfully_mail_sent="//*[@id=\"app\"]/div[5]/div/div/div/div[2]";
	public String Email_compose_field   ="//*[@id=\"editor-container\"]/div[1]";
	public String file_path_emaildata_sheet="./mail.txt";
	public String Conversation_deleted  ="//*[@id=\"app\"]/div[5]/div/div/div/div[2]";
	// all the values -- test data, name, email, password
	public String emailValue 			= "practice_ya2020";
	public String passValue				= "yahoo123%";
	public String writeTolink           ="hannan632010@yahoo.com";
	public String writesublink          ="hello this is afsana";
}
////*[@role='textbox']
//*[@id="app"]/div[2]/div/div[1]/nav/div/div[3]/div[1]/ul/li[5]/div/a/span[1]/span/span/span