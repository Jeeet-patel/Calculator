import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Checkbox;

public class Calc extends JFrame implements ActionListener {

	private JPanel contentPane;
	JFormattedTextField Tp;
	double L,total=0;
	String op,op1,lastnum=" ",num=" ";
	boolean flag=false,flag1=false,flag2=false;
	int count=0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc frame = new Calc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Calc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 150, 516, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Tp = new JFormattedTextField();
		Tp.setHorizontalAlignment(SwingConstants.RIGHT);
		Tp.setBounds(58, 10, 410, 71);
		contentPane.add(Tp);
		
		JButton b9 = new JButton("9");
		b9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b9.setBounds(58, 91, 51, 43);
		b9.addActionListener(this);
		contentPane.add(b9);
		
		JButton b6 = new JButton("6");
		b6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b6.setBounds(58, 144, 51, 43);
		b6.addActionListener(this);
		contentPane.add(b6);
		
		JButton b3 = new JButton("3");
		b3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b3.setBounds(58, 197, 51, 43);
		b3.addActionListener(this);
		contentPane.add(b3);
		
		JButton b = new JButton(".");
		b.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b.setBounds(58, 250, 51, 43);
		b.addActionListener(this);
		contentPane.add(b);
		
		JButton b8 = new JButton("8");
		b8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b8.setBounds(144, 91, 51, 43);
		b8.addActionListener(this);
		contentPane.add(b8);
		
		JButton b5 = new JButton("5");
		b5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b5.setBounds(144, 144, 51, 43);
		b5.addActionListener(this);
		contentPane.add(b5);
		
		JButton b2 = new JButton("2");
		b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b2.setBounds(144, 197, 51, 43);
		b2.addActionListener(this);
		contentPane.add(b2);
		
		JButton b0 = new JButton("0");
		b0.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b0.setBounds(144, 250, 51, 43);
		b0.addActionListener(this);
		contentPane.add(b0);
		
		JButton b7 = new JButton("7");
		b7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b7.setBounds(234, 91, 51, 43);
		b7.addActionListener(this);
		contentPane.add(b7);
		
		JButton b4 = new JButton("4");
		b4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b4.setBounds(234, 144, 51, 43);
		b4.addActionListener(this);
		contentPane.add(b4);
		
		JButton b1 = new JButton("1");
		b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b1.setBounds(234, 197, 51, 43);
		b1.addActionListener(this);
		contentPane.add(b1);
		
		JButton bequals = new JButton("=");
		bequals.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bequals.setBounds(234, 250, 51, 43);
		bequals.addActionListener(new opListener());
		contentPane.add(bequals);
		
		JButton add = new JButton("+");
		add.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add.setBounds(325, 144, 58, 43);
		add.addActionListener(new opListener());
		contentPane.add(add);
		
		JButton sub = new JButton("-");
		sub.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sub.setBounds(325, 197, 58, 43);
		sub.addActionListener(new opListener());
		contentPane.add(sub);
		
		JButton bclr = new JButton("clr");
		bclr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bclr.setBounds(410, 91, 58, 43);
		bclr.addActionListener(this);
		contentPane.add(bclr);
		
		JButton bdel = new JButton("del");
		bdel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bdel.setBounds(325, 91, 58, 43);
		bdel.addActionListener(this);
		contentPane.add(bdel);
		
		JButton mul = new JButton("x");
		mul.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mul.setBounds(325, 250, 58, 43);
		mul.addActionListener(new opListener());
		contentPane.add(mul);
		
		JButton div = new JButton("/");
		div.setFont(new Font("Tahoma", Font.PLAIN, 15));
		div.setBounds(410, 144, 58, 43);
		div.addActionListener(new opListener());
		contentPane.add(div);
		
		JButton neg = new JButton("+/-");
		neg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		neg.setBounds(410, 197, 58, 43);
		neg.addActionListener(new opListener());
		contentPane.add(neg);
		
		JButton sqr = new JButton("Sqr");
		sqr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sqr.setBounds(410, 250, 58, 43);
		sqr.addActionListener(new opListener());
		contentPane.add(sqr);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("clr"))
		{
			total=0;
			count=0;
			lastnum=" ";
			op=null;
			Tp.setText(null);
		}
		else if(e.getActionCommand().equals("del"))
		{
			if(Tp.getText().length()>0)
			{
				StringBuilder s = new StringBuilder(Tp.getText());
				s.deleteCharAt(Tp.getText().length()-1);
				Tp.setText(s.toString());
				lastnum=lastnum.substring(0,lastnum.length()-1);
			}
		}
		else
		{
			Tp.setText(Tp.getText()+e.getActionCommand());
			lastnum=lastnum.concat(e.getActionCommand());
			lastnum.trim();
		}
	}
	
	public class opListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				if(e.getActionCommand().equals("="))
				{
					double res=0;
					if(op1!=null)
					{
						if(op1.equals("x"))
						{
							res=Double.parseDouble(num)*Double.parseDouble(lastnum);
							lastnum=String.valueOf(res);
						}
						if(op1.equals("/"))
						{
							res=Double.parseDouble(num)/Double.parseDouble(lastnum);
							lastnum=String.valueOf(res);
						}
					}
					if(op==null)
					{
						return;
					}
					double a=Double.parseDouble(lastnum);
					if(op.equals("+"))
					{
						total=total+(a);
					}
					if(op.equals("-"))
					{
						total=total-(a);
					}
					if(op.equals("/"))
					{
						total=total/(a);
					}
					if(op.equals("x"))
					{
						total=total*(a);
					}
					Tp.setText(String.valueOf(total));
					op=null;
					op1=null;
					lastnum="0";
				}
				else
				{
					L = Double.parseDouble(lastnum);
					lastnum=" ";
					if(op!=null)
					{
						if(op1!=null)
						{
							double a=Double.parseDouble(num);
							if(e.getActionCommand().equals("x")|| e.getActionCommand().equals("/"))
							{
								double res=0;
								if(op1.equals("x"))
								{
									res=a*L;
								}
								if(op1.equals("/"))
								{
									res=a/L;
								}
								num=String.valueOf(res);
								op1=e.getActionCommand();
								Tp.setText(String.valueOf(total)+" " +op+" "+String.valueOf(res)+" "+op1+" ");
								return;
							}
							if(e.getActionCommand().equals("+")|| e.getActionCommand().equals("-")
								|| e.getActionCommand().equals("Sqr") || e.getActionCommand().equals("+/-"))
							{
								if(e.getActionCommand().equals("Sqr"))
								{
									L=Math.pow(L,2);
									flag2=true;
								}
								if(e.getActionCommand().equals("+/-"))
								{
									L=-L;
									flag2=true;
								}
								if(op1.equals("x"))
								{
									L=a*L;
								}
								if(op1.equals("/"))
								{
									L=a/L;
								}
								op1=null;
							}
						}
						if((op.equals("+") || op.equals("-")) &&
						   (e.getActionCommand().equals("x")|| e.getActionCommand().equals("/")))
						{
							op1=e.getActionCommand();
							num=String.valueOf(L);
							Tp.setText(Tp.getText() + " " + op1 + " ");
							return;
						}
						if(flag2==false)
						{
							if(e.getActionCommand().equals("+/-"))
							{
								L=-L;
								flag=true;
							}
							if(e.getActionCommand().equals("Sqr"))
							{
								L=Math.pow(L,2);
								flag=true;
							}
						}
						if(op.equals("+"))
						{
							total+=L;
						}
						if(op.equals("-"))
						{
							total-=L;
						}
						if(op.equals("/"))
						{
							total/=L;
						}
						if(op.equals("x"))
						{
							total*=L;
						}
						if(flag==true || flag2==true)
						{
							op=null;
							Tp.setText(String.valueOf(total));
							System.out.print("jsk");
							lastnum=String.valueOf(total);
							total=0;
							flag=false;
							flag2=false;
						}
						else
						{
							op = e.getActionCommand();
							Tp.setText(String.valueOf(total)+" "+ op + " ");
						}
					}
					else
					{
						op = e.getActionCommand();
						if(op.equals("+"))
						{
							total+=L;
						}
						if(op.equals("+/-"))
						{
							if(L!=0.0)
							{
								L=-L;
								total=L;
								flag1=true;
								lastnum="0";
							}
							else
							{
								total=-total;
								flag1=true;
								lastnum="0";
							}
						}
						if(op.equals("Sqr"))
						{
							if(L!=0.0)
							{
								total=Math.pow(L,2);
								flag1=true;
								lastnum="0";
							}
							else
							{
								total=Math.pow(total,2);
								flag1=true;
								lastnum="0";
							}
						}
						if(op.equals("x"))
						{
							if(count==0)
							{
								total=L;
							}
							else
							{
								if(L==0)
								{
									L=1;
								}
								total*=L;
							}
						}
						if(op.equals("-"))
						{
							if(count==0)
							{
								total=L;
							}
							else
							{
								total-=L;
							}
						}
						if(op.contentEquals("/"))
						{
							if(count==0)
							{
								total=L;
							}
							else
							{
								if(L==0)
								{
									L=1;
								}
								total/=L;
							}
						}
						if(flag1==true)
						{
							op=null;
							Tp.setText(String.valueOf(total)+" ");
							flag1=false;
						}
						else
						{
							Tp.setText(String.valueOf(total)+" "+ op + " ");
						}
					}
					count++;
				}
			}
			catch(Exception er)
			{
				System.out.print("Exception caught" + er);
			}
		}
	}
}
