package jframe;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.saleware;
import entity.saleware1;
import service.saleware1Service;
import service.salewareService;

import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class sellJFrame extends JInternalFrame {
	DefaultTableModel tm = new DefaultTableModel();
	double countNo = 0;
	int countNonum = tm.getRowCount();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sellJFrame frame = new sellJFrame();
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
	public sellJFrame() {
		setTitle("\u5546\u54C1\u9500\u552E");
		setBounds(100, 100, 554, 455);
		setClosable(true);
		// 设置窗口关闭
		setMaximizable(true);
		// 设置窗口最大化

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("\u9500\u552E\u8BB0\u5F55\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(lblNewLabel);

		JLabel lb_num = new JLabel("0");
		lb_num.setFont(new Font("黑体", Font.PLAIN, 20));
		panel.add(lb_num);
		lb_num.setText(String.valueOf(countNonum));// 设置值

		JLabel lblNewLabel_2 = new JLabel("\u9500\u552E\u603B\u989D\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(lblNewLabel_2);

		JLabel lb_sum = new JLabel("0");
		lb_sum.setFont(new Font("黑体", Font.PLAIN, 20));
		panel.add(lb_sum);
		

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("\u5546\u54C1\u9500\u552E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saleJFrame sale = new saleJFrame(tm, lb_sum,lb_num);
				sale.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		// 设置表格模型
				table.setModel(tm);
		tm.addColumn("商品条码");
		tm.addColumn("商品名称");
		tm.addColumn("尺码");
		tm.addColumn("颜色");
		tm.addColumn("销售数量");
		tm.addColumn("原价");
		tm.addColumn("销售价格");
		tm.addColumn("销售时间");
		tm.addColumn("销售员");

//				 连接sevice
		saleware1Service ss = new saleware1Service();
		try {
			List<saleware1> list = ss.queryAll();
			for (saleware1 saleware : list) {
				tm.addRow(new Object[] { saleware.getWareid(), saleware.getWarename(), saleware.getSize(),
						saleware.getColor(), saleware.getWarenum(), saleware.getRealprize(), saleware.getSumprize(),
						saleware.getSaletime(),saleware.getSname() });
//						System.out.println(saleware.getWareid()+saleware.getWarename()+saleware.getWaredd(), saleware.getSize(),
//						saleware.getColor(), saleware.getSaleid(), saleware.getSalename(), saleware.getSaleprize(),saleware.getSalenum(),saleware.getCondition(),saleware.getSaletime());
				countNo = countNo + Double.parseDouble(saleware.getSumprize());
			}
			countNonum = tm.getRowCount();
			lb_num.setText(String.valueOf(tm.getRowCount()));
			lb_sum.setText(String.valueOf(countNo));

			
		} catch (Exception e1) {
//					e1.printStackTrace();
		}

		scrollPane.setViewportView(table);
	}

}
