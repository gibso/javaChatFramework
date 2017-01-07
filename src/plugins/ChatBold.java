package plugins;

import java.awt.Font;

import interfaces.ButtonPlugin;
import interfaces.ChatProvider;

public class ChatBold implements ButtonPlugin {
	private ChatProvider cp;

	@Override
	public String getButtonText() {
		return "Bold";
	}

	@Override
	public void ButtonClicked() {
		int fontSize = cp.getChatField().getFont().getSize();
		String fontName = cp.getChatField().getFont().getName();
		cp.getChatField().setFont(new Font(fontName, Font.BOLD, fontSize));
	}

	@Override
	public void register(ChatProvider chat) {
		this.cp = chat;
	}
}
