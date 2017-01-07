package plugins;

import java.awt.Color;

import javax.swing.JColorChooser;

import interfaces.ButtonPlugin;
import interfaces.ChatProvider;

public class ChangeChatBgColor implements ButtonPlugin {

	private ChatProvider cp;
	
	@Override
	public String getButtonText() {
		return "Chat BG-Color";
	}

	@Override
	public void ButtonClicked() {
		Color initialBackground = this.cp.getChatField().getBackground();

		Color background = JColorChooser.showDialog(null, "Change Button Background",
				initialBackground);
		if (background != null) {
			this.cp.getChatField().setBackground(background);
		}
	}

	@Override
	public void register(ChatProvider chat) {
		this.cp = chat;
	}	
}
