package javachat.ui;

public interface Plugin {

	String getButtonText();
	void ButtonClicked();
	void register(ChatProvider chat);

}
