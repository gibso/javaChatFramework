package interfaces;

public interface ButtonPlugin {

	String getButtonText();

	void ButtonClicked();

	void register(ChatProvider chat);
}
