package jframe;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.systemService;

import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class StoreJFrame extends JFrame {
	final JDesktopPane desktopPane = new JDesktopPane();
	private JPanel contentPane;
	systemService s=new systemService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreJFrame frame = new StoreJFrame();
					frame.setVisible(true); 
				} catch (Exception e) {
//					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public StoreJFrame() throws SQLException {
		setTitle(s.getTitle());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 590);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u5E93\u5B58\u7BA1\u7406(K)");
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u6DFB\u52A0\u5546\u54C1\u4FE1\u606F");
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u4FEE\u6539\u5546\u54C1\u4FE1\u606F");
		mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5220\u9664\u5546\u54C1\u4FE1\u606F");
		mntmNewMenuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u67E5\u8BE2\u5546\u54C1\u4FE1\u606F");
		mntmNewMenuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnx = new JMenu("\u9500\u552E\u7EDF\u8BA1(X)");
		mnx.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
		menuBar.add(mnx);
		
		JMenuItem mntmNewMenuItem_3_1_1 = new JMenuItem("\u9500\u552E\u60C5\u51B5\u7EDF\u8BA1");
		mntmNewMenuItem_3_1_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnx.add(mntmNewMenuItem_3_1_1);
		
		JMenu mnh = new JMenu("\u4F1A\u5458\u7BA1\u7406(H)");
		mnh.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
		menuBar.add(mnh);
		
		JMenuItem mntmNewMenuItem_4_2 = new JMenuItem("\u6DFB\u52A0\u4F1A\u5458");
		mntmNewMenuItem_4_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnh.add(mntmNewMenuItem_4_2);
		
		JMenuItem mntmNewMenuItem_1_1_2 = new JMenuItem("\u4FEE\u6539\u4F1A\u5458\u4FE1\u606F");
		mntmNewMenuItem_1_1_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnh.add(mntmNewMenuItem_1_1_2);
		
		JMenuItem mntmNewMenuItem_2_1_2 = new JMenuItem("\u5220\u9664\u4F1A\u5458\u4FE1\u606F");
		mntmNewMenuItem_2_1_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnh.add(mntmNewMenuItem_2_1_2);
		
		JMenuItem mntmNewMenuItem_3_1_2 = new JMenuItem("\u67E5\u8BE2\u4F1A\u5458\u4FE1\u606F");
		mntmNewMenuItem_3_1_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnh.add(mntmNewMenuItem_3_1_2);
		
		JMenu mns = new JMenu("\u7CFB\u7EDF\u7BA1\u7406(S)");
		mns.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
		menuBar.add(mns);
		
		JMenuItem mntmNewMenuItem_4_3 = new JMenuItem("\u6DFB\u52A0\u5458\u5DE5");
		mntmNewMenuItem_4_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mns.add(mntmNewMenuItem_4_3);
		
		JMenuItem mntmNewMenuItem_1_1_3 = new JMenuItem("\u5458\u5DE5\u5DE5\u8D44");
		mntmNewMenuItem_1_1_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mns.add(mntmNewMenuItem_1_1_3);
		
		JMenuItem mntmNewMenuItem_2_1_3 = new JMenuItem("\u6570\u636E\u5907\u4EFD");
		mntmNewMenuItem_2_1_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mns.add(mntmNewMenuItem_2_1_3);
		
		JMenuItem mntmNewMenuItem_3_1_3 = new JMenuItem("\u8F6F\u4EF6\u8BBE\u7F6E");
		mntmNewMenuItem_3_1_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mns.add(mntmNewMenuItem_3_1_3);
		
		JMenuItem mntmNewMenuItem_3_1_3_1 = new JMenuItem("\u6298\u6263\u8BBE\u7F6E");
		mntmNewMenuItem_3_1_3_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mns.add(mntmNewMenuItem_3_1_3_1);
		
		JMenuItem mntmNewMenuItem_3_1_3_2 = new JMenuItem("\u6253\u5370\u6D4B\u8BD5");
		mntmNewMenuItem_3_1_3_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mns.add(mntmNewMenuItem_3_1_3_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new GridLayout(5, 1, 0, 0));
		
		JButton btnNewButton_1_1 = new JButton("\u5E93\u5B58\u7BA1\u7406");
		btnNewButton_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wareJFrame ware=new wareJFrame();
				desktopPane.add(ware);//给desktopPane中添加一个组件
				ware.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("宋体", Font.PLAIN, 24));
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_3 = new JButton("\u9500\u552E\u7EDF\u8BA1");
		btnNewButton_1_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salewareJFrame saleware=new salewareJFrame();
				desktopPane.add(saleware);
				saleware.setVisible(true);
			}
		});
		
		JButton btnNewButton_1_1_1 = new JButton("\u5546\u54C1\u9500\u552E");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellJFrame sell=new sellJFrame();
				desktopPane.add(sell);//给desktopPane中添加一个组件
				sell.setVisible(true);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_1_1_1.setBackground(Color.LIGHT_GRAY);
		panel.add(btnNewButton_1_1_1);
		btnNewButton_1_3.setFont(new Font("宋体", Font.PLAIN, 24));
		panel.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("\u4F1A\u5458\u7BA1\u7406");
		btnNewButton_1_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menberJFrame menber=new menberJFrame();
				desktopPane.add(menber);
				menber.setVisible(true);
			}
		});
		btnNewButton_1_4.setFont(new Font("宋体", Font.PLAIN, 24));
		panel.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_2 = new JButton("\u7CFB\u7EDF\u8BBE\u7F6E");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				systemJFrame s=new systemJFrame();
				desktopPane.add(s);
				s.setVisible(true);
			}
		});
		btnNewButton_1_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_2.setFont(new Font("宋体", Font.PLAIN, 24));
		panel.add(btnNewButton_1_2);
		
		desktopPane.setBackground(Color.GRAY);
		splitPane.setRightComponent(desktopPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 6, 0, 0));
		
		JButton btnNewButton_1 = new JButton("\u5546\u54C1\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				warequeryJFrame query=new warequeryJFrame();
				desktopPane.add(query);//给desktopPane中添加一个组件
				query.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_5 = new JButton("\u9500\u552E\u8D27\u7269");
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sellJFrame sell=new sellJFrame();
				desktopPane.add(sell);//给desktopPane中添加一个组件
				sell.setVisible(true);
			}
		});
		btnNewButton_1_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_5.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(btnNewButton_1_5);
		
		JButton btnNewButton_1_5_1 = new JButton("\u9500\u552E\u62A5\u8868");
		btnNewButton_1_5_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_5_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(btnNewButton_1_5_1);
		
		JButton btnNewButton_1_5_2 = new JButton("\u6DFB\u52A0\u8D27\u54C1");
		btnNewButton_1_5_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wareadd1JFrame add = new wareadd1JFrame();
				add.setVisible(true);
			}
		});
		btnNewButton_1_5_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_5_2.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(btnNewButton_1_5_2);
		
		JButton btnNewButton_1_5_2_1 = new JButton("\u5458\u5DE5\u7BA1\u7406");
		btnNewButton_1_5_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staffJFrame staff=new staffJFrame();
				desktopPane.add(staff);//给desktopPane中添加一个组件
				staff.setVisible(true);
			}
		});
		btnNewButton_1_5_2_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_5_2_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(btnNewButton_1_5_2_1);
	}
}
