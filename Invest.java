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

	//��ǩ
	private JLabel a1;         //Ͷ�ʽ��
	private JLabel a2;         //Ͷ��ʱ��
	private JLabel a3;         //��ĩ��ֵ
	private JLabel a4;         //����˾
	private JLabel a5;         //��������
	private JLabel a6;         //�ڼ�ر�

	
	
	//�����
	private JTextField b1;     //Ͷ�ʽ��
	private JTextField b2;     //Ͷ��ʱ��
	private JTextField b3;     //��ĩ��ֵ
	private JTextField b6;     //�ر���
	
	

	
	
	//��ť
	private JButton c1;         //����
	private JButton c2;         //���
	private JButton c3;         //�鿴����Ͷ��
	
	
	//�����б��
	private JComboBox jb1;
	private JComboBox jb2;
	
	//��ť�������
	private JPanel toolbar = new JPanel();
	
	
	//�����ı����������������Ͷ������
	private JTextArea jtextArea;
	
	public double[] Pricinal = new double[100];
	public double[] Amount = new double[100];
	public double[] Day = new double[100];
	private int input=0;
	
	public Invest(){
		CreateWindows();//��������
		CreateComponent();//�������
		LayoutComponent();//�������
		MouseLinsten();   //������
		InitjtextArea();  //��ʼ���հ��ı�����
	}
	

	


	private void CreateWindows(){
		//����һ������
				int Windowswidth = 300;
				int Windowsheight = 455;
				setVisible(true);
				setSize(Windowswidth, Windowsheight);
				setResizable(false);
				int width = Toolkit.getDefaultToolkit().getScreenSize().width;
				int height = Toolkit.getDefaultToolkit().getScreenSize().height;
				setLocation((width - Windowswidth) / 2, (height - Windowsheight) / 2); // ���ھ���
				setTitle("Ͷ�ʼ�����");
	}
	
	

	private void CreateComponent() {
		// TODO �Զ����ɵķ������
		a1 = new JLabel("Ͷ�ʽ��(Ԫ)");
		a2 = new JLabel("Ͷ��ʱ��(��)");
		a3 = new JLabel("��ĩ��ֵ");
		a4=new JLabel("��  ��  ��  ˾");
		a5=new JLabel("��  ��  ��  ��");
		a6=new JLabel("�� �� �� ��(%)");
		
		
		b1=new JTextField(10);
		b2=new JTextField(10);
		b3=new JTextField(10);
		b6=new JTextField(10);

		
		
		c1=new JButton("����");
		c2=new JButton("���");
		c3=new JButton("�鿴����Ͷ��");
		

		jb1=new JComboBox();
		jb2=new JComboBox();
		
		jtextArea=new JTextArea();
	}
	
	
	private void LayoutComponent(){

		setLayout(new FlowLayout());
		//����������      һ����ǩ��Ӧһ�����������
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
		
		Object[] types={"A���Ż���˾","B��ʱ����˾","C��ͨ����˾","C���ǻ���˾","D��ɻ���˾","F��������� ","F�����������"};
		DefaultComboBoxModel model=new DefaultComboBoxModel((Object[]) types);
        jb1.setModel(model);
        
        
        
        Object[] types2={" ���¶������� "," ������ѡ���� "," ���պ������� "," ���ڿ���ծ�� "};
		DefaultComboBoxModel model2=new DefaultComboBoxModel((Object[]) types2);
        jb2.setModel(model2);
        
        
        JPanel jpanel5=new JPanel();
		jpanel5.add(a5);
		jpanel5.add(jb2);
		
		
		JPanel jpanel6=new JPanel();
		jpanel6.add(a6);
		jpanel6.add(b6);
        
		
		JPanel centerpanel = new JPanel(new GridLayout(3, 1)); // 3��1��
		
		//����
		centerpanel.add(jpanel1);
		centerpanel.add(jpanel2);
		centerpanel.add(jpanel6);
	
		
		
		//�м�������ť
		toolbar.add(c1);
		toolbar.add(c2);
		toolbar.add(c3);
		

		
		
		
		//���ÿɹ������ı������
		JScrollPane text = new JScrollPane(jtextArea);
		text.setPreferredSize(new Dimension(250, 150));
		
		
		
		add(jpanel4,BorderLayout.CENTER);
		add(jpanel5,BorderLayout.CENTER);
		add(centerpanel,BorderLayout.CENTER);  //����
		add(toolbar,BorderLayout.CENTER);

		add(text);
		add(jpanel3,BorderLayout.CENTER);
		
		
	}
	
	
	
	private void MouseLinsten(){
		//ʵ����˽���������
		c1.addActionListener(new C1Action());               //����
		c2.addActionListener(new C2Action());               //���
		c3.addActionListener(new C3Action());               //�鿴���ڼ�¼
	
	}
	
	
	
	public void InitjtextArea() {
		// TODO �Զ����ɵķ������
		String outup="ͬ��ָ���Ƿ�"+"\n\n"+"    ָ          ��        "+"           ��    ��    ��     ��   "+"\n";
		String outup1="   ��  ֤  ָ  ��     "+"              -19.97%    "+"\n";
		String outup2="   ��  ֤  ָ  ��     "+"              +18.24%    "+"\n";
		String outup3="  ��  С  ��  ָ  ��     "+"          -10.19%    "+"\n";
		String outup4=" ��  ��  300  ָ  ��    "+"         -14.61%    "+"\n";
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
				JOptionPane.showMessageDialog(null, "��ɾ����ĩ��ֵ");
			}
			else {
				JOptionPane.showMessageDialog(null, "����������");
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
			String outup="����"+"/"+"����"+"/"+"��ĩ��ֵ"+"\n";
			for(int i=0;i<input;i++){
				outup=outup+Pricinal[i]+"    "+Day[i]+"    "+Amount[i]+"\n";
			}
			jtextArea.setText(outup);
		}
	}
	
	
}
