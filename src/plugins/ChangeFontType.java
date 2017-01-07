package plugins;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

import interfaces.ChatProvider;
import interfaces.ComboBoxPlugin;

public class ChangeFontType implements ComboBoxPlugin {

	private ChatProvider cp;

	@Override
	public String[] getComboBoxList() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	}

	@Override
	public void ComboBoxClicked(ActionEvent evt) {
		// Change Fonttype to chosen font
		JComboBox cb = (JComboBox) evt.getSource();
		String fontName = (String) cb.getSelectedItem();
		int fontSize = cp.getChatField().getFont().getSize();
		int fontType = cp.getChatField().getFont().getStyle();

		// get the correct TextField
		cp.getChatField().setFont(new Font(fontName, fontType, fontSize));		
	}

	@Override
	public void register(ChatProvider chat) {
		this.cp = chat;
	}
}
