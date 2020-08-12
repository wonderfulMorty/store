package jframe;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.ware;
import service.wareService;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class warequeryJFrame extends JInternalFrame {

	DefaultTableModel tm = new DefaultTableModel();
	int countNo = tm.getRowCount();
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					warequeryJFrame frame = new warequeryJFrame();
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
	public warequeryJFrame() {
		setTitle("\u5546\u54C1\u67E5\u8BE2");
		setBounds(100, 100, 669, 504);
		setClosable(true);
		// 设置窗口关闭
		setMaximizable(true);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u6570\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		JLabel lb_sum = new JLabel("0");
		lb_sum.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(lb_sum);
		
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
		tm.addColumn("价格");
		tm.addColumn("数量");
		// 连接sevice
		wareService ss = new wareService();
		try {
			List<ware> list = ss.queryAll();
			for (ware ware : list) {
				tm.addRow(new Object[] { ware.getWareid(), ware.getWarename(), ware.getWaredd(), ware.getColor(),
						ware.getSize(), ware.getOutprize(), ware.getNum() });
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
