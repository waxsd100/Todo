import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


	class Select
	implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {

			if (Todo.List.getSelectedIndices().length!=1){
				return;
			}
			Todo.Inputarea.setText((String)Todo.List.getSelectedValue());
		}
	}