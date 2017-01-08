package plugins;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import interfaces.AboutPlugin;
import interfaces.ChatProvider;
import interfaces.ClientProvider;
import javachat.network.Client;

public class SetAbout implements AboutPlugin {
	private ClientProvider client;
	
	@Override
	public String getButtonText() {
		return "Update Name";
	}

	@Override
	public void ButtonClicked() {
		if (client != null){
			String name = client.getnewName();
			String birthdayStr = client.getBirthday();
			DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
			
			try {
				Date birthday = format.parse(birthdayStr);
				String gender = "";
				gender = client.getGender();
				int age = new Date().getYear() - birthday.getYear();
				int month = new Date().getMonth() - birthday.getMonth();
				int day = new Date().getDate() - birthday.getDate();
				
				if (month <= 0 && day <= 0){
					age = age - 1;
				}
				name = name + gender + age;
				client.setUser(name);
			} catch (ParseException e) {
				System.out.println("exception: " + e.getMessage());
			}
		}
	}

	@Override
	public void register(ClientProvider client) {
		this.client = client;
	}

}
