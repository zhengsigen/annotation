package cn.zhengsigen.annotation;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AnnotationTestFile extends JFrame {


	public  AnnotationTestFile(int i) {}
	/**
	 * Launch the application.

	 */
	@TestX
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnnotationTestFile frame = new AnnotationTestFile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	private JTextArea recieveMsgText;

	/**
	 * Create the frame.
	 */
	public AnnotationTestFile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 408);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 420, 249);
		getContentPane().add(scrollPane);

		recieveMsgText = new JTextArea();
		scrollPane.setViewportView(recieveMsgText);

		JPanel panel = new JPanel();
		panel.setBounds(10, 269, 420, 91);
		getContentPane().add(panel);
		panel.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 5, 420, 46);
		panel.add(textArea);

		JButton button = new JButton("\u53D1\u9001");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("���" + textArea.getText());
				// recieveMsgText.append(textArea.getText()+"\n");
				recieve("СС", textArea.getText());
				textArea.setText("");
			}
		});
		button.setBounds(311, 58, 93, 23);
		panel.add(button);
	}

	@TestX
	public void recieve(String name, String msg) {
		String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		recieveMsgText.append(now + "\t" + name + "\n" + msg + "\n\n");
	}
}