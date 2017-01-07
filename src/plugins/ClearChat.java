package plugins;

import interfaces.ButtonPlugin;
import interfaces.ChatProvider;

public class ClearChat implements ButtonPlugin {
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
