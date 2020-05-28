package swissCalc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrationScreen {

	private JFrame frmMhtsVol;
	private JTextField playerFNameIn;
	private JTextField playerLNameIn;
	private JTextField playerIDIn;
	private JTextField playerIDRemoveIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationScreen window = new RegistrationScreen();
					window.frmMhtsVol.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistrationScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMhtsVol = new JFrame();
		frmMhtsVol.setTitle("MHTS Vol. 0.1");
		frmMhtsVol.setBounds(100, 100, 586, 453);
		frmMhtsVol.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMhtsVol.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("50dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("8dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(9dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		

		
		//headJudge.menu();
		
		JLabel PlayerFnameLabel = new JLabel("First Name");
		frmMhtsVol.getContentPane().add(PlayerFnameLabel, "2, 6, right, default");
		
		playerFNameIn = new JTextField();
		frmMhtsVol.getContentPane().add(playerFNameIn, "4, 6, fill, default");
		playerFNameIn.setColumns(10);
		
		JLabel playerLNameLabel = new JLabel("Last Name");
		frmMhtsVol.getContentPane().add(playerLNameLabel, "2, 8, right, default");
		
		playerLNameIn = new JTextField();
		frmMhtsVol.getContentPane().add(playerLNameIn, "4, 8, fill, default");
		playerLNameIn.setColumns(10);
		
		JLabel playerIDLabel = new JLabel("Player ID");
		frmMhtsVol.getContentPane().add(playerIDLabel, "2, 10, right, default");
		
		playerIDIn = new JTextField();
		frmMhtsVol.getContentPane().add(playerIDIn, "4, 10, fill, default");
		playerIDIn.setColumns(10);
		
		JButton playerAddButton = new JButton("Add Player");
		playerAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String playerFname = playerFNameIn.getText();
				String playerLname = playerLNameIn.getText();
				String playerID = playerIDIn.getText();
				
				PlayerRegistration.newPlayerGUI(roster, playerFname, playerLname, playerID);
				//playerList.ensureIndexIsVisible(roster.playerList.size());
				
			}
		});
		frmMhtsVol.getContentPane().add(playerAddButton, "4, 12");
		
		JLabel playerRemoveIDLabel = new JLabel("Player ID");
		frmMhtsVol.getContentPane().add(playerRemoveIDLabel, "2, 14, right, default");
		
		playerIDRemoveIn = new JTextField();
		frmMhtsVol.getContentPane().add(playerIDRemoveIn, "4, 14, fill, default");
		playerIDRemoveIn.setColumns(10);
		
		JButton playerRemoveButton = new JButton("Remove Player");
		frmMhtsVol.getContentPane().add(playerRemoveButton, "4, 16");
		
		JLabel VersionInfo = new JLabel("Version Info copyright text");
		frmMhtsVol.getContentPane().add(VersionInfo, "2, 18");
		
		JButton startTourneyButton = new JButton("Start Tournament");
		frmMhtsVol.getContentPane().add(startTourneyButton, "6, 18");
	}

}
