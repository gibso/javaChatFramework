package interfaces;

import java.awt.event.ActionEvent;

public interface ComboBoxPlugin {

	String[] getComboBoxList();

	void ComboBoxClicked(ActionEvent evt);

	void register(ChatProvider chat);
}
