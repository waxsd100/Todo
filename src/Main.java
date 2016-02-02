import javax.swing.JFrame;
public class Main{
	static Todo ｆ = new Todo();
	public static void main(String[] args){
		ｆ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ｆ.setBounds(10, 10, 520, 820);
		ｆ.setTitle("Todo");
		ｆ.setVisible(true);
	}
}