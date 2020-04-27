package lunchselect;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Lunch_Main extends JFrame implements ActionListener {

	private JPanel contentPane;

	private JTextField tf_result;

	JButton add_btn = new JButton("�߰�");

	JButton delete_btn = new JButton("����");

	JButton start_btn = new JButton("�̱�");

	List list = new List();

	String[] str;

	JButton search_btn = new JButton("�˻�");

	public Lunch_Main() {

		config();

		actionstart();
		
		setTitle("���ɸ޴� �̱� ���α׷�"); // Ÿ��Ʋ �߰�
		setResizable(false); // â ũ�� ����

	}

	private void actionstart() {

		add_btn.addActionListener(this);

		delete_btn.addActionListener(this);

		start_btn.addActionListener(this);

		search_btn.addActionListener(this);

	}

	private void config() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 700, 550);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		add_btn.setBounds(515, 468, 62, 23);

		contentPane.add(add_btn);

		add_btn.setFont(new Font("���� ���", Font.BOLD, 12));
		
		delete_btn.setBounds(589, 468, 62, 23);

		contentPane.add(delete_btn);

		delete_btn.setFont(new Font("���� ���", Font.BOLD, 12));
		
		start_btn.setFont(new Font("���� ���", Font.BOLD, 18));

		start_btn.setBounds(180, 382, 156, 74);

		contentPane.add(start_btn);

		tf_result = new JTextField();

		tf_result.setFont(new Font("���� ���", Font.BOLD, 20));

		tf_result.setBackground(Color.PINK);

		tf_result.setEditable(false);

		tf_result.setHorizontalAlignment(SwingConstants.CENTER);

		tf_result.setBounds(167, 178, 184, 74);

		contentPane.add(tf_result);

		tf_result.setColumns(10);

		JLabel label = new JLabel("������ ���� �޴���?");

		label.setFont(new Font("���� ���", Font.BOLD, 20));

		label.setHorizontalAlignment(SwingConstants.CENTER);

		label.setBounds(168, 105, 183, 63);

		contentPane.add(label);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(484, 50, 190, 406);

		contentPane.add(scrollPane);

		list.setFont(new Font("���� ���", Font.BOLD, 18));

		scrollPane.setViewportView(list);

		add();

		setVisible(true);

		search_btn.setBounds(214, 289, 97, 23);

		contentPane.add(search_btn);

		search_btn.setVisible(false);

	}

	private void add() {

		list.add("������ġ");

		list.add("����");

		list.add("û����");

		list.add("ȫ��Ұ��");

		list.add("�н�");

		list.add("���������̳�");

		list.add("���");

		list.add("�߱���");

	}

	@Override

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == add_btn) {

			System.out.println("add��ư Ŭ��");

			String str = JOptionPane.showInputDialog("�߰��� �޴��� ���� �ּ���");

			if (str.equals("") || str.equals(" ") || str.equals("  ")) {

				JOptionPane.showMessageDialog(null, "���� �Է��� �ּ���!");

			} else {

				list.add(str);
			}

		} else if (e.getSource() == delete_btn) {

			System.out.println("������ư Ŭ��");

			int i = list.getSelectedIndex();

			list.remove(i);

			JOptionPane.showMessageDialog(null, "������ �����߽��ϴ�.");

		} else if (e.getSource() == start_btn) {

			search_btn.setVisible(false);

			System.out.println("���۹�ư Ŭ��");

			start_btn.setEnabled(false);

			select();

		} else if (e.getSource() == search_btn) {

			System.out.println("�˻���ư Ŭ��");

			try {

				Desktop.getDesktop().browse(new URI("https://www.google.co.kr/search?"

						+ "q=�뱸��+" + tf_result.getText() + "&oq=�뱸��+" + tf_result.getText()

						+ "&aqs=chrome"

						+ "..69i57.4885j0j4&sourceid=chrome&ie=UTF-8"));

			} catch (IOException e2) {

				e2.printStackTrace();

			} catch (URISyntaxException e3) {

				e3.printStackTrace();
			}

		}

	}

	private void select() {

		str = new String[list.getItemCount()];

		str = list.getItems();

		int[] numArr = new int[str.length];

		for (int i = 0; i < numArr.length; i++) {

			numArr[i] = i;

		}

		for (int i = 0; i < 871125; i++) {

			int n = (int) (Math.random() * str.length);

			int temp = numArr[0];

			numArr[0] = numArr[n];

			numArr[n] = temp;

		}

		Timer m_timer = new Timer();

		TimerTask m_task1 = new TimerTask() {

			int i = 5;

			@Override

			public void run() {

				if (i > 0) {

					tf_result.setText(String.valueOf(i));

					i--;

				} else {

					m_timer.cancel();

					tf_result.setText(str[numArr[0]]);

					search_btn.setVisible(true);

					start_btn.setEnabled(true);

				}

			}

		};

		m_timer.schedule(m_task1, 100, 1000);

	}

	public static void main(String[] args) {

		new Lunch_Main();

	}

}
