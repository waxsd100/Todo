import java.awt.Dimension;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;



	class InnerFrame extends JInternalFrame {
	
		public InnerFrame(){
		
			JInternalFrame iframe = new JInternalFrame("Todo" + frameCount,true,true,true,true);
			iframe.setSize(250, 120);
			iframe.setLocation(10 + frameCount * 10, 10 + frameCount * 10);
			iframe.setVisible(true);
			frameCount++;
			iframe.add(new JLabel(Todo.Inputarea.getText()));
			desktop.add(iframe);
			try{
				iframe.setSelected(true);
			}catch(PropertyVetoException ex){
				System.out.println(ex.getMessage());
			}


	}
