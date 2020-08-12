package jframe;

import java.awt.EventQueue;



import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JInternalFrame;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entity.ware;
import service.wareService;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class wareJFrame extends JInternalFrame {
	private JTable table;
	private JTextField textField;
	DefaultTableModel tm = new DefaultTableModel();
	int countNo = tm.getRowCount();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wareJFrame frame = new wareJFrame();
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
	public wareJFrame() {
		setTitle("\u5E93\u5B58\u4FE1\u606F");
		setBounds(100, 100, 913, 443);
		setClosable(true);
		// 设置窗口关闭
		setMaximizable(true);
		// 设置窗口最大化

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);

		JLabel lb = new JLabel("库存总量：");
		lb.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(lb);

		JLabel lb_sum = new JLabel("0 ");
		lb_sum.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_1.add(lb_sum);

		JButton btnNewButton = new JButton("\u6DFB\u52A0\u5546\u54C1\u4FE1\u606F");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wareaddJFrame add = new wareaddJFrame(tm, lb_sum);
				add.setVisible(true);
			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u4FEE\u6539\u5546\u54C1\u4FE1\u606F");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCount = table.getSelectedRowCount();
				if (rowCount == 0) {
					// 提示请选择需要修改的行
					JOptionPane.showMessageDialog(null, "请选择需要修改的行");
					return;
				}
				if (rowCount > 1) {
					// 提示一次只能修改一行
					JOptionPane.showMessageDialog(null, "请选择需要修改的一行");
					return;
				}
				if (rowCount == 1) {
					// 修改 显示修改界面
					// 获取选中的行以及该行的初始值
					int indexRow = table.getSelectedRow();
					wareupdateJFrame update = new wareupdateJFrame(tm, indexRow);
					update.setVisible(true);
				}
			}
		});
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u5220\u9664\u5546\u54C1\u4FE1\u606F");
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rowCount = table.getSelectedRowCount();
				if (rowCount == 0) {
					// 提示请选择需要删除的行
					JOptionPane.showMessageDialog(null, "请选择需要删除的行");
					return;
				}
				if (rowCount > 1) {
					// 提示一次只能删除一行
					JOptionPane.showMessageDialog(null, "请选择需要删除的一行");
					return;
				}
				if (rowCount == 1) {
					// 删除
					// 获取选中的行的索引
					int confirmAnswer= JOptionPane.showConfirmDialog(null, "是否确定删除？");
					if(confirmAnswer==0) {
						int indexRow=table.getSelectedRow();
						String delwareid=tm.getValueAt(indexRow, 0).toString();
						wareService ss=new wareService();
						try {
							ss.delBywareid(delwareid);
							tm.removeRow(indexRow);
							lb_sum.setText(String.valueOf(tm.getRowCount()));
							JOptionPane.showMessageDialog(null, "删除成功");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		panel.add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u6761\u7801");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(textField);
		textField.setColumns(10);

		JButton btnNewButton_2_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_2_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 1 根据商品条码
				// 1.1 获取文本框----搜索字符串
				String wareid = textField.getText();
				wareService ss1 = new wareService();
				try {
					List<ware> list1 = ss1.queryId(wareid);
					for (ware ware : list1) {
						int rowCount = tm.getRowCount();// 行的总数
						for (int i = 0; i < rowCount; i++) {
							tm.removeRow(0);
						}
						tm.addRow(
								new Object[] { ware.getWareid(), ware.getWarename(), ware.getWaredd(), ware.getColor(),
										ware.getSize(), ware.getInprize(), ware.getOutprize(), ware.getNum() });
						countNo = tm.getRowCount();
						lb_sum.setText(String.valueOf(countNo));// 设置值
						JOptionPane.showMessageDialog(null, "查询成功");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
//					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_2_1);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		table = new JTable();
		table.setFont(new Font("宋体", Font.PLAIN, 18));
		// 设置表格模型
		table.setModel(tm);
		tm.addColumn("商品条码");
		tm.addColumn("商品名称");
		tm.addColumn("货号");
		tm.addColumn("颜色");
		tm.addColumn("尺码");
		tm.addColumn("进价");
		tm.addColumn("售价");
		tm.addColumn("数量");
		// 连接sevice
		wareService ss = new wareService();
		try {
			List<ware> list = ss.queryAll();
			for (ware ware : list) {
				tm.addRow(new Object[] { ware.getWareid(), ware.getWarename(), ware.getWaredd(), ware.getColor(),
						ware.getSize(), ware.getInprize(), ware.getOutprize(), ware.getNum() });
//				System.out.println(ware.getwareid()+ware.getwarename()+ware.getwaredd()+ware.getcolor()+ware.getsize()+"ware.getinprize()"+"ware.getoutprize()"+"ware.getnum()");
			}
			countNo = tm.getRowCount();
			lb_sum.setText(String.valueOf(countNo));// 设置值
		} catch (Exception e1) {
//			e1.printStackTrace();
		}

		scrollPane.setViewportView(table);
		
	}

}
