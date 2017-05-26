package tela;

import avl.AVLtree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import leitura.readerCsv;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Combobox extends javax.swing.JFrame {

    private ArrayList<AVLtree> avl = new ArrayList<>();
    String[] str;
    public ArrayList<AVLtree> getAvl() {
        return avl;
    }

    public void setAvl(ArrayList<AVLtree> avl) {
        this.avl = avl;
    }
    
    public Combobox() {
    	setAlwaysOnTop(true);    	
        initComponents();
    }

	private String[] listDados(String nome) {
		try {
            try ( 
                BufferedReader StrR = new BufferedReader(new FileReader(nome))) {
                 return StrR.readLine().split(";");
            }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ex){
                ex.printStackTrace();
            }
		return null;
	}
    private void initComponents() {

        painel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        coluna_box = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        textBusca = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        busca = new javax.swing.JButton();
        menuBar = new JMenuBar();
    	setJMenuBar(menuBar);
    	
    	mnAbrir = new JMenu("Abrir");
    	menuBar.add(mnAbrir);
    	
    	mntmProcurar = new JMenuItem("Procurar");
    	mntmProcurar.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			mnArquivoActionPerformed(e);
    		}
    	});
    	mnAbrir.add(mntmProcurar);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Buscar Por");

        coluna_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coluna_boxActionPerformed(evt);
            }
        });

        jLabel2.setText("Palavra Chave");

        
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        busca.setText("Buscar");
        busca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painelLayout.setHorizontalGroup(
        	painelLayout.createParallelGroup(Alignment.CENTER)
        		.addGroup(painelLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(painelLayout.createParallelGroup(Alignment.CENTER)
        				.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        				.addGroup(painelLayout.createSequentialGroup()
        					.addGroup(painelLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel2))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(painelLayout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(coluna_box, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(textBusca, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
        					.addGap(18)
        					.addComponent(busca)
        					.addGap(48, 278, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        painelLayout.setVerticalGroup(
        	painelLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(painelLayout.createSequentialGroup()
        			.addGap(22)
        			.addGroup(painelLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel1)
        				.addComponent(coluna_box, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(painelLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(textBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(busca))
        			.addGap(28)
        			.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
        			.addGap(57))
        );
        painel.setLayout(painelLayout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(painel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(painel, GroupLayout.PREFERRED_SIZE, 382, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void coluna_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coluna_boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coluna_boxActionPerformed

    private void buscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaActionPerformed
    	
        String coluna = (String) coluna_box.getSelectedItem();
        //jTable1.setModel(new DefaultTableModel(null, str));
        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        
        coluna_box.getItemCount();
        
        for (int i = 0; i <= coluna_box.getItemCount(); i++) {
            if(coluna.equalsIgnoreCase  ((String) coluna_box.getItemAt(i))){
                
                table.setNumRows(0);
                try {
                    for (avl.AVLtree.Node no : getAvl().get(i).inorder(textBusca.getText())) {
                        Vector<String> v = new Vector<>();
                        no.getDados().getDados().forEach(v::add);
                        table.addRow(v);
                    }                   
                } catch (NullPointerException e) {
                }
                break;
            }
        }
    }//GEN-LAST:event_buscaActionPerformed
    
    private void mnArquivoActionPerformed(ActionEvent evt){
    	avl.clear();
    	System.out.println("entrou?");
    	JFileChooser jf = new JFileChooser();
    	jf.setMultiSelectionEnabled(false);
    	jf.showOpenDialog(this);
    	long tempInicial = System.currentTimeMillis();
        try {
        	readerCsv red = new readerCsv();
        	//red.createCsvFile();
            red.readCsvFile(jf.getSelectedFile().getName()).forEach((avl1) -> {
                avl.add(avl1);
            });
        } catch (NullPointerException e) {}
        
        str = listDados(jf.getSelectedFile().getName());
        
        for (String st : str) {
			System.out.println(st);
		}
        
        long tempFinal = System.currentTimeMillis();
        long dif = (tempFinal - tempInicial);
        long minutes = dif / 1000 / 60;
		dif -= minutes * 1000 * 60;
		long seconds = dif / 1000;
		dif -= seconds * 1000;
        System.out.println(String.format("%02d minutos e %02d segundos", minutes, seconds));
        
        setAtributos();
    	
    }

	private void setAtributos() {
		coluna_box.setModel(new javax.swing.DefaultComboBoxModel<>(str));
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                str
            ) {
                /**
    			 * 
    			 */
    			private static final long serialVersionUID = 1L;
    			boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
	}

    public static void main(String args[]) {        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Combobox().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton busca;
    private javax.swing.JComboBox<String> coluna_box;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel painel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField textBusca;
    private JMenuBar menuBar;
    private JMenu mnAbrir;
    private JMenuItem mntmProcurar;
}
