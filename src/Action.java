import java.awt.Dimension;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Action {
	static JInternalFrame iframe = new JInternalFrame("Todo" + Todo.frameCount,true,true,true,true);
	static void add(){
		String hoge = (""+Todo.List.getSelectedIndex());
		//			上から何番目か
		Todo.p = Todo.p+1;
		String s = String.valueOf(Todo.p);
		Todo.id.add(s);
		Todo.todo.add(Todo.Inputarea.getText());
		Todo.map.put(s,Todo.Inputarea.getText());
		Todo.ListModel.addElement(Todo.Inputarea.getText());
		Todo.Inputarea.setText("");
		System.out.println(hoge);

		System.out.println(Todo.map.toString());
		return;

	}
	static void edit(){

		if(Todo.List.getSelectedIndices().length == 0){
			JOptionPane.showMessageDialog(Todo.frame, "行が選択されていません。");
			return;
		} else if (Todo.List.getSelectedIndices().length != 1) {
			JOptionPane.showMessageDialog(Todo.frame, "複数行の編集はできません。");
			return;
		}else{
			Todo.ListModel.set(Todo.List.getSelectedIndex(),Todo.Inputarea.getText());
			Todo.Inputarea.setText("");
		}
	}
	static void remove(){
		if (Todo.List.getSelectedIndices().length == 0) {
			JOptionPane.showMessageDialog(Todo.frame, "行が選択されていません。");
			return;
		}else if(Todo.List.getSelectedIndices().length != 1){
			JOptionPane.showMessageDialog(Todo.frame, "複数行の削除はできません。");
		}else{
			Todo.setbtn(false);
			Thread removeThread = new
					remove(Todo.List.getSelectedIndex());
			removeThread.start();
		}
	}
	static void show(){
		File newtxt = new File("./tmp/save.txt");
		File newfile = new File("./tmp");
		try{
			if (newfile.mkdir()){
				System.out.println("ディレクトリの作成に成功しました");
				if (newtxt.createNewFile()){
					System.out.println("ファイルの作成に成功しました");
				}else{
					System.out.println("ファイルの作成に失敗しました");
				}
			}else{
				System.out.println("ディレクトリの作成に失敗しました");
				if (newtxt.createNewFile()){
					System.out.println("ファイルの作成に成功しました");
				}else{
					System.out.println("ファイルの作成に失敗しました");
				}
			}

			if (newtxt.canRead() && newtxt.canWrite()){
				if (checkBeforeWritefile(newtxt)){
					FileWriter filewriter = new FileWriter(newtxt);
					filewriter.write(Todo.map+"");
					System.out.println("ファイルに書き込み成功しました");
					filewriter.close();
				}else{
					System.out.println("ファイルに書き込み失敗しました");
				}
			}else if (!(newtxt.canRead() && newtxt.canWrite())) {
				System.out.println("ファイルは読み込み不可です");
				System.out.println("ファイルは書き込み不可です");
			}
		}catch(IOException io){
			System.out.println(io);
		}
	}
	static void Insert(){
		class Insert extends JInternalFrame {
			public Insert(){
				this.setSize( new Dimension(100,200) );
				this.setClosable(true);
				this.setResizable(true);
				this.setIconifiable(true);
				this.setMaximizable(true);
				this.add(new JLabel("InnerFrame"));
			}
		}
		

		
	}

	private static boolean checkBeforeWritefile(File file){
		if (file.exists()){
			if (file.isFile() && file.canWrite()){
				return true;
			}
		}

		return false;
	}

}
