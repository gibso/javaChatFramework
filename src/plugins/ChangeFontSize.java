package plugins;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;

import javax.swing.JColorChooser;
import javax.swing.JComboBox;

import interfaces.ButtonPlugin;
import interfaces.ChatProvider;
import interfaces.ComboBoxPlugin;

public class ChangeFontSize implements ComboBoxPlugin {

	private ChatProvider cp;

	@Override
	public String[] getComboBoxList() {
		String num[] = new String[100];
		for(int i=0; i<100; i++){
			num[i] = Integer.toString(i);
		}
		return num;
	}

	@Override
	public void ComboBoxClicked(ActionEvent evt) {
		// Change Fonttype to chosen font
		JComboBox cb = (JComboBox) evt.getSource();
		int fontSize = Integer.parseInt((String) cb.getSelectedItem());
		String fontName = cp.getChatField().getFont().getName();
		int fontType = cp.getChatField().getFont().getStyle();

		// get the correct TextField
		cp.getChatField().setFont(new Font(fontName, fontType, fontSize));		
	}

	@Override
	public void register(ChatProvider chat) {
		this.cp = chat;
	}
}
