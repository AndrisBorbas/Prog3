package swingmvclab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

/*
 * A megjelen�tend� ablakunk oszt�lya.
 */
public class StudentFrame extends JFrame {

	/*
	 * Ebben az objektumban vannak a hallgat�i adatok. A program indul�s ut�n
	 * bet�lti az adatokat f�jlb�l, bez�r�skor pedig kimenti oda.
	 * 
	 * NE M�DOS�TSD!
	 */
	private StudentData data;
	private JTextField nevTextF;
	private JTextField neptunTextF;

	public class StudentTableCellRenderer implements TableCellRenderer {
		private final TableCellRenderer renderer;

		public StudentTableCellRenderer(TableCellRenderer defRenderer) {
			this.renderer = defRenderer;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component component = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
					column);
			Student actualStudent = data.students.get(table.getRowSorter().convertRowIndexToModel(row));

			if (actualStudent.getGrade() <= 1)
				component.setBackground(Color.RED);
			else
				component.setBackground(Color.GREEN);

			return component;
		}

	}

	/*
	 * Itt hozzuk l�tre �s adjuk hozz� az ablakunkhoz a k�l�nb�z� komponenseket
	 * (t�bl�zat, beviteli mez�, gomb).
	 */
	private void initComponents() {
		/*
		 * try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
		 * catch (ClassNotFoundException | InstantiationException |
		 * IllegalAccessException | UnsupportedLookAndFeelException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		this.setLayout(new BorderLayout());
		JTable table = new JTable(data);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		table.setDefaultRenderer(String.class, new StudentTableCellRenderer(table.getDefaultRenderer(String.class)));
		table.setDefaultRenderer(Number.class, new StudentTableCellRenderer(table.getDefaultRenderer(Number.class)));
		table.setDefaultRenderer(Boolean.class, new StudentTableCellRenderer(table.getDefaultRenderer(Boolean.class)));
		this.add(new JScrollPane(table), BorderLayout.CENTER);

		JPanel panel = new JPanel();
		nevTextF = new JTextField(20);
		neptunTextF = new JTextField(6);
		JButton addButton = new JButton("Felvesz");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				data.addStudent(nevTextF.getText(), neptunTextF.getText());
				table.updateUI();
			}
		});
		panel.add(new JLabel("N�v:"));
		panel.add(nevTextF);
		panel.add(new JLabel("Neptun:"));
		panel.add(neptunTextF);
		panel.add(addButton);
		this.add(panel, BorderLayout.SOUTH);

		// ...
	}

	/*
	 * Az ablak konstruktora.
	 * 
	 * NE M�DOS�TSD!
	 */
	@SuppressWarnings("unchecked")
	public StudentFrame() {
		super("Hallgat�i nyilv�ntart�s");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Indul�skor bet�ltj�k az adatokat
		try {
			data = new StudentData();
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"));
			data.students = (List<Student>) ois.readObject();
			ois.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// Bez�r�skor mentj�k az adatokat
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"));
					oos.writeObject(data.students);
					oos.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		// Fel�p�tj�k az ablakot
		setMinimumSize(new Dimension(500, 200));
		initComponents();
	}

	/*
	 * A program bel�p�si pontja.
	 * 
	 * NE M�DOS�TSD!
	 */
	public static void main(String[] args) {
		// Megjelen�tj�k az ablakot
		StudentFrame sf = new StudentFrame();
		sf.setVisible(true);
	}
}
