/*
 * Frame.java
 *
 * Created on __DATE__, __TIME__
 */

package frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.InputStream;

import javax.swing.JOptionPane;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import entity.Managers;
import entity.Users;

import test.test;

/**
 *
 * @author  __USER__
 */
public class Frame extends javax.swing.JFrame {

	/** Creates new form Frame */
	public Frame() {
		initComponents();
		
	}
	
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		buttonGroup2 = new javax.swing.ButtonGroup();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jRadioButtonuser = new javax.swing.JRadioButton();
		jRadioButtonmanager = new javax.swing.JRadioButton();
		jButtonlogin = new javax.swing.JButton();
		JTextFieldusername = new javax.swing.JTextField();
		jPasswordFieldpsd = new javax.swing.JPasswordField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel1.setForeground(new java.awt.Color(255, 51, 0));
		jLabel1.setText("\u767b\u5f55\u9875\u9762");

		jLabel2.setText("\u7528\u6237\u540d");

		jLabel3.setText("\u5bc6   \u7801");

		buttonGroup1.add(jRadioButtonuser);
		jRadioButtonuser.setSelected(true);
		jRadioButtonuser.setText("\u666e\u901a\u7528\u6237");

		buttonGroup1.add(jRadioButtonmanager);
		jRadioButtonmanager.setText("\u7ba1\u7406\u5458");

		jButtonlogin.setText("\u767b\u5f55");
		jButtonlogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonloginActionPerformed(evt);
			}
		});

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(layout
						.createSequentialGroup()
						.add(59, 59, 59)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.LEADING,
										false)
								.add(jLabel2)
								.add(layout
										.createSequentialGroup()
										.add(jLabel3)
										.add(18, 18, 18)
										.add(layout
												.createParallelGroup(
														org.jdesktop.layout.GroupLayout.LEADING,
														false)
												.add(jPasswordFieldpsd)
												.add(layout
														.createSequentialGroup()
														.add(jRadioButtonuser)
														.addPreferredGap(
																org.jdesktop.layout.LayoutStyle.RELATED,
																58,
																Short.MAX_VALUE)
														.add(jRadioButtonmanager))
												.add(JTextFieldusername))))
						.addContainerGap(95, Short.MAX_VALUE))
				.add(org.jdesktop.layout.GroupLayout.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(167, Short.MAX_VALUE)
								.add(jLabel1).add(161, 161, 161))
				.add(org.jdesktop.layout.GroupLayout.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(173, Short.MAX_VALUE)
								.add(jButtonlogin).add(170, 170, 170)));
		layout.setVerticalGroup(layout
				.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(layout
						.createSequentialGroup()
						.addContainerGap()
						.add(jLabel1)
						.add(29, 29, 29)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jLabel2)
								.add(JTextFieldusername,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.add(27, 27, 27)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jLabel3)
								.add(jPasswordFieldpsd,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.add(18, 18, 18)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jRadioButtonuser).add(jRadioButtonmanager))
						.add(18, 18, 18).add(jButtonlogin)
						.addContainerGap(76, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents
	//登录按钮

	private void jButtonloginActionPerformed(java.awt.event.ActionEvent evt) {
		SqlSession session = null;
		SqlSessionFactory sessionFactory = null;
		InputStream is = test.class.getClassLoader().getResourceAsStream(
				"data/conf.xml");
		sessionFactory = new SqlSessionFactoryBuilder().build(is);
		session = sessionFactory.openSession();
		String username = JTextFieldusername.getText();
		String psd = jPasswordFieldpsd.getText();
		if (jRadioButtonuser.isSelected()) {
			//如果选择普通用户
			String statement = "data.Mapper.selectusersbyname";
			Users user =  session.selectOne(statement, username);
			//System.out.println(user);
			//判断密码是否正确
			if ((user.getUserpsd()).equals(psd)) {
				this.setVisible(false);
				Userframe uf = new Userframe(user.getUsername(),user.getRole());
				uf.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "用户名或密码错误！", "登录信息",
						JOptionPane.WARNING_MESSAGE);
			}
		} else {
			//如果选择管理员用户			
			String statement = "data.Mapper.selectmanagersbyname";
			Managers managers=session.selectOne(statement,username);
			//判断密码是否正确
			if ((managers.getManagerpsd()).equals(psd)) {
				this.setVisible(false);
				Managerframe mf = new Managerframe(managers.getManagername(),managers.getManagerrole());
				mf.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "用户名或密码错误！", "登录信息",
						JOptionPane.WARNING_MESSAGE);
			}

		}
		session.close();
	}

	private void userpasswordActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Frame().setVisible(true);
				
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextField JTextFieldusername;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.ButtonGroup buttonGroup2;
	private javax.swing.JButton jButtonlogin;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPasswordField jPasswordFieldpsd;
	private javax.swing.JRadioButton jRadioButtonmanager;
	private javax.swing.JRadioButton jRadioButtonuser;
	// End of variables declaration//GEN-END:variables

}