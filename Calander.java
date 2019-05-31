
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
class Calenders
{
	
	int  start(int year,int month,int date)
	{
		int d,m,y,r,result;

		Calenders c=new Calenders();
		r=c.check(date,month);
		if(r==1)
		{
			y=c.yearCalc(year);
			
			m=c.monthCalc(month,year);
			
			result=(y+m+date)%7;
			return result;
		}

		else 
			return -1;

	}

	int check(int d,int m)
	{
		if(d>0&&d<32)
			if(m>0&&m<13)
				return 1;
				
		return 0;
	}

	int yearCalc(int y)
	{
		int cent,z,result,x,w,v;
		cent=y-(y%100);
		z=(cent%400)/100;
                result=(z*5)%7;
		x=(y%100)-1;
                w=x-(x/4);
		v=w+((x/4)*2);
		result+=v%7;

		return result;	
	}
	int monthCalc(int m,int y)
	{
		int result=0;
		int a[]={3,0,3,2,3,2,3,3,2,3,2,3};
		int b[]={3,1,3,2,3,2,3,3,2,3,2,3};
		if(y%100==0&&y%400==0||y%100!=100&&y%4==0)
			for(int i=0;i<m-1;i++)
				result+=b[i];
		else
			for(int i=0;i<m-1;i++)
				result+=a[i];
		return result%7;
}
	
}		
class Calander extends JFrame implements ActionListener
{
String x[] = new String[1000];

String c[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
String d[]={"January","Febraury","March","April","May","June","July","August","September","October","November","December"};
	JComboBox cb=new JComboBox(c);
	JComboBox cb1=new JComboBox(d);
	JComboBox cb2;

	JButton b1;
	JTextField t1,t4;
	JLabel l1,l2,l3,l4;
	Calander()
	{
		for(int i=1900,j=0;i<=2100;i++,j++)
		{
			x[j]=Integer.toString(i);
		}
		cb2=new JComboBox(x);
		b1=new JButton("compute");
//		t1=new JTextField(4);
		//t2=new JTextField(2);
		//t3=new JTextField(2);
		t4=new JTextField(10);
		l1=new JLabel("year");
		l2=new JLabel("month");
		l3=new JLabel("date");
		l4=new JLabel("result");
		b1.addActionListener(this);
		add(l1);
//		add(t1);
		add(cb2);		
		add(l2);
		add(cb1);
		//add(t3);
		add(l3);
   		add(cb);
		//add(t3);
		add(b1);
		add(l4);
		add(t4);
		setSize(600,600);
		setLayout(new FlowLayout());
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		try{int z=0;
		String s1,s2,s3;
		s1="0"+cb2.getItemAt(cb2.getSelectedIndex());
		s2="0"+cb.getItemAt(cb.getSelectedIndex());
		
		s3="0"+cb1.getItemAt(cb1.getSelectedIndex());
		switch(s3)
		{
			case "0January":z=1;break;
			case "0Febraury":z=2;break;
			case "0March":z=3;break;
			case "0April":z=4;break;
			case "0May":z=5;break;
			case "0June":z=6;break;
			case "0July":z=7;break;
			case "0August":z=8;break;
			case "0September":z=9;break;
			case "0October":z=10;break;
			case "0November":z=11;break;
			case "0December":z=12;break;
		}
		int year=Integer.parseInt(s1);
		int month=z;
		int date=Integer.parseInt(s2);
		//System.out.println(date);
		Calenders l=new Calenders();
		int r=l.start(year,month,date);
		switch(r)
			{
				case 0:t4.setText("SUNDAY");break;
				case 1:t4.setText("MONDAY");break;
				case 2:t4.setText("TUESDAY");break;
				case 3:t4.setText("WEDNESDAY");break;
				case 4:t4.setText("THURSDAY");break;
				case 5:t4.setText("FRIDAY");break;
				case 6:t4.setText("SATURDAY");break; 
			}
		
		}
		catch(NumberFormatException n)
		{
			t4.setText("integers only");
		}
	}
	public static void main(String args[])
	{
		Calander d =new Calander();
	}	
}
