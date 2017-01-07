package plugins;

import java.awt.Font;

import interfaces.ButtonPlugin;
import interfaces.ChatProvider;

public class ChatNormal implements ButtonPlugin {
	private ChatProvider cp;

	@Override
	public String getButtonText() {
		return "Normal";
	}

	@Override
	public void ButtonClicked() {
		int fontSize = cp.getChatField().getFont().getSize();
		String fontName = cp.getChatField().getFont().getName();
		cp.getChatField().setFont(new Font(fontName, Font.PLAIN, fontSize));
	}

	@Override
	public void register(ChatProvider chat) {
		this.cp = chat;
	}
}
