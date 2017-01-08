package interfaces;

import javachat.network.Client;

public interface ClientProvider {
	
	Client getClient();
	Client setUser(String name);
	String getnewName();
	
	String getBirthday();
	String getGender();

}
