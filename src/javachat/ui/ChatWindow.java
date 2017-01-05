package javachat.ui;

import java.awt.GraphicsEnvironment;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javachat.network.Client;
import plugins.ClearChat;
import javachat.JavaChat;
import javax.swing.BoundedRangeModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ChatWindow extends javax.swing.JFrame implements ChatProvider{


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.ButtonGroup buttonGroupModeType;
	
	// #if clearChat
	private javax.swing.JButton jButtonClear;
	// #endif
	
	private javax.swing.JButton jButtonSend;
	
	// #if setNickname
	private javax.swing.JButton jButtonUpdateName;
	// #endif
	
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabelHost;
	private javax.swing.JLabel jLabelPort;
	private javax.swing.JRadioButton jRadioButtonClient;
	private javax.swing.JRadioButton jRadioButtonServer;
	private javax.swing.JScrollPane jScrollPane1;
	
	private javax.swing.JTextArea jTextAreaChat;
	
	private javax.swing.JTextField jTextFieldHostname;
	private javax.swing.JTextField jTextFieldMessage;
	private javax.swing.JTextField jTextFieldName;
	private javax.swing.JTextField jTextFieldPort;
	private javax.swing.JToggleButton jToggleButtonOnline;
	// End of variables declaration//GEN-END:variables

	// Feature variables
	
	// #if changeChatBgColor
	private javax.swing.JButton jButtonChatBgColor;
	private javax.swing.JColorChooser jColorChooserChatBgColor;
	// #endif
	
	// #if changeSize
	private javax.swing.JTextField jTextFieldFontsize;
	private javax.swing.JButton jButtonFontsize;
	// #endif
	
	// #if changeType
	private javax.swing.JComboBox jComboBoxFonttype;
	// #endif
	
	// #if changeStyle
	private javax.swing.JButton jButtonBold;
	private javax.swing.JButton jButtonItalic;
	// #endif
	
	// #if setAbout
	private javax.swing.ButtonGroup buttonGroupGender;
	private javax.swing.JRadioButton jRadioButtonMale;
	private javax.swing.JRadioButton jRadioButtonFemale;
	private javax.swing.JTextField jTextFieldDate;
	private javax.swing.JTextField jTextFieldEMail;
	private javax.swing.JLabel jLabelGender;
	private javax.swing.JLabel jLabelBirthday;
	private javax.swing.JLabel jLabelEMail;
	// #endif
	
	// framework variable
	private Plugin plugin;

	/**
	 * Creates new form ChatWindow
	 */
	public ChatWindow(Plugin p) {
		this.plugin = p;
		p.register(this);
		initComponents();
		this.setTitle("Java Chat");
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		
	

		buttonGroupModeType = new javax.swing.ButtonGroup();
		jRadioButtonServer = new javax.swing.JRadioButton();
		jRadioButtonClient = new javax.swing.JRadioButton();
		jLabelHost = new javax.swing.JLabel();
		jTextFieldHostname = new javax.swing.JTextField();
		jLabelPort = new javax.swing.JLabel();
		jTextFieldPort = new javax.swing.JTextField();
		jToggleButtonOnline = new javax.swing.JToggleButton();
		jTextFieldMessage = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		
		jTextAreaChat = new javax.swing.JTextArea();
		
		jButtonSend = new javax.swing.JButton();
		jTextFieldName = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		
		
		// framework- plugin button
		JButton button = new JButton();
		
		button.setText(plugin.getButtonText());
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.ButtonClicked();
			}
		});
		
		
		// #if clearChat
		jButtonClear = new javax.swing.JButton();
		
		jButtonClear.setText(this.plugin.getButtonText());
		jButtonClear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonClearActionPerformed(evt);
			}
		});
		// #endif
		
		// #if setNickname
		jButtonUpdateName = new javax.swing.JButton();

		jButtonUpdateName.setText("Update Name");
		jButtonUpdateName.setEnabled(false);
		jButtonUpdateName.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonUpdateNameActionPerformed(evt);
			}
		});
		// #endif
		
		// #if changeChatBgColor
		jButtonChatBgColor = new javax.swing.JButton();
		jButtonChatBgColor.setText("Chat BG-Color");

		jButtonChatBgColor.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				Color initialBackground = jTextAreaChat.getBackground();

				Color background = javax.swing.JColorChooser.showDialog(null, "Change Button Background",
						initialBackground);
				if (background != null) {
					jTextAreaChat.setBackground(background);
				}
			}
		});
		// #endif
		
		
		// #if changeSize
		jTextFieldFontsize = new javax.swing.JTextField();
		jButtonFontsize = new javax.swing.JButton();
		
		jTextFieldFontsize.setText("12");
		jButtonFontsize.setText("Set Size");
		jButtonFontsize.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonFontsizeActionPerformed(evt);
			}
		
			private void jButtonFontsizeActionPerformed(ActionEvent evt) {

				// Change Fontsize to chosen Number
				int newFontsize = Integer.parseInt(jTextFieldFontsize.getText());

				// get the correct TextField
				Font chatFont = jTextAreaChat.getFont();
				jTextAreaChat.setFont(new Font(chatFont.getName(), Font.PLAIN, newFontsize));
			}
		});
		// #endif
				
		// #if changeType
		String List[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		jComboBoxFonttype = new javax.swing.JComboBox(List);
		
		jComboBoxFonttype.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBoxChangeType(evt);
			}
			private void jComboBoxChangeType(ActionEvent evt) {
				// Change Fonttype to chosen font
				JComboBox cb = (JComboBox) evt.getSource();
				String fontName = (String) cb.getSelectedItem();
				int fontsize = jTextAreaChat.getFont().getSize();

				// get the correct TextField
				jTextAreaChat.setFont(new Font(fontName, Font.PLAIN, fontsize));
			}
		});
		// #endif

		// #if changeStyle
		jButtonBold = new javax.swing.JButton();
		jButtonItalic = new javax.swing.JButton();
		
		jButtonBold.setText("B");
		jButtonBold.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonBoldActionPerformed(evt);
			}
			private void jButtonBoldActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
			}
		});

		jButtonItalic.setText("Italic");
		jButtonItalic.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonItalicActionPerformed(evt);
			}
			private void jButtonItalicActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
			}
		});
		// #endif	
		
		// #if setAbout
		jLabelBirthday = new javax.swing.JLabel();
		jLabelGender = new javax.swing.JLabel();
		jLabelEMail = new javax.swing.JLabel();
		buttonGroupGender = new javax.swing.ButtonGroup();
		jRadioButtonMale = new javax.swing.JRadioButton();
		jRadioButtonFemale = new javax.swing.JRadioButton();
		jTextFieldEMail = new javax.swing.JTextField();
		jTextFieldDate = new javax.swing.JTextField();
		
		buttonGroupGender.add(jRadioButtonMale);
		jRadioButtonMale.setText("Male");
		buttonGroupGender.add(jRadioButtonFemale);
		jRadioButtonFemale.setSelected(true);
		jRadioButtonFemale.setText("Female");
		jLabelGender.setText("Gender:");
		jLabelBirthday.setText("Birthday:");
		jLabelEMail.setText("Email-Address:");
		//  #endif

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		buttonGroupModeType.add(jRadioButtonServer);
		jRadioButtonServer.setText("Server");
		jRadioButtonServer.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButtonServerActionPerformed(evt);
			}
		});

		buttonGroupModeType.add(jRadioButtonClient);
		jRadioButtonClient.setSelected(true);
		jRadioButtonClient.setText("Client");
		jRadioButtonClient.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButtonClientActionPerformed(evt);
			}
		});

		jLabelHost.setText("Host:");
		jTextFieldHostname.setText("localhost");
		jLabelPort.setText("Port:");
		jTextFieldPort.setText("12345");

		jToggleButtonOnline.setText("Connect");
		jToggleButtonOnline.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jToggleButtonOnlineActionPerformed(evt);
			}
		});

		jTextFieldMessage.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextFieldMessageKeyTyped(evt);
			}
		});

		jTextAreaChat.setColumns(20);
		jTextAreaChat.setEditable(false);
		jTextAreaChat.setRows(5);
		jScrollPane1.setViewportView(jTextAreaChat);

		jButtonSend.setText("Send");
		jButtonSend.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSendActionPerformed(evt);
			}
		});

		jTextFieldName.setText("Unknown");

		jLabel1.setText("Name:");
		
		
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		GroupLayout.SequentialGroup pluginGroup = layout.createSequentialGroup();
		
		pluginGroup.addComponent(button);
		
		
		GroupLayout.ParallelGroup horizontal = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1)
				.addGroup(layout.createSequentialGroup().addComponent(jTextFieldMessage)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButtonSend)
						.addPreferredGap(
								javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						
						)
				.addGroup(layout.createSequentialGroup()
						
						// #if changeChatBgColor
						.addComponent(jButtonChatBgColor)
						// #endif
						
						// #if changeSize
						.addComponent(jTextFieldFontsize)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jButtonFontsize)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						// #endif
						
						// #if changeType
						.addComponent(jComboBoxFonttype)
						// #endif
						
						// #if changeStyle
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jButtonBold)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jButtonItalic)
						// #endif
						
						)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										layout.createSequentialGroup().addComponent(jLabel1)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jTextFieldName))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										layout.createSequentialGroup()
										
												// #if setAbout
												.addComponent(jLabelGender).addComponent(jRadioButtonMale)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jRadioButtonFemale)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10,
														Short.MAX_VALUE)
												.addComponent(jLabelBirthday)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10,
														Short.MAX_VALUE)
												.addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE,
														221, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10,
														Short.MAX_VALUE)
												.addComponent(jLabelEMail)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10,
														Short.MAX_VALUE)
												.addComponent(jTextFieldEMail, javax.swing.GroupLayout.PREFERRED_SIZE,
														221, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10,
														Short.MAX_VALUE)
												// #endif
												
										)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
										.addComponent(jRadioButtonServer)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jRadioButtonClient)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255,
												Short.MAX_VALUE)
										.addComponent(jLabelHost)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jTextFieldHostname, javax.swing.GroupLayout.PREFERRED_SIZE, 221,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabelPort)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						
						.addGroup(pluginGroup)
						
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								
								// #if setNickname
								.addComponent(jButtonUpdateName, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								// #endif
								
								.addComponent(jToggleButtonOnline, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
);
		
		GroupLayout.ParallelGroup vertical = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jRadioButtonServer).addComponent(jRadioButtonClient)
								.addComponent(jToggleButtonOnline)
								.addComponent(jTextFieldHostname, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabelHost).addComponent(jLabelPort)
								.addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1)
								
								// #if setNickname
								.addComponent(jButtonUpdateName)
								// #endif
								
								)
						
						// #if setAbout
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelGender)
								.addComponent(jRadioButtonMale)
								.addComponent(jRadioButtonFemale)
								.addComponent(jLabelBirthday)
								.addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabelEMail).
								addComponent(jTextFieldEMail,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						// #endif
						
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jTextFieldMessage, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonSend)
								
								
								)
						
						.addGroup(pluginGroup)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								
								// #if changeChatBgColor
								.addComponent(jButtonChatBgColor)
								// #endif
								
								// #if changeSize
								.addComponent(jTextFieldFontsize, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonFontsize)
								// #endif
								
								// #if changeType
								.addComponent(jComboBoxFonttype)
								// #endif
								
								// #if changeStyle
								.addComponent(jButtonBold)
								.addComponent(jButtonItalic)
								// #endif
								
								
								));
		
		
		horizontal.addComponent(button);
		vertical.addComponent(button);
		
		
		layout.setHorizontalGroup(horizontal);
		layout.setVerticalGroup(vertical);
		pack();
	
	}// </editor-fold>//GEN-END:initComponents

	private void jRadioButtonServerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jRadioButtonServerActionPerformed
		jTextFieldHostname.setEnabled(false);
	}// GEN-LAST:event_jRadioButtonServerActionPerformed

	private void jRadioButtonClientActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jRadioButtonClientActionPerformed
		jTextFieldHostname.setEnabled(true);
	}// GEN-LAST:event_jRadioButtonClientActionPerformed

	private void jToggleButtonOnlineActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jToggleButtonOnlineActionPerformed
		if (jToggleButtonOnline.isSelected()) {
			boolean connected = false;
			String name = jTextFieldName.getText();

			// #if setAbout
			String birthdayStr = jTextFieldDate.getText();
			DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
			try {
				Date birthday = format.parse(birthdayStr);
				String gender = "";
				if (jRadioButtonMale.isSelected())
					gender = " (m) ";
				if (jRadioButtonFemale.isSelected())
					gender = " (f) ";

				int age = new Date().getYear() - birthday.getYear();
				name = name + gender + age;

			} catch (ParseException e) {
				System.out.println("exception: " + e.getMessage());
			}
			// #endif

			// Connect
			if (jRadioButtonServer.isSelected()) {
				// Server
				connected = JavaChat.startServer(jTextFieldPort.getText(), name);
			} else {
				// Client
				connected = JavaChat.startClient(jTextFieldHostname.getText(), jTextFieldPort.getText(), name);
			}

			lockServerDetails(connected);
			jToggleButtonOnline.setSelected(connected);
		} else {
			// Disconnect the client/server
			JavaChat.disconnect();
			// Unlock the server details so we can change them before connecting
			// again
			lockServerDetails(false);
		}
	}// GEN-LAST:event_jToggleButtonOnlineActionPerformed

	private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonSendActionPerformed
		Client client = JavaChat.getClient();
		if (client != null && client.isConnected()) {
			String msg = jTextFieldMessage.getText();
			if (!msg.equals("")) {
				jTextFieldMessage.setText("");
				client.sendMsg(msg);
			}
		} else {
			println("Not connected: Unable to send message.");
		}
	}// GEN-LAST:event_jButtonSendActionPerformed

	private void jTextFieldMessageKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextFieldMessageKeyTyped
		if (evt.getKeyChar() == '\n') {
			jButtonSend.doClick();
		}
	}// GEN-LAST:event_jTextFieldMessageKeyTyped

	private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonClearActionPerformed
		jTextAreaChat.setText("");
	}// GEN-LAST:event_jButtonClearActionPerformed

	private void jButtonUpdateNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonUpdateNameActionPerformed
		Client client = JavaChat.getClient();
		if (client != null) {
			String name = jTextFieldName.getText();

			// #if setAbout
			String birthdayStr = jTextFieldDate.getText();
			DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
			try {
				Date birthday = format.parse(birthdayStr);
				String gender = "";
				if (jRadioButtonMale.isSelected())
					gender = " (m) ";
				if (jRadioButtonFemale.isSelected())
					gender = " (f) ";

				int age = new Date().getYear() - birthday.getYear();
				name = name + gender + age;
				client.setName(name);
			} catch (ParseException e) {
				System.out.println("exception: " + e.getMessage());
			}
			// #else
//@			client.setName(name);
			// #endif

		}
	}// GEN-LAST:event_jButtonUpdateNameActionPerformed

	private void lockServerDetails(boolean lock) {
		jRadioButtonServer.setEnabled(!lock);
		jRadioButtonClient.setEnabled(!lock);
		jTextFieldHostname.setEnabled(!lock && !jRadioButtonServer.isSelected());
		jTextFieldPort.setEnabled(!lock);
		
		// #if setNickname
		jButtonUpdateName.setEnabled(lock);
		// #endif
		
	}

	/**
	 * Resets form when an unexpected disconnect happens
	 */
	public void disconnected() {
		lockServerDetails(false);
		jToggleButtonOnline.setSelected(false);
	}

	public void print(final String text) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				jTextAreaChat.append(text);

				JScrollBar scrollBar = jScrollPane1.getVerticalScrollBar();
				boolean scrollBarAtBottom = isScrollBarFullyExtended(scrollBar);
				if (scrollBarAtBottom) {
					scrollToBottom(jTextAreaChat);
				}
			}
		});
	}

	public static boolean isScrollBarFullyExtended(JScrollBar vScrollBar) {
		BoundedRangeModel model = vScrollBar.getModel();
		int bottomPos = model.getExtent() + model.getValue() + 10;
		int maxPos = model.getMaximum();
		return bottomPos >= maxPos;
	}

	public static void scrollToBottom(JComponent component) {
		Rectangle visibleRect = component.getVisibleRect();
		visibleRect.y = component.getHeight() - visibleRect.height;
		component.scrollRectToVisible(visibleRect);
	}

	public void println(final String text) {
		print(text + "\n");
	}

	@Override
	public JTextArea getChatField() {
		return jTextAreaChat;
	}
}