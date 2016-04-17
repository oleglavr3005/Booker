package src.com.softserve.edu.rs.data.apps;

public final class ApplicationSources {
	private String loginUrl;
	private String logoutUrl;
	private long implicitTimeOut;
	private String browserName;
	// private String browserPath;
	// Implicit and Explicit Waits
	// private String searchStrategy;
	// TODO Logger Strategy
	// TODO Sleep for Demo

	public ApplicationSources() {
		this.loginUrl = new String();
		this.logoutUrl = new String();
		this.implicitTimeOut = 5;
		this.browserName = new String();
	}

	public ApplicationSources(String loginUrl, String logoutUrl, 
			long implicitTimeOut, String browserName) {
		this.loginUrl = loginUrl;
		this.logoutUrl = logoutUrl;
		this.implicitTimeOut = implicitTimeOut;
		this.browserName = browserName;
	}
	
	public static ApplicationSources get() {
		return new ApplicationSources();
	}

	// set

	public ApplicationSources setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
		return this;
	}

	public ApplicationSources setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
		return this;
	}

	public ApplicationSources setImplicitTimeOut(long implicitTimeOut) {
		this.implicitTimeOut = implicitTimeOut;
		return this;
	}

	public ApplicationSources setBrowserName(String browserName) {
		this.browserName = browserName;
		return this;
	}

	// get
	
	public String getLoginUrl() {
		return loginUrl;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}

	public long getImplicitTimeOut() {
		return implicitTimeOut;
	}

	public String getBrowserName() {
		return browserName;
	}

}
