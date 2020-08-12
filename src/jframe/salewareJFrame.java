package jframe;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import entity.saleware;
import service.salewareService;

import javax.swing.JButton;
import java.awt.Font;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class salewareJFrame extends JInternalFrame {
	private JTextField textStart;
	private JTextField textEnd;
	private JTable table;
	DefaultTableModel tm = new DefaultTableModel();
	double countNo = 0;
	int countNonum = tm.getRowCount();
//	Date d = new Date();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					salewareJFrame frame = new salewareJFrame();
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
	public salewareJFrame() {
		setTitle("\u5546\u54C1\u9500\u552E");
		setBounds(100, 100, 742, 506);
		setClosable(true);
		// 设置窗口关闭
		setMaximizable(true);
		// 设置窗口最大化

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel_3 = new JLabel("\u9500\u552E\u7EDF\u8BA1\uFF1A");
		lblNewLabel_3.setFont(new Font("黑体", Font.BOLD, 20));
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel = new JLabel("\u5F00\u59CB\u65F6\u95F4");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(lblNewLabel);

		textStart = new JTextField();
		// 设置初始日期
		Date d = new Date();
		textStart.setText(d.getYear() + 1900 + ""
				+ ((d.getMonth() + 1) < 10 ? ("0" + (d.getMonth() + 1)) : (d.getMonth() + 1)) + "" + "01");
		textStart.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(textStart);
		textStart.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u7EC8\u6B62\u65F6\u95F4");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(lblNewLabel_1);

		textEnd = new JTextField();
		// 设置终止日期
		textEnd.setText(
				d.getYear() + 1900 + "" + ((d.getMonth() + 1) < 10 ? ("0" + (d.getMonth() + 1)) : (d.getMonth() + 1))
						+ "" + ((d.getDate()) < 10 ? ("0" + (d.getDate())) : (d.getDate())));
		textEnd.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(textEnd);
		textEnd.setColumns(10);


		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);

		JLabel lblNewLabel_2_1 = new JLabel("\u9500\u552E\u8BB0\u5F55\u603B\u6570\uFF1A");
		lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_2_1);

		JLabel lb_num = new JLabel("0");
		lb_num.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(lb_num);

		JLabel lblNewLabel_2 = new JLabel("\u9500\u552E\u603B\u989D\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_2);

		JLabel lb_sum = new JLabel("0");
		lb_sum.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_1.add(lb_sum);
		
		JButton btnNewButton = new JButton("\u7EDF\u8BA1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//按日期查询
				//先删再查
				
				int rowCount =table.getRowCount();
				for(int i=0;i<rowCount;i++) {
					tm.removeRow(0);
				}
				
      	        String startTime=textStart.getText();
      	        String endTime=textEnd.getText();

				salewareService ss = new salewareService();
				List<saleware> list=null;
				try {
					if(Integer.parseInt(loginJFrame.user.getLable())==2) {
						//老板查询
						      list=ss.queryAll(startTime,endTime,null);
					 }else {
						 //员工查询
						      list=ss.queryAll(startTime,endTime,loginJFrame.id);
					}
					for (saleware s : list) {
						tm.addRow(new Object[] { s.getWareid(),s.getWarename(),s.getSize(),s.getColor(),s.getWarenum(),s.getRealprize(),s.getSumprize(),s.getSaletime(),s.getSname() });
						countNo = countNo + Double.parseDouble(s.getSumprize());
					}
					countNonum = tm.getRowCount();
					lb_num.setText(String.valueOf(countNonum));// 设置值
					lb_sum.setText(String.valueOf(countNo));// 设置值
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(btnNewButton);


		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setFont(new Font("宋体", Font.PLAIN, 18));
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
//
////		 连接sevice
//		salewareService ss = new salewareService();
//		try {
//			List<saleware> list = ss.queryAll();
//			for (saleware saleware : list) {
//				tm.addRow(new Object[] { saleware.getWareid(), saleware.getWarename(), saleware.getSize(),
//						saleware.getColor(), saleware.getWarenum(), saleware.getRealprize(), saleware.getSumprize(),
//						saleware.getSaletime() ,saleware.getSname()});
////				System.out.println(saleware.getWareid()+saleware.getWarename()+saleware.getWaredd(), saleware.getSize(),
////				saleware.getColor(), saleware.getSaleid(), saleware.getSalename(), saleware.getSaleprize(),saleware.getSalenum(),saleware.getCondition(),saleware.getSaletime());
//				countNo = countNo + Double.parseDouble(saleware.getSumprize());
//			}
//			countNonum = tm.getRowCount();
//			lb_num.setText(String.valueOf(countNonum));// 设置值
//			lb_sum.setText(String.valueOf(countNo));// 设置值
//		} catch (Exception e1) {
////			e1.printStackTrace();
//		}
		scrollPane.setViewportView(table);

	}

}
