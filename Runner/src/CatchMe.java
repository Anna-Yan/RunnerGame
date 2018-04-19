import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.omg.CORBA.INITIALIZE;

public class CatchMe extends JFrame implements ActionListener, Runnable, KeyListener {

	private Icon man = new ImageIcon("99.png");
	private Icon man2 = new ImageIcon("99.png");
	private JLabel manLabel = new JLabel(man);
	private JTextField scoretext = new JTextField("Score: 0");
	private Icon stones[] = { new ImageIcon("23.png"), new ImageIcon("23.png"), new ImageIcon("st1.png"),
			new ImageIcon("159.png")};
	private JLabel stlable = new JLabel();
	private JButton start = new JButton("Start");
	private Icon bkg = new ImageIcon("welocomescreen.jpg");
	private Icon tree = new ImageIcon("tree.png");
	private JLabel back = new JLabel(bkg);
	private JLabel over = new JLabel("GAME OVER");
	private JButton runjb = new JButton("Run Again");
	int r = 0;
	int index = 0;
	private int score = 0;

	public CatchMe() {
		setLayout(null);

		add(start);
		start.setBounds(300, 150, 200, 100);
		start.setBorderPainted(false);
		start.setOpaque(false);
		start.setContentAreaFilled(false);
		start.setFont(new Font("Sylfaen", Font.BOLD, 70));
		start.setForeground(Color.black);
		start.addActionListener(this);

		add(stlable);
		stlable.setBounds(800, 280, stones[0].getIconHeight(), stones[0].getIconWidth());
		// stlable.setIcon(stones[0]);

		add(over);
		over.setBounds(150, 100, 800, 100);
		over.setFont(new Font("Sylfaen", Font.BOLD, 80));
		over.setVisible(false);

		// add(treelab);

		add(runjb);
		runjb.setBounds(200, 400, 400, 100);
		runjb.addActionListener(this);
		runjb.setVisible(false);
		runjb.setBorderPainted(false);
		runjb.setOpaque(false);
		runjb.setContentAreaFilled(false);
		runjb.setFont(new Font("Sylfaen", Font.BOLD, 70));
		runjb.setForeground(Color.black);

		add(manLabel);
		manLabel.setBounds(0, 220, man2.getIconWidth(), man2.getIconHeight());
		manLabel.setVisible(false);

		add(scoretext);
		scoretext.setBounds(400, 10, 300, 100);
		scoretext.setFont(new Font("Sylfaen", Font.BOLD, 50));
		scoretext.setForeground(Color.DARK_GRAY);
		scoretext.setEditable(false);
		scoretext.setDisabledTextColor(Color.DARK_GRAY);
		scoretext.setOpaque(false);
		scoretext.setBorder(null);
		start.addKeyListener(this);
		scoretext.addKeyListener(this);

		add(back);
		back.setBounds(0, 0, 800, 600);

		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);

	}

	int x = 800;
	long k = 50;
	int gg;

	@Override
	public void run() {

		stlable.setIcon(stones[(int) (0 + Math.random() * 4)]);

		for (int i = 0; i < 500; i++) {
			gg++;

			if (i == 450) {
				x = 800;
				i = 0;
				stlable.setIcon(stones[(int) (0 + Math.random() * 4)]);
				k -= 1;
			}
			if (k < 18) {
				k = (long) 18;
			}
			x -= 2;
			try {
				Thread.sleep(k / 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (stlable.getIcon() == stones[2]) {
				stlable.setBounds(x, 300, 200, 200);
				score += 1;

				scoretext.setText("Score: " + score + "");

				System.out.println(index);
			} else if (stlable.getIcon() == stones[3]) {
				stlable.setBounds(x, 250, 200, 200);
				score += 1;

				scoretext.setText("Score: " + score + "");

				System.out.println(index);
			} else {
				stlable.setBounds(x, 280, 200, 200);
				score += 1;

				scoretext.setText("Score: " + score + "");

				System.out.println(index);
			}

			if (index < 80 && x < 110 && x > 10) {
				over.setVisible(true);
				man = new ImageIcon("start.png");
				manLabel.setIcon(man);
				bkg = new ImageIcon("over.png");
				back.setIcon(bkg);
				stlable.setVisible(false);
				manLabel.setVisible(false);
				start.setVisible(false);
				scoretext.setForeground(Color.red);
				scoretext.setBounds(250, 200, 300, 100);
				runjb.setVisible(true);
				x = 800;
				k = 50;
				gg = 0;
				break;
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == start) {
			Thread stones1 = new Thread(this);
			stones1.start();

			man = new ImageIcon("8888.gif");
			manLabel.setIcon(man);
			manLabel.setVisible(true);
			bkg = new ImageIcon("8.gif");
			back.setIcon(bkg);
			start.setVisible(false);
		}

		if (e.getSource() == runjb) {
			Thread stones1 = new Thread(this);
			stones1.start();
			man = new ImageIcon("8888.gif");
			manLabel.setIcon(man);
			manLabel.setVisible(true);
			bkg = new ImageIcon("8.gif");
			back.setIcon(bkg);
			r = 0;
			index = 0;
			score = 0;
			runjb.setVisible(false);
			stlable.setVisible(true);

			over.setVisible(false);
			scoretext.setText("Score: 0");
			scoretext.setBounds(400, 10, 300, 100);
			scoretext.setForeground(Color.DARK_GRAY);

		}

	}

	

	@Override
	public void keyPressed(KeyEvent arg0) {

		if (arg0.getKeyCode() == KeyEvent.VK_UP ||arg0.getKeyCode() == KeyEvent.VK_SPACE) {
			
			Thread h = new Thread(new Runnable() {

				@Override
				public void run() {
					for (int i = 0; i < 150; i++) {

						try {
							Thread.sleep(2);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						manLabel.setIcon(man2);
						manLabel.setBounds(0, 220 - i, man2.getIconWidth(), man2.getIconHeight());
						r = 220 - i;
						index = i + man2.getIconHeight();

					}
					for (int i = 0; i < 150; i++) {
						try {
							Thread.sleep(2);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						manLabel.setBounds(0, r + i, man2.getIconWidth(), man2.getIconHeight());
						manLabel.setIcon(man);
						index = -i + man2.getIconHeight();

					}

				}

			});
			h.start();
			

		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
