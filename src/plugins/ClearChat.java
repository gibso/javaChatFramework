package plugins;

import javachat.ui.ChatProvider;
import javachat.ui.Plugin;

public class ClearChat implements Plugin {

	private ChatProvider cp;
	
	@Override
	public String getButtonText() {
		return "Clear";
	}

	@Override
	public void ButtonClicked() {
		cp.getChatField().setText("");
	}

	@Override
	public void register(ChatProvider chat) {
		this.cp = chat;
	}	
}
