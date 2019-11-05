package swingmvclab;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/*
 * A hallgatók adatait tároló osztály.
 */
public class StudentData extends AbstractTableModel {

	/*
	 * Ez a tagváltozó tárolja a hallgatói adatokat. NE MÓDOSÍTSD!
	 */
	List<Student> students = new ArrayList<Student>();

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return students.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Név";
		case 1:
			return "Neptun";
		case 2:
			return "Aláírás";
		default:
			return "Jegy";
		}
	}

	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 2:
			return Boolean.class;
		case 3:
			return Integer.class;
		default:
			return String.class;
		}
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Student s = students.get(rowIndex);
		if (columnIndex >= 2 && columnIndex <= 3) {
			switch (columnIndex) {
			case 2:
				s.setSignature((Boolean) aValue);
				break;
			case 3:
				s.setGrade((Integer) aValue);
				break;
			}
			students.set(rowIndex, s);
			this.fireTableRowsUpdated(rowIndex, rowIndex);
		}
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return false;
		case 1:
			return false;
		case 2:
			return true;
		case 3:
			return true;
		default:
			return false;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student student = students.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return student.getName();
		case 1:
			return student.getNeptun();
		case 2:
			return student.hasSignature();
		default:
			return student.getGrade();
		}
	}

	public void addStudent(String name, String neptun) {
		students.add(new Student(name, neptun, Boolean.FALSE, 0));
		this.fireTableDataChanged();
	}

}
