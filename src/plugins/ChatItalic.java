package plugins;

import java.awt.Font;

import interfaces.ButtonPlugin;
import interfaces.ChatProvider;

public class ChatItalic implements ButtonPlugin {
	private ChatProvider cp;

	@Override
	public String getButtonText() {
		return "Italic";
	}

	@Override
	public void ButtonClicked() {
		int fontSize = cp.getChatField().getFont().getSize();
		String fontName = cp.getChatField().getFont().getName();
		cp.getChatField().setFont(new Font(fontName, Font.ITALIC, fontSize));
	}

	@Override
	public void register(ChatProvider chat) {
		this.cp = chat;
	}
}
