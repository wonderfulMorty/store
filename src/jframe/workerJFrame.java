package jframe;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.wareworker;
import service.wareworkerService;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class workerJFrame extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					workerJFrame frame = new workerJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public workerJFrame() {
		setTitle("\u5458\u5DE5\u7BA1\u7406");
		setBounds(100, 100, 686, 444);setClosable(true);
		// 设置窗口关闭
		setMaximizable(true);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("\u5E93\u5B58\u7BA1\u7406\u4FE1\u606F\u67E5\u8BE2");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u7BA1\u7406\u4FE1\u606F\u603B\u6570\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("0");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_1.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFont(new Font("宋体", Font.PLAIN, 18));
		DefaultTableModel tm=new DefaultTableModel();
		table.setModel(tm);
	    tm.addColumn("工号");
	    tm.addColumn("员工姓名");
	    tm.addColumn("员工电话");
	    tm.addColumn("商品条码");
	    tm.addColumn("商品名称");
	    tm.addColumn("货号");
	    
	    wareworkerService ww=new wareworkerService();
	    List<wareworker> list=null;
		try {
			list = ww.queryAll();
		    for(wareworker w : list) {
		    	tm.addRow(new Object[] {w.getWorkerid(),w.getWorkername(),w.getWorkertel(),w.getWare().getWareid(),w.getWare().getWarename(),w.getWare().getWaredd()});
		    }

			int countNo = tm.getRowCount();
			lblNewLabel_1.setText(String.valueOf(countNo));// 设置值

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		scrollPane.setViewportView(table);
	}

}
