import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class Todo extends JFrame implements ActionListener{

	static JFileChooser frame = new JFileChooser();
	static int p , i , l ,s , count;

	static String lineSeparator = System.getProperty("line.separator");
	static ArrayList<String> id = new ArrayList<String>();
	static ArrayList<String> todo = new ArrayList<String>();
	static HashMap<String,String> map = new HashMap<String,String>();

	JCheckBox ckbox;
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	//	JPanel p3 = new JPanel();
	//	JDesktopPane desktop;
	//	Container p3;

	static JDesktopPane desktop;
	static int frameCount;
	static JList<?> List;
	@SuppressWarnings("rawtypes")
	static DefaultListModel ListModel;
	static JTextField Inputarea;
	static JButton Add , Edit , Remove , Export;
	Todo(){

		p1.setBackground(Color.ORANGE);
		p2.setBackground(Color.GREEN);
		//	p3.setBackground(Color.BLUE);

		//		desktop = new JDesktopPane();


		ListModel = new DefaultListModel();
		List = new JList(ListModel);
		JScrollPane area = new JScrollPane(List);
		List.addListSelectionListener(new Select());
		area.setPreferredSize(new Dimension(250, 320)); 
//		System.out.println(area.getSize()+":"+);
		Inputarea = new JTextField(10);



		desktop = new JDesktopPane();
		frameCount = 1;
		JInternalFrame iframe = new JInternalFrame("Todo" + frameCount,true,true,true,true);
		iframe.setSize(250, 120);
		iframe.setLocation(10 + frameCount * 10, 10 + frameCount * 10);
		iframe.setVisible(true);
		frameCount++;
		iframe.  add(new JLabel(Todo.Inputarea.getText()));
		JPanel buttonPanel = new JPanel();
		getContentPane().add(desktop, BorderLayout.CENTER);
		getContentPane().add(buttonPanel, BorderLayout.PAGE_END);



		Add = new JButton("追加");
		Edit = new JButton("編集");
		Remove = new JButton("削除");
		Export = new JButton("表示");

		Add.addActionListener(this);
		Edit.addActionListener(this);
		Remove.addActionListener(this);
		Export.addActionListener(this);
		button.addActionListener(this);
		p2.add(Add);
		p2.add(Edit);
		p2.add(Remove);
		p2.add(Export);
		p1. add(area);
		p2. add(Inputarea);
		desktop.add(iframe);
		getContentPane().add(p1, BorderLayout.PAGE_START);
		getContentPane().add(p2, BorderLayout.PAGE_END);

		/*
		http://ateraimemo.com/Swing/DifferentCellHeight.html
		 */

	}

	static void setbtn(boolean b) {

		Add.setEnabled(b);
		Edit.setEnabled(b);
		Remove.setEnabled(b);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		String btn = e.getActionCommand();
		if (!(Inputarea.getText().equals(""))){

			if(btn.equals("追加")){
				InnerFrame();				
				Action.add();
		
			}
			if(btn.equals("編集")){
				Action.edit();
			}
			if(btn.equals("削除")){
				Action.remove();
			}
			if(btn.equals("表示")){
				Action.show();
			}
		


			}
		}else{
			if(btn.equals("追加") | btn.equals("編集")){
				JOptionPane.showMessageDialog(Todo.frame, "フィールドが空欄です。");
			}
		}
	}
}