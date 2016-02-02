import javax.swing.SwingUtilities;

class remove extends Thread{
	int index;
	remove(int index) {
		this.index = index;
	}
	public void run() {
		Task();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Todo.ListModel.remove(index);
				Todo.setbtn(true);
			}
		});
	}


	static void Task() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException ex) {
		}
	}
}