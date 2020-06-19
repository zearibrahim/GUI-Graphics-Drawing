import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUIGridLayout extends JFrame {

	public GUIGridLayout() {
		setTitle("A simple GUI with a button"); 
		JPanel p = new JPanel(); 
		p.setLayout(new GridBagLayout()); 
		GridBagConstraints c = new GridBagConstraints(); 
		CustomGraphicsGrid CGG = new CustomGraphicsGrid();
		JButton b = new JButton ("Press Me!");

		//Add all your components (Labels, Buttons etc.. here)

		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 0;
		p.add(new JLabel("This GUI uses a GridBagLayout to manage the components"),c);

		c.fill = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 0;
		p.add(b,c);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Call the graphics component and draw a line
				CGG.getGraphics().drawLine(5, 100, 400, 400);
			}
		});

		c.fill = GridBagConstraints.CENTER;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		p.add(CGG,c); //<-- this is a custom component to draw a grid

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(p); 
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
