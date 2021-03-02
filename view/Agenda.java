package view;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controller.ContatoTableModel;
import model.Contato;

public class Agenda extends JFrame {
    private static final long serialVersionUID = 1L;
    private final JTextField nome;
    private final JTextField idade;
    private final JTextField telefone;
    private final JTextField email;

    public Agenda() {
        
        super("Cadastro Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel entradas = new JPanel();
        entradas.setLayout(new GridLayout(0, 2));

        entradas.add(new JLabel("Nome:"));
        nome = new JTextField(20);
        entradas.add(nome);

        entradas.add(new JLabel("Idade:"));
        idade = new JTextField(20);
        entradas.add(idade);

        entradas.add(new JLabel("Telefone:"));
        telefone = new JTextField(20);
        entradas.add(telefone);

        entradas.add(new JLabel("E-mail:"));
        email = new JTextField(20);
        entradas.add(email);

        final JButton btGravar = new JButton("Gravar");
        entradas.add(btGravar);
        
        final JButton btClear = new JButton("Limpar Campos");
        entradas.add(btClear);

        add(entradas, BorderLayout.NORTH);

        List<Contato> contatos = new ArrayList<Contato>();
        contatos.add(new Contato("Carlos", 25, "1234", "carlos@gmail.com"));
        contatos.add(new Contato("Juliana", 18, "3423423", "juliana@hotmail.com"));
        contatos.add(new Contato("John", 40, "3423234", "john@watson.com"));

        ContatoTableModel ptm = new ContatoTableModel();
        ptm.setContatos(contatos);
        JTable tabela = new JTable();
        tabela.setModel(ptm);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        btGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ptm.addContato(new Contato(
                    nome.getText(),
                    Integer.valueOf(idade.getText()),
                    telefone.getText(),
                    email.getText()              
                ));
            }
        });

        btClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        
        tabela.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {
                Contato c = ptm.getContato(tabela.getSelectedRow());
                nome.setText(c.getNome());
                idade.setText("" + c.getIdade());
                telefone.setText(c.getTelefone());
                email.setText(c.getEmail());  
            }
            
            @Override
            public void mouseEntered(MouseEvent arg0) {
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
            }
        });

        tabela.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent arg0) {
                ptm.delContato(tabela.getSelectedRow());               
            }

            @Override
            public void keyReleased(KeyEvent arg0) {
            }

            @Override
            public void keyTyped(KeyEvent arg0) {
            }
            
        });

        pack();
        setVisible(true);
    }

    private void clear() {
        nome.setText("");
        idade.setText("");
        telefone.setText("");
        email.setText("");
    }
    
    public static void main(String[] args) {
        new Agenda();
    }
}