package model.entity;

public class ButtonAction 
{
	private String buttonId;
	private String buttonName;
	private String browser;
	private String url;
	private String dateTime;
	public ButtonAction(String buttonId, String buttonName, String browser, String url, String dateTime) 
	{
		super();
		this.buttonId = buttonId;
		this.buttonName = buttonName;
		this.browser = browser;
		this.url = url;
		this.dateTime = dateTime;
	}
	
	
	public ButtonAction() {	}


	public String getButtonId() {
		return buttonId;
	}
	public void setButtonId(String buttonId) {
		this.buttonId = buttonId;
	}
	public String getButtonName() {
		return buttonName;
	}
	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}


	@Override
	public String toString() {
		return "ButtonAction [buttonId=" + buttonId + ", buttonName=" + buttonName + ", browser=" + browser + ", url="
				+ url + ", dateTime=" + dateTime + "]";
	}
	
	

}
