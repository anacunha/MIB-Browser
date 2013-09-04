package gui;

import mibbrowser.SNMPController;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import mibbrowser.NoSuchInstanceException;
import mibbrowser.NoSuchObjectException;
import mibbrowser.SNMPManager;
import mibbrowser.SetRequestException;
import mibbrowser.WrongObjectTypeException;

/**
 *
 * @author Ana Luiza Cunha
 * @author Juliana Damasio Oliveira
 * @author Rodrigo Oliveira de Freitas
 */
public class Main extends javax.swing.JFrame {

    private SNMPController manager;
    
    public Main() {
        initComponents();
        manager = new SNMPController();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelAgente = new javax.swing.JPanel();
        jLabelIP = new javax.swing.JLabel();
        jTextFieldIP = new javax.swing.JTextField();
        jPanelResultados = new javax.swing.JPanel();
        jScrollPaneResultados = new javax.swing.JScrollPane();
        jTableResultados = new javax.swing.JTable();
        jPanelOperacao = new javax.swing.JPanel();
        jLabelObjeto = new javax.swing.JLabel();
        jTextFieldObjeto = new javax.swing.JTextField();
        jLabelOperacao = new javax.swing.JLabel();
        jComboBoxOperacao = new javax.swing.JComboBox();
        jLabelComunidade = new javax.swing.JLabel();
        jComboBoxComunidade = new javax.swing.JComboBox();
        jPanelParametros = new javax.swing.JPanel();
        jLabelValor = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jLabelNonRepeaters = new javax.swing.JLabel();
        jLabelMaxRepetitions = new javax.swing.JLabel();
        jButtonOK = new javax.swing.JButton();
        jLabelTempo = new javax.swing.JLabel();
        jLabelAmostras = new javax.swing.JLabel();
        jFormattedTextFieldNonRepeaters = new javax.swing.JFormattedTextField();
        jFormattedTextFieldMaxRepetitions = new javax.swing.JFormattedTextField();
        jFormattedTextFieldTempo = new javax.swing.JFormattedTextField();
        jFormattedTextFieldAmostras = new javax.swing.JFormattedTextField();
        jLabelTipoObjeto = new javax.swing.JLabel();
        jComboBoxTipoObjeto = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SNMP Manager");

        jPanelAgente.setBorder(javax.swing.BorderFactory.createTitledBorder("Agente"));

        jLabelIP.setText("IP");

        jTextFieldIP.setText("localhost");

        org.jdesktop.layout.GroupLayout jPanelAgenteLayout = new org.jdesktop.layout.GroupLayout(jPanelAgente);
        jPanelAgente.setLayout(jPanelAgenteLayout);
        jPanelAgenteLayout.setHorizontalGroup(
            jPanelAgenteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelAgenteLayout.createSequentialGroup()
                .addContainerGap()
                .add(jLabelIP)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jTextFieldIP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelAgenteLayout.setVerticalGroup(
            jPanelAgenteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelAgenteLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelAgenteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelIP)
                    .add(jTextFieldIP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jPanelResultados.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados"));

        jTableResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Operacao", "Resultado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneResultados.setViewportView(jTableResultados);

        org.jdesktop.layout.GroupLayout jPanelResultadosLayout = new org.jdesktop.layout.GroupLayout(jPanelResultados);
        jPanelResultados.setLayout(jPanelResultadosLayout);
        jPanelResultadosLayout.setHorizontalGroup(
            jPanelResultadosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPaneResultados)
                .addContainerGap())
        );
        jPanelResultadosLayout.setVerticalGroup(
            jPanelResultadosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPaneResultados, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelOperacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Operação"));
        jPanelOperacao.setAlignmentX(0.0F);
        jPanelOperacao.setAlignmentY(0.0F);

        jLabelObjeto.setText("Objeto (OID e instância)");

        jTextFieldObjeto.setText("1.3.6.1.2.1.1.1.0");

        jLabelOperacao.setText("Tipo da Operação");

        jComboBoxOperacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GET", "GETNEXT", "SET", "GETBULK", "WALK", "GETTABLE", "GETDELTA" }));
        jComboBoxOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOperacaoActionPerformed(evt);
            }
        });

        jLabelComunidade.setText("Comunidade");

        jComboBoxComunidade.setEditable(true);
        jComboBoxComunidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "public", "private" }));

        org.jdesktop.layout.GroupLayout jPanelOperacaoLayout = new org.jdesktop.layout.GroupLayout(jPanelOperacao);
        jPanelOperacao.setLayout(jPanelOperacaoLayout);
        jPanelOperacaoLayout.setHorizontalGroup(
            jPanelOperacaoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelOperacaoLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelOperacaoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelOperacaoLayout.createSequentialGroup()
                        .add(jLabelObjeto)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTextFieldObjeto))
                    .add(jPanelOperacaoLayout.createSequentialGroup()
                        .add(jPanelOperacaoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabelOperacao)
                            .add(jLabelComunidade))
                        .add(74, 74, 74)
                        .add(jPanelOperacaoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jComboBoxOperacao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jComboBoxComunidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelOperacaoLayout.setVerticalGroup(
            jPanelOperacaoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelOperacaoLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanelOperacaoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelObjeto)
                    .add(jTextFieldObjeto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanelOperacaoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelOperacao)
                    .add(jComboBoxOperacao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanelOperacaoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jComboBoxComunidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabelComunidade))
                .add(154, 154, 154))
        );

        jPanelParametros.setBorder(javax.swing.BorderFactory.createTitledBorder("Parâmetros"));

        jLabelValor.setText("Valor");
        jLabelValor.setEnabled(false);

        jTextFieldValor.setEnabled(false);

        jLabelNonRepeaters.setText("N (non-repeaters)");
        jLabelNonRepeaters.setEnabled(false);

        jLabelMaxRepetitions.setText("M (max-repetitions)");
        jLabelMaxRepetitions.setEnabled(false);

        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jLabelTempo.setText("Tempo");
        jLabelTempo.setEnabled(false);

        jLabelAmostras.setText("Amostras");
        jLabelAmostras.setEnabled(false);

        jFormattedTextFieldNonRepeaters.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldNonRepeaters.setEnabled(false);

        jFormattedTextFieldMaxRepetitions.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldMaxRepetitions.setEnabled(false);

        jFormattedTextFieldTempo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldTempo.setEnabled(false);

        jFormattedTextFieldAmostras.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldAmostras.setEnabled(false);

        jLabelTipoObjeto.setText("Tipo Objeto");
        jLabelTipoObjeto.setEnabled(false);

        jComboBoxTipoObjeto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Counter", "Gauge32", "Integer32", "IpAddress", "Octet String", "TimeTicks" }));
        jComboBoxTipoObjeto.setEnabled(false);

        org.jdesktop.layout.GroupLayout jPanelParametrosLayout = new org.jdesktop.layout.GroupLayout(jPanelParametros);
        jPanelParametros.setLayout(jPanelParametrosLayout);
        jPanelParametrosLayout.setHorizontalGroup(
            jPanelParametrosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelParametrosLayout.createSequentialGroup()
                .add(16, 16, 16)
                .add(jPanelParametrosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanelParametrosLayout.createSequentialGroup()
                        .add(jLabelValor)
                        .add(18, 18, 18)
                        .add(jTextFieldValor))
                    .add(jPanelParametrosLayout.createSequentialGroup()
                        .add(jPanelParametrosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabelMaxRepetitions)
                            .add(jLabelNonRepeaters))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanelParametrosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jFormattedTextFieldNonRepeaters, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .add(jFormattedTextFieldMaxRepetitions))))
                .add(80, 80, 80)
                .add(jPanelParametrosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelParametrosLayout.createSequentialGroup()
                        .add(jPanelParametrosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabelAmostras)
                            .add(jLabelTempo))
                        .add(21, 21, 21)
                        .add(jPanelParametrosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jFormattedTextFieldTempo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPanelParametrosLayout.createSequentialGroup()
                                .add(jFormattedTextFieldAmostras, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 14, Short.MAX_VALUE)
                                .add(jButtonOK))))
                    .add(jPanelParametrosLayout.createSequentialGroup()
                        .add(jLabelTipoObjeto)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jComboBoxTipoObjeto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(26, 26, 26))
        );
        jPanelParametrosLayout.setVerticalGroup(
            jPanelParametrosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelParametrosLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelParametrosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextFieldValor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabelValor)
                    .add(jLabelTipoObjeto)
                    .add(jComboBoxTipoObjeto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanelParametrosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelNonRepeaters)
                    .add(jLabelTempo)
                    .add(jFormattedTextFieldNonRepeaters, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jFormattedTextFieldTempo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanelParametrosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelMaxRepetitions)
                    .add(jLabelAmostras)
                    .add(jFormattedTextFieldMaxRepetitions, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jFormattedTextFieldAmostras, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButtonOK))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelResultados, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(jPanelAgente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanelOperacao, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jPanelParametros, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanelAgente, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanelOperacao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 132, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanelParametros, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(10, 10, 10)
                .add(jPanelResultados, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOperacaoActionPerformed
        switch (jComboBoxOperacao.getSelectedItem().toString()) {
            case "GET":
                jLabelValor.setEnabled(false);
                jTextFieldValor.setEnabled(false);
                jLabelTipoObjeto.setEnabled(false);
                jComboBoxTipoObjeto.setEnabled(false);
                jLabelNonRepeaters.setEnabled(false);
                jFormattedTextFieldNonRepeaters.setEnabled(false);
                jLabelMaxRepetitions.setEnabled(false);
                jFormattedTextFieldMaxRepetitions.setEnabled(false);
                jLabelTempo.setEnabled(false);
                jFormattedTextFieldTempo.setEnabled(false);
                jLabelAmostras.setEnabled(false);
                jFormattedTextFieldAmostras.setEnabled(false);
                break;
            case "GETNEXT":
                jLabelValor.setEnabled(false);
                jTextFieldValor.setEnabled(false);
                jLabelTipoObjeto.setEnabled(false);
                jComboBoxTipoObjeto.setEnabled(false);
                jLabelNonRepeaters.setEnabled(false);
                jFormattedTextFieldNonRepeaters.setEnabled(false);
                jLabelMaxRepetitions.setEnabled(false);
                jFormattedTextFieldMaxRepetitions.setEnabled(false);
                jLabelTempo.setEnabled(false);
                jFormattedTextFieldTempo.setEnabled(false);
                jLabelAmostras.setEnabled(false);
                jFormattedTextFieldAmostras.setEnabled(false);
                break;
            case "SET": 
                jLabelValor.setEnabled(true);
                jTextFieldValor.setEnabled(true);
                jLabelTipoObjeto.setEnabled(true);
                jComboBoxTipoObjeto.setEnabled(true);
                jLabelNonRepeaters.setEnabled(false);
                jFormattedTextFieldNonRepeaters.setEnabled(false);
                jLabelMaxRepetitions.setEnabled(false);
                jFormattedTextFieldMaxRepetitions.setEnabled(false);
                jLabelTempo.setEnabled(false);
                jFormattedTextFieldTempo.setEnabled(false);
                jLabelAmostras.setEnabled(false);
                jFormattedTextFieldAmostras.setEnabled(false);
                break;
            case "GETBULK":
                jLabelValor.setEnabled(false);
                jTextFieldValor.setEnabled(false);
                jLabelTipoObjeto.setEnabled(false);
                jComboBoxTipoObjeto.setEnabled(false);
                jLabelNonRepeaters.setEnabled(true);
                jFormattedTextFieldNonRepeaters.setEnabled(true);
                jLabelMaxRepetitions.setEnabled(true);
                jFormattedTextFieldMaxRepetitions.setEnabled(true);
                jLabelTempo.setEnabled(false);
                jFormattedTextFieldTempo.setEnabled(false);
                jLabelAmostras.setEnabled(false);
                jFormattedTextFieldAmostras.setEnabled(false);
                break;
            case "WALK":
                jLabelValor.setEnabled(false);
                jTextFieldValor.setEnabled(false);
                jLabelTipoObjeto.setEnabled(false);
                jComboBoxTipoObjeto.setEnabled(false);
                jLabelNonRepeaters.setEnabled(false);
                jFormattedTextFieldNonRepeaters.setEnabled(false);
                jLabelMaxRepetitions.setEnabled(false);
                jFormattedTextFieldMaxRepetitions.setEnabled(false);
                jLabelTempo.setEnabled(false);
                jFormattedTextFieldTempo.setEnabled(false);
                jLabelAmostras.setEnabled(false);
                jFormattedTextFieldAmostras.setEnabled(false);
                break;
            case "GETTABLE":
                jLabelValor.setEnabled(false);
                jTextFieldValor.setEnabled(false);
                jLabelTipoObjeto.setEnabled(false);
                jComboBoxTipoObjeto.setEnabled(false);
                jLabelNonRepeaters.setEnabled(false);
                jFormattedTextFieldNonRepeaters.setEnabled(false);
                jLabelMaxRepetitions.setEnabled(false);
                jFormattedTextFieldMaxRepetitions.setEnabled(false);
                jLabelTempo.setEnabled(false);
                jFormattedTextFieldTempo.setEnabled(false);
                jLabelAmostras.setEnabled(false);
                jFormattedTextFieldAmostras.setEnabled(false);
                break;
            case "GETDELTA":
                jLabelValor.setEnabled(false);
                jTextFieldValor.setEnabled(false);
                jLabelTipoObjeto.setEnabled(false);
                jComboBoxTipoObjeto.setEnabled(false);
                jLabelNonRepeaters.setEnabled(false);
                jFormattedTextFieldNonRepeaters.setEnabled(false);
                jLabelMaxRepetitions.setEnabled(false);
                jFormattedTextFieldMaxRepetitions.setEnabled(false);
                jLabelTempo.setEnabled(true);
                jFormattedTextFieldTempo.setEnabled(true);
                jLabelAmostras.setEnabled(true);
                jFormattedTextFieldAmostras.setEnabled(true);
                break;
        } 
    }//GEN-LAST:event_jComboBoxOperacaoActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        manager.setIp(jTextFieldIP.getText());
        manager.setComunidade(jComboBoxComunidade.getSelectedItem().toString());
        switch (jComboBoxOperacao.getSelectedItem().toString()) {
            case "GET":
                try {
                    Object[] resultado = manager.get(jTextFieldObjeto.getText());
                    DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Operacao", "Resultado"}, 0);
                    tableModel.addRow(resultado);
                    jTableResultados.setModel(tableModel);
                } catch (Exception e) {
                    if(e instanceof NoSuchObjectException || e instanceof NoSuchInstanceException)
                        JOptionPane.showMessageDialog(null,e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
                    else {
                        if(e instanceof NumberFormatException)
                            JOptionPane.showMessageDialog(null, "Objeto invalido: " + jTextFieldObjeto.getText(), "Erro", JOptionPane.ERROR_MESSAGE);
                        else {
                            JOptionPane.showMessageDialog(null,"Nao houve resposta do agente " + jTextFieldIP.getText(),"Erro", JOptionPane.ERROR_MESSAGE);
                            //e.printStackTrace();
                        }
                    }
                }
                break;
            case "GETNEXT":
                try {
                    Object[] resultado = manager.getNext(jTextFieldObjeto.getText());
                    DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Operacao", "Resultado"}, 0);
                    tableModel.addRow(resultado);
                    jTableResultados.setModel(tableModel);
                } catch (Exception e) {
                    if(e instanceof NumberFormatException)
                        JOptionPane.showMessageDialog(null, "Objeto invalido: " + jTextFieldObjeto.getText(), "Erro", JOptionPane.ERROR_MESSAGE);
                    else {
                        JOptionPane.showMessageDialog(null,"Nao houve resposta do agente " + jTextFieldIP.getText(),"Erro", JOptionPane.ERROR_MESSAGE);
                        //e.printStackTrace();
                    }
                }
                break;
            case "SET":
                try {
                    String valor = jTextFieldValor.getText();
                    
                    if(valor.isEmpty() || valor == null) {
                        JOptionPane.showMessageDialog(null,"Insira um valor para operacao SET","Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Object[] resultado = manager.set(jTextFieldObjeto.getText(), jTextFieldValor.getText(), jComboBoxTipoObjeto.getSelectedItem().toString());
                    DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Operacao", "Resultado"}, 0);
                    tableModel.addRow(resultado);
                    jTableResultados.setModel(tableModel);                    
                } catch (Exception e) {
                    if(e instanceof SetRequestException || e instanceof NoSuchInstanceException || e instanceof NoSuchObjectException || e instanceof WrongObjectTypeException) 
                        JOptionPane.showMessageDialog(null,e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
                    else {
                        if(e instanceof NumberFormatException)
                            JOptionPane.showMessageDialog(null, "Objeto invalido: " + jTextFieldObjeto.getText(), "Erro", JOptionPane.ERROR_MESSAGE);
                        else {
                            JOptionPane.showMessageDialog(null,"Nao houve resposta do agente " + jTextFieldIP.getText(),"Erro", JOptionPane.ERROR_MESSAGE);
                            //e.printStackTrace();
                        }
                    }
                }
                break;
            case "GETBULK":
                try {
                    int nonRepeaters = Integer.parseInt(jFormattedTextFieldNonRepeaters.getText());
                    int maxRepetitions = Integer.parseInt(jFormattedTextFieldMaxRepetitions.getText());
                    if(nonRepeaters < 0 || maxRepetitions < 0) {
                        JOptionPane.showMessageDialog(null,"Valores incorretos para non-repeaters e/ou max-repetitions","Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    Object[][] resultado = manager.getBulk(jTextFieldObjeto.getText(), nonRepeaters, maxRepetitions);
                    DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Operacao", "Resultado"}, 0);                  
                    for(int i = 0; i < resultado.length; i++) {
                        tableModel.addRow(resultado[i]);
                    }
                    jTableResultados.setModel(tableModel);
                } catch (Exception e) {
                    if(e instanceof NumberFormatException)
                        JOptionPane.showMessageDialog(null,"Valores incorretos para non-repeaters e/ou max-repetitions","Erro", JOptionPane.ERROR_MESSAGE);
                    else {
                        JOptionPane.showMessageDialog(null,"Nao houve resposta do agente " + jTextFieldIP.getText(),"Erro", JOptionPane.ERROR_MESSAGE);
                        //e.printStackTrace();
                    }
                }
                break;
            case "WALK":
                try {
                    Object[][] resultado = manager.walk(jTextFieldObjeto.getText());
                    DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Operacao", "Resultado"}, 0);
                    jTableResultados.setModel(tableModel); 
                    for(int i = 0; i < resultado.length; i++) {
                        tableModel.addRow(resultado[i]);
                    }
                    jTableResultados.setModel(tableModel);
                } catch (Exception e) {
                    if(e instanceof NumberFormatException)
                        JOptionPane.showMessageDialog(null, "Objeto invalido: " + jTextFieldObjeto.getText(), "Erro", JOptionPane.ERROR_MESSAGE);
                    else {
                        JOptionPane.showMessageDialog(null,"Nao houve resposta do agente " + jTextFieldIP.getText(),"Erro", JOptionPane.ERROR_MESSAGE);
                        //e.printStackTrace();
                    }
                }
                break;
            case "GETTABLE":
                try {
                    Object[][] resultado = manager.getTable(jTextFieldObjeto.getText());
                    DefaultTableModel tableModel = new DefaultTableModel(resultado[0], 0);
                    for(int i = 1; i < resultado.length; i ++) {
                        tableModel.addRow(resultado[i]);
                    }
                    jTableResultados.setModel(tableModel);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "GETDELTA":
                try{
                    int tempo = Integer.parseInt(jFormattedTextFieldTempo.getText());
                    int amostras = Integer.parseInt(jFormattedTextFieldAmostras.getText());
                    if(tempo <= 0 || amostras <= 1) {
                        JOptionPane.showMessageDialog(null,"Valores incorretos para tempo e/ou amostras","Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String objeto = jTextFieldObjeto.getText();
                    String tipoVariavel = manager.getTipoVariavel(objeto);
        
                    if(tipoVariavel.equals("Integer32") || tipoVariavel.equals("Counter")) {           
                        new Worker().execute();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "GET-DELTA nao suportado para objetos do tipo " + tipoVariavel, "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch(Exception e) {
                    if(e instanceof NumberFormatException)
                        JOptionPane.showMessageDialog(null, "Valores incorretos para tempo e/ou amostras", "Erro", JOptionPane.ERROR_MESSAGE);
                    else {
                        if(e instanceof UnsupportedOperationException)
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        else {
                            if(e instanceof NoSuchObjectException)
                                JOptionPane.showMessageDialog(null,e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
                            else {
                                if(e instanceof NoSuchInstanceException)
                                    JOptionPane.showMessageDialog(null,e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
                                else {
                                    JOptionPane.showMessageDialog(null, "Nao houve resposta do agente " + jTextFieldIP.getText(), "Erro", JOptionPane.ERROR_MESSAGE);
                                    //e.printStackTrace();
                                }
                            }
                        }
                    }
                }
                break;
        }
    }//GEN-LAST:event_jButtonOKActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOK;
    private javax.swing.JComboBox jComboBoxComunidade;
    private javax.swing.JComboBox jComboBoxOperacao;
    private javax.swing.JComboBox jComboBoxTipoObjeto;
    private javax.swing.JFormattedTextField jFormattedTextFieldAmostras;
    private javax.swing.JFormattedTextField jFormattedTextFieldMaxRepetitions;
    private javax.swing.JFormattedTextField jFormattedTextFieldNonRepeaters;
    private javax.swing.JFormattedTextField jFormattedTextFieldTempo;
    private javax.swing.JLabel jLabelAmostras;
    private javax.swing.JLabel jLabelComunidade;
    private javax.swing.JLabel jLabelIP;
    private javax.swing.JLabel jLabelMaxRepetitions;
    private javax.swing.JLabel jLabelNonRepeaters;
    private javax.swing.JLabel jLabelObjeto;
    private javax.swing.JLabel jLabelOperacao;
    private javax.swing.JLabel jLabelTempo;
    private javax.swing.JLabel jLabelTipoObjeto;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JPanel jPanelAgente;
    private javax.swing.JPanel jPanelOperacao;
    private javax.swing.JPanel jPanelParametros;
    private javax.swing.JPanel jPanelResultados;
    private javax.swing.JScrollPane jScrollPaneResultados;
    private javax.swing.JTable jTableResultados;
    private javax.swing.JTextField jTextFieldIP;
    private javax.swing.JTextField jTextFieldObjeto;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
    
    public class Worker extends SwingWorker<String, String> {
        @Override
        protected String doInBackground() throws Exception {
            
            String objeto = jTextFieldObjeto.getText();
            int tempo = Integer.parseInt(jFormattedTextFieldTempo.getText());
            int amostras = Integer.parseInt(jFormattedTextFieldAmostras.getText());
            int getRequestsLeft = amostras - 1;
            String valorAnterior =  SNMPManager.get(jTextFieldIP.getText(), jComboBoxComunidade.getSelectedItem().toString(), objeto);

            SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
            DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Tempo", "Anterior", "Atual", "Delta"}, 0);
            tableModel.addRow(new String[]{"" + "" + df.format(new GregorianCalendar().getTime()), "-", valorAnterior, "-"});
            jTableResultados.setModel(tableModel);

            while(getRequestsLeft > 0) {
                Thread.sleep(tempo * 1000);                            
                String[] getDelta = manager.getDelta(objeto, valorAnterior);
                valorAnterior = getDelta[2];
                publish(getDelta);
                getRequestsLeft--;
            }
            return null;
        }

        protected void process(List<String> item) {
            //This updates the UI
            DefaultTableModel tableModel = (DefaultTableModel) jTableResultados.getModel();
            tableModel.addRow(item.toArray());
        }
    }
}
