package Fuli;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Invest extends JFrame{

	//标签
	private JLabel a1;         //投资金额
	private JLabel a2;         //投入时间
	private JLabel a3;         //期末价值
	private JLabel a4;         //基金公司
	private JLabel a5;         //基金名称
	private JLabel a6;         //期间回报

	
	
	//输入框
	private JTextField b1;     //投资金额
	private JTextField b2;     //投入时间
	private JTextField b3;     //期末价值
	private JTextField b6;     //回报率
	
	

	
	
	//按钮
	private JButton c1;         //计算
	private JButton c2;         //清除
	private JButton c3;         //查看往期投资
	
	
	//下拉列表框
	private JComboBox jb1;
	private JComboBox jb2;
	
	//按钮存放容器
	private JPanel toolbar = new JPanel();
	
	
	//多行文本区域，用于输出往期投资数据
	private JTextArea jtextArea;
	
	public double[] Pricinal = new double[100];
	public double[] Amount = new double[100];
	public double[] Day = new double[100];
	private int input=0;
	
	public Invest(){
		CreateWindows();//创建窗口
		CreateComponent();//创建零件
		LayoutComponent();//零件布局
		MouseLinsten();   //鼠标监听
		InitjtextArea();  //初始化空白文本区域
	}
	

	


	private void CreateWindows(){
		//创建一个窗口
				int Windowswidth = 300;
				int Windowsheight = 455;
				setVisible(true);
				setSize(Windowswidth, Windowsheight);
				setResizable(false);
				int width = Toolkit.getDefaultToolkit().getScreenSize().width;
				int height = Toolkit.getDefaultToolkit().getScreenSize().height;
				setLocation((width - Windowswidth) / 2, (height - Windowsheight) / 2); // 窗口居中
				setTitle("投资计算器");
	}
	
	

	private void CreateComponent() {
		// TODO 自动生成的方法存根
		a1 = new JLabel("投资金额(元)");
		a2 = new JLabel("投入时间(日)");
		a3 = new JLabel("期末价值");
		a4=new JLabel("基  金  公  司");
		a5=new JLabel("基  金  名  称");
		a6=new JLabel("期 间 回 报(%)");
		
		
		b1=new JTextField(10);
		b2=new JTextField(10);
		b3=new JTextField(10);
		b6=new JTextField(10);

		
		
		c1=new JButton("计算");
		c2=new JButton("清除");
		c3=new JButton("查看往期投资");
		

		jb1=new JComboBox();
		jb2=new JComboBox();
		
		jtextArea=new JTextArea();
	}
	
	
	private void LayoutComponent(){

		setLayout(new FlowLayout());
		//五个面板容器      一个标签对应一个输入输出框
		JPanel jpanel1=new JPanel();
		jpanel1.add(a1);
		jpanel1.add(b1);
		
		JPanel jpanel2=new JPanel();
		jpanel2.add(a2);
		jpanel2.add(b2);
		
		JPanel jpanel3=new JPanel();
		jpanel3.add(a3);
		jpanel3.add(b3);

		
		JPanel jpanel4=new JPanel();
		jpanel4.add(a4);
		jpanel4.add(jb1);
		
		Object[] types={"A安信基金公司","B博时基金公司","C财通基金公司","C长城基金公司","D大成基金公司","F富安达基金 ","F方正富邦基金"};
		DefaultComboBoxModel model=new DefaultComboBoxModel((Object[]) types);
        jb1.setModel(model);
        
        
        
        Object[] types2={" 创新动力基金 "," 红利精选基金 "," 保险红利基金 "," 定期开放债卷 "};
		DefaultComboBoxModel model2=new DefaultComboBoxModel((Object[]) types2);
        jb2.setModel(model2);
        
        
        JPanel jpanel5=new JPanel();
		jpanel5.add(a5);
		jpanel5.add(jb2);
		
		
		JPanel jpanel6=new JPanel();
		jpanel6.add(a6);
		jpanel6.add(b6);
        
		
		JPanel centerpanel = new JPanel(new GridLayout(3, 1)); // 3行1列
		
		//上三
		centerpanel.add(jpanel1);
		centerpanel.add(jpanel2);
		centerpanel.add(jpanel6);
	
		
		
		//中间三个按钮
		toolbar.add(c1);
		toolbar.add(c2);
		toolbar.add(c3);
		

		
		
		
		//设置可滚动条文本输出框
		JScrollPane text = new JScrollPane(jtextArea);
		text.setPreferredSize(new Dimension(250, 150));
		
		
		
		add(jpanel4,BorderLayout.CENTER);
		add(jpanel5,BorderLayout.CENTER);
		add(centerpanel,BorderLayout.CENTER);  //居中
		add(toolbar,BorderLayout.CENTER);

		add(text);
		add(jpanel3,BorderLayout.CENTER);
		
		
	}
	
	
	
	private void MouseLinsten(){
		//实例化私有鼠标点击类
		c1.addActionListener(new C1Action());               //计算
		c2.addActionListener(new C2Action());               //清除
		c3.addActionListener(new C3Action());               //查看往期记录
	
	}
	
	
	
	public void InitjtextArea() {
		// TODO 自动生成的方法存根
		String outup="同期指数涨幅"+"\n\n"+"    指          数        "+"           涨    跌    情     况   "+"\n";
		String outup1="   深  证  指  数     "+"              -19.97%    "+"\n";
		String outup2="   上  证  指  数     "+"              +18.24%    "+"\n";
		String outup3="  中  小  板  指  数     "+"          -10.19%    "+"\n";
		String outup4=" 泸  深  300  指  数    "+"         -14.61%    "+"\n";
		jtextArea.setText(outup+outup1+outup2+outup3+outup4);
		
	}
	
	
	
	private class C1Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double principal = 0;         //b1
			double amount = 0;            //b3
			double rate = 0;              //b6
			double time=0;                //b2
			if(b3.getText().equals("") && b1.getText() != null
					&& b6.getText() != null && b2.getText() != null)
			{
				try {
					rate = Double.parseDouble(b6.getText());
					principal = Double.parseDouble(b1.getText());
					time = Double.parseDouble(b2.getText());
				} catch (Exception e2) {
					// TODO: handle exception
					rate=0;
					principal=0;
					time=0;
				}
				
				
				amount=principal*(1+rate);
				b3.setText(""+amount);
				Amount[input]=amount;
				Day[input]=time;
				Pricinal[input]=principal;
				input+=1;
			}
			else if(b3.getText()!=null && b1.getText() != null
					&& b6.getText() != null && b2.getText() != null)
			{
				JOptionPane.showMessageDialog(null, "请删除期末价值");
			}
			else {
				JOptionPane.showMessageDialog(null, "请输入数据");
			}
		}
	}
	
	
	private class C2Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				b1.setText("");
				b2.setText("");
				b3.setText("");
				b6.setText("");
			} catch (NullPointerException e2) {
				// TODO: handle exception
			}
			InitjtextArea();
			
		}
	}
	
	
	private class C3Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String outup="本金"+"/"+"期限"+"/"+"期末价值"+"\n";
			for(int i=0;i<input;i++){
				outup=outup+Pricinal[i]+"    "+Day[i]+"    "+Amount[i]+"\n";
			}
			jtextArea.setText(outup);
		}
	}
	
	
}
