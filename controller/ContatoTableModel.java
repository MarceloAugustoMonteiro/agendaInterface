package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import model.Contato;

public class ContatoTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private List<Contato> contatos = new ArrayList<Contato>();
    
    public void setContatos(List<Contato> contatos) {
        this.contatos.clear();
        this.contatos.addAll(contatos);
        fireTableDataChanged();
    }

    public void addContato(Contato contato) {
        contatos.add(contato);
        fireTableDataChanged();
    }

    public Contato getContato(int idx) {
        return contatos.get(idx);
    }

    public void delContato(int idx) {
        contatos.remove(idx);
        fireTableDataChanged();
    }

    public int getRowCount() {
        return contatos.size();
    }

    public int getColumnCount() {
        return 4;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Contato c = contatos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getNome();
            case 1:
                return c.getIdade();
            case 2:
                return c.getTelefone();
            case 3:
                return c.getEmail();
            default:
                return null;
        }
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Nome";
            case 1:
                return "Idade";
            case 2:
                return "Telefone";
            case 3:
                return "E-mail";
            default:
                return null;
        }
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            default:
                return null;
        }
    }
}