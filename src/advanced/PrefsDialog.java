package advanced;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class PrefsDialog extends JDialog {
private JDialog dialog;

private JButton okbutton;
private JButton cancelButton;
private JTextField username;
private JPasswordField password;
private PreferenceListener prefListener;
private SpinnerNumberModel SNmodel;
private JSpinner port;

public PrefsDialog(JFrame parent)
{super(parent,"prefdialog",false);
SNmodel=new SpinnerNumberModel(3306, 0, 9999, 1);
username=new JTextField(10);
password=new JPasswordField(20);
password.setEchoChar('.');
port=new JSpinner(SNmodel);

cancelButton=new JButton("Cancel");
cancelButton.addActionListener(new ActionListener() {
	

	public void actionPerformed(ActionEvent e) {
    
    dialog.setVisible(false);
    setVisible(false);
   }
});

okbutton=new JButton("OK");
okbutton.addActionListener(new ActionListener() {
	

	public void actionPerformed(ActionEvent e) {
    int value=(Integer)port.getValue();
    if(prefListener != null)
    {  prefListener.preferences(username.getText(), new String(password.getPassword()), value);                       }
   
    
    setVisible(false);
   }
});



   //setting the layout///
setLayout(new GridBagLayout());
GridBagConstraints gc=new GridBagConstraints();
 
/////firstrow////
gc.gridx=0;
gc.gridy=0;
gc.weightx=1;
gc.weighty=0.5;
gc.fill=GridBagConstraints.NONE;
add(new JLabel("Username"),gc);


gc.gridx++;
add(username,gc);

///next row////

gc.gridx=0;
gc.gridy=1;
gc.weightx=1;
gc.weighty=0.5;
gc.fill=GridBagConstraints.NONE;
add(new JLabel("password"),gc);


gc.gridx++;
add(password,gc);




///next row/////

gc.gridx=0;
gc.gridy=2;
gc.weightx=1;
gc.weighty=0.5;
gc.fill=GridBagConstraints.NONE;
add(new JLabel("port"),gc);


gc.gridx++;
add(port,gc);
//////next row//////////

gc.gridx=0;
gc.gridy=3;
gc.weightx=1;
gc.weighty=1.5;
gc.fill=GridBagConstraints.NONE;
Insets ins=new Insets(0, 40, 0, 0);
gc.insets=ins;
add(cancelButton,gc);

ins=new Insets(0,0 , 0, 28);
gc.insets=ins;
gc.gridx++;
add(okbutton,gc);


dialog =new JDialog();	
setSize(new Dimension(400, 300));
setLocation(550, 300);
}

public void setpreferencelistener(PreferenceListener preferenceListener) {
	this.prefListener=preferenceListener;
	
	
}
 ///default keys are set so that this application can save username passwords between runs of application//
public void setDefaultKeys(String user,String Password,int port){
	username.setText(user);
	password.setText(Password);
	this.port.setValue(port);
	
}
}
