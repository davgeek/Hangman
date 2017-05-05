
package hangmangui.mvc;

import java.util.Observable;
import java.util.Observer;
import login.DlgLogin;
import javax.swing.JOptionPane;
import packets.PacketGameStart;
import packets.PacketMessage;
import packets.PacketUserMove;


public class View extends javax.swing.JFrame implements Observer{

    Model model;
    Controller controller;
    HangingMan hangingMan;
    String prevCatagory;
    DlgLogin login;
    String nick;
    String server;

    public View(Model model, Controller controller) {
        initComponents();
        this.model = model;
        this.controller = controller;
        this.hangingMan = new HangingMan(model);
        
        this.login = new DlgLogin(this, rootPaneCheckingEnabled);
        login.setVisible(true);
        
        this.server = login.getServer();
        model.connect(server);
        
        this.nick = login.getUser();
        model.filter.login(nick);        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        basePanel = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField_HangManWord = new javax.swing.JTextField();
        Keyboard_Panel = new javax.swing.JPanel();
        jButton_A = new javax.swing.JButton();
        jButton_B = new javax.swing.JButton();
        jButton_C = new javax.swing.JButton();
        jButton_D = new javax.swing.JButton();
        jButton_E = new javax.swing.JButton();
        jButtonF = new javax.swing.JButton();
        jButton_G = new javax.swing.JButton();
        jButton_H = new javax.swing.JButton();
        jButton_I = new javax.swing.JButton();
        jButton_J = new javax.swing.JButton();
        jButton_K = new javax.swing.JButton();
        jButton_L = new javax.swing.JButton();
        jButtonM = new javax.swing.JButton();
        jButton_N = new javax.swing.JButton();
        jButton_Ñ = new javax.swing.JButton();
        jButton_O = new javax.swing.JButton();
        jButton_P = new javax.swing.JButton();
        jButton_Z = new javax.swing.JButton();
        jButton_U = new javax.swing.JButton();
        jButton_V = new javax.swing.JButton();
        jButton_Q = new javax.swing.JButton();
        jButton_R = new javax.swing.JButton();
        jButton_W = new javax.swing.JButton();
        jButton_S = new javax.swing.JButton();
        jButton_X = new javax.swing.JButton();
        jButton_T = new javax.swing.JButton();
        jButton_Y = new javax.swing.JButton();
        jButton_StartGame = new javax.swing.JButton();
        RightPanel = new javax.swing.JPanel();
        hangmanGraphic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HANGMAN");
        setBackground(new java.awt.Color(255, 255, 255));

        basePanel.setBackground(new java.awt.Color(255, 255, 255));

        leftPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTextField_HangManWord.setEditable(false);
        jTextField_HangManWord.setBackground(new java.awt.Color(0, 0, 0));
        jTextField_HangManWord.setFont(new java.awt.Font("Arial", 0, 28)); // NOI18N
        jTextField_HangManWord.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_HangManWord.setText("AHORCADO");
        jTextField_HangManWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HangManWordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField_HangManWord)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTextField_HangManWord, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        Keyboard_Panel.setBackground(new java.awt.Color(255, 255, 255));
        Keyboard_Panel.setLayout(new java.awt.GridLayout(6, 0, -1, -1));

        jButton_A.setText("A");
        jButton_A.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_A);

        jButton_B.setText("B");
        jButton_B.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_B);

        jButton_C.setText("C");
        jButton_C.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_C);

        jButton_D.setText("D");
        jButton_D.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_D);

        jButton_E.setText("E");
        jButton_E.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_E);

        jButtonF.setText("F");
        jButtonF.setPreferredSize(new java.awt.Dimension(85, 57));
        jButtonF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButtonF);

        jButton_G.setText("G");
        jButton_G.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_G);

        jButton_H.setText("H");
        jButton_H.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_H);

        jButton_I.setText("I");
        jButton_I.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_I.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_IActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_I);

        jButton_J.setText("J");
        jButton_J.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_J.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_JActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_J);

        jButton_K.setText("K");
        jButton_K.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_KActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_K);

        jButton_L.setText("L");
        jButton_L.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_L);

        jButtonM.setText("M");
        jButtonM.setPreferredSize(new java.awt.Dimension(85, 57));
        jButtonM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButtonM);

        jButton_N.setText("N");
        jButton_N.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_N);

        jButton_Ñ.setText("Ñ");
        jButton_Ñ.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_Ñ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ÑActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_Ñ);

        jButton_O.setText("O");
        jButton_O.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_O.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_O);

        jButton_P.setText("P");
        jButton_P.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_P);

        jButton_Z.setText("Z");
        jButton_Z.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_Z.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ZActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_Z);

        jButton_U.setText("U");
        jButton_U.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_U.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_U);

        jButton_V.setText("V");
        jButton_V.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_V.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_V);

        jButton_Q.setText("Q");
        jButton_Q.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_Q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_QActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_Q);

        jButton_R.setText("R");
        jButton_R.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_R.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_R);

        jButton_W.setText("W");
        jButton_W.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_W.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_WActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_W);

        jButton_S.setText("S");
        jButton_S.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_S);

        jButton_X.setText("X");
        jButton_X.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_X.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_X);

        jButton_T.setText("T");
        jButton_T.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_T.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_T);

        jButton_Y.setText("Y");
        jButton_Y.setPreferredSize(new java.awt.Dimension(85, 57));
        jButton_Y.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_YActionPerformed(evt);
            }
        });
        Keyboard_Panel.add(jButton_Y);

        jButton_StartGame.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton_StartGame.setText("Iniciar");
        jButton_StartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_StartGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Keyboard_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(leftPanelLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jButton_StartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(289, Short.MAX_VALUE)))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Keyboard_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(leftPanelLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jButton_StartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(496, Short.MAX_VALUE)))
        );

        Keyboard_Panel.getAccessibleContext().setAccessibleName("Letras");

        RightPanel.setBackground(new java.awt.Color(255, 255, 255));
        RightPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        hangmanGraphic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/Images/hangman_6Lives.png"))); // NOI18N

        javax.swing.GroupLayout RightPanelLayout = new javax.swing.GroupLayout(RightPanel);
        RightPanel.setLayout(RightPanelLayout);
        RightPanelLayout.setHorizontalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hangmanGraphic, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
        );
        RightPanelLayout.setVerticalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hangmanGraphic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout basePanelLayout = new javax.swing.GroupLayout(basePanel);
        basePanel.setLayout(basePanelLayout);
        basePanelLayout.setHorizontalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        basePanelLayout.setVerticalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(basePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(basePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_HangManWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HangManWordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HangManWordActionPerformed

   
    //Keyboard button 'E'
    private void jButton_EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EActionPerformed
        controller.tryWith('e');
        updateView();
        jButton_E.setEnabled(false);
    }//GEN-LAST:event_jButton_EActionPerformed

     // <editor-fold defaultstate="collapsed" desc=" THE REST OF THE KEYBOARD BUTTONS">
    private void jButton_JActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_JActionPerformed
        controller.tryWith('j');

        updateView();

        jButton_J.setEnabled(false);
    }//GEN-LAST:event_jButton_JActionPerformed

    private void jButton_NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NActionPerformed
        controller.tryWith('n');

        updateView();

        jButton_N.setEnabled(false);
    }//GEN-LAST:event_jButton_NActionPerformed

    private void jButton_PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PActionPerformed
        controller.tryWith('p');

        updateView();

        jButton_P.setEnabled(false);
    }//GEN-LAST:event_jButton_PActionPerformed

    private void jButton_XActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XActionPerformed
        controller.tryWith('x');

        updateView();

        jButton_X.setEnabled(false);
    }//GEN-LAST:event_jButton_XActionPerformed

    private void jButton_UActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UActionPerformed
        controller.tryWith('u');

        updateView();

        jButton_U.setEnabled(false);
    }//GEN-LAST:event_jButton_UActionPerformed

    private void jButton_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AActionPerformed

        controller.tryWith('a');

        updateView();

        jButton_A.setEnabled(false);
    }//GEN-LAST:event_jButton_AActionPerformed

    private void jButton_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BActionPerformed
        controller.tryWith('b');

        updateView();

        jButton_B.setEnabled(false);
    }//GEN-LAST:event_jButton_BActionPerformed

    private void jButton_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CActionPerformed
        controller.tryWith('c');

        updateView();

        jButton_C.setEnabled(false);
    }//GEN-LAST:event_jButton_CActionPerformed

    private void jButton_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DActionPerformed
        controller.tryWith('d');

        updateView();

        jButton_D.setEnabled(false);
    }//GEN-LAST:event_jButton_DActionPerformed

    private void jButtonFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFActionPerformed
        controller.tryWith('f');

        updateView();

        jButtonF.setEnabled(false);
    }//GEN-LAST:event_jButtonFActionPerformed

    private void jButton_GActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GActionPerformed
        controller.tryWith('g');

        updateView();

        jButton_G.setEnabled(false);
    }//GEN-LAST:event_jButton_GActionPerformed

    private void jButton_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HActionPerformed
        controller.tryWith('h');

        updateView();

        jButton_H.setEnabled(false);
    }//GEN-LAST:event_jButton_HActionPerformed

    private void jButton_IActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_IActionPerformed
        controller.tryWith('i');

        updateView();

        jButton_I.setEnabled(false);
    }//GEN-LAST:event_jButton_IActionPerformed

    private void jButton_KActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_KActionPerformed
        controller.tryWith('k');

        updateView();

        jButton_K.setEnabled(false);
    }//GEN-LAST:event_jButton_KActionPerformed

    private void jButton_LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LActionPerformed
        controller.tryWith('l');

        updateView();

        jButton_L.setEnabled(false);
    }//GEN-LAST:event_jButton_LActionPerformed

    private void jButtonMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMActionPerformed
        controller.tryWith('m');

        updateView();

        jButtonM.setEnabled(false);
    }//GEN-LAST:event_jButtonMActionPerformed

    private void jButton_OActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OActionPerformed
        controller.tryWith('o');

        updateView();

        jButton_O.setEnabled(false);
    }//GEN-LAST:event_jButton_OActionPerformed

    private void jButton_QActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_QActionPerformed
        controller.tryWith('q');

        updateView();

        jButton_Q.setEnabled(false);
    }//GEN-LAST:event_jButton_QActionPerformed

    private void jButton_RActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RActionPerformed
        controller.tryWith('r');

        updateView();

        jButton_R.setEnabled(false);
    }//GEN-LAST:event_jButton_RActionPerformed

    private void jButton_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SActionPerformed
        controller.tryWith('s');

        updateView();

        jButton_S.setEnabled(false);
    }//GEN-LAST:event_jButton_SActionPerformed

    private void jButton_TActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TActionPerformed
        controller.tryWith('t');

        updateView();

        jButton_T.setEnabled(false);
    }//GEN-LAST:event_jButton_TActionPerformed

    private void jButton_VActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_VActionPerformed
        controller.tryWith('v');

        updateView();

        jButton_V.setEnabled(false);
    }//GEN-LAST:event_jButton_VActionPerformed

    private void jButton_WActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_WActionPerformed
        controller.tryWith('w');

        updateView();

        jButton_W.setEnabled(false);
    }//GEN-LAST:event_jButton_WActionPerformed

    private void jButton_YActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_YActionPerformed
        controller.tryWith('y');

        updateView();

        jButton_Y.setEnabled(false);
    }//GEN-LAST:event_jButton_YActionPerformed

    private void jButton_ZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ZActionPerformed
        controller.tryWith('z');

        updateView();

        jButton_Z.setEnabled(false);
    }//GEN-LAST:event_jButton_ZActionPerformed
    // </editor-fold>
    
    
    private void jButton_ÑActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ÑActionPerformed
        controller.tryWith('ñ');
        updateView();
        jButton_Ñ.setEnabled(false);
    }//GEN-LAST:event_jButton_ÑActionPerformed

    private void jButton_StartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_StartGameActionPerformed
        jButton_StartGame.setText("Reiniciar");
        controller.reset();
        activateAllButtons();
        updateGraphics();
        updateHangmanWord();
    }//GEN-LAST:event_jButton_StartGameActionPerformed

    private void updateView() {
        updateHangmanWord();
        updateGraphics();
        
        if (model.isTheWholeWordGuessed() == true) {
            model.sendToNext(new PacketMessage("Gano: " + nick));
            handleWin();
        }
    }
    
    private void updateGraphics(){      
        hangmanGraphic.setIcon(hangingMan.updateHangmanGraphic());
    }
    
    private void handleWin(){
        int x = JOptionPane.showConfirmDialog(this, "You Won! Accept your price?", "Wow, such smart",  0);
        deActivateAllButtons();
    }
    
    
    
    private void updateHangmanWord(){
        jTextField_HangManWord.setText(model.getHangmanWord());
    }
    
    
    private void activateAllButtons(){
        jButton_A.setEnabled(true);jButton_B.setEnabled(true);jButton_C.setEnabled(true);jButton_D.setEnabled(true);
        jButton_E.setEnabled(true);jButtonF.setEnabled(true);jButton_G.setEnabled(true);jButton_H.setEnabled(true);
        jButton_I.setEnabled(true);jButton_J.setEnabled(true);jButton_K.setEnabled(true);jButton_L.setEnabled(true);
        jButtonM.setEnabled(true);jButton_N.setEnabled(true);jButton_Ñ.setEnabled(true);jButton_O.setEnabled(true);jButton_P.setEnabled(true);
        jButton_Q.setEnabled(true);jButton_R.setEnabled(true);jButton_S.setEnabled(true);jButton_T.setEnabled(true);
        jButton_U.setEnabled(true);jButton_V.setEnabled(true);jButton_W.setEnabled(true);jButton_X.setEnabled(true);
        jButton_Y.setEnabled(true);jButton_Z.setEnabled(true);
    }
    
    private void deActivateAllButtons(){
        jButton_A.setEnabled(false);jButton_B.setEnabled(false);jButton_C.setEnabled(false);jButton_D.setEnabled(false);
        jButton_E.setEnabled(false);jButtonF.setEnabled(false);jButton_G.setEnabled(false);jButton_H.setEnabled(false);
        jButton_I.setEnabled(false);jButton_J.setEnabled(false);jButton_K.setEnabled(false);jButton_L.setEnabled(false);
        jButtonM.setEnabled(false);jButton_N.setEnabled(false);jButton_Ñ.setEnabled(false);jButton_O.setEnabled(false);jButton_P.setEnabled(false);;
        jButton_Q.setEnabled(false);jButton_R.setEnabled(false);jButton_S.setEnabled(false);jButton_T.setEnabled(false);
        jButton_U.setEnabled(false);jButton_V.setEnabled(false);jButton_W.setEnabled(false);jButton_X.setEnabled(false);
        jButton_Y.setEnabled(false);jButton_Z.setEnabled(false);
    }

   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Keyboard_Panel;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JPanel basePanel;
    private javax.swing.JLabel hangmanGraphic;
    private javax.swing.JButton jButtonF;
    private javax.swing.JButton jButtonM;
    private javax.swing.JButton jButton_A;
    private javax.swing.JButton jButton_B;
    private javax.swing.JButton jButton_C;
    private javax.swing.JButton jButton_D;
    private javax.swing.JButton jButton_E;
    private javax.swing.JButton jButton_G;
    private javax.swing.JButton jButton_H;
    private javax.swing.JButton jButton_I;
    private javax.swing.JButton jButton_J;
    private javax.swing.JButton jButton_K;
    private javax.swing.JButton jButton_L;
    private javax.swing.JButton jButton_N;
    private javax.swing.JButton jButton_O;
    private javax.swing.JButton jButton_P;
    private javax.swing.JButton jButton_Q;
    private javax.swing.JButton jButton_R;
    private javax.swing.JButton jButton_S;
    private javax.swing.JButton jButton_StartGame;
    private javax.swing.JButton jButton_T;
    private javax.swing.JButton jButton_U;
    private javax.swing.JButton jButton_V;
    private javax.swing.JButton jButton_W;
    private javax.swing.JButton jButton_X;
    private javax.swing.JButton jButton_Y;
    private javax.swing.JButton jButton_Z;
    private javax.swing.JButton jButton_Ñ;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField_HangManWord;
    private javax.swing.JPanel leftPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        
        if(arg instanceof PacketUserMove){
            PacketUserMove pum = (PacketUserMove) arg;
            if(!pum.getUser().equalsIgnoreCase(nick)){
                System.out.println("Movimiento: " + pum.getC());
                controller.tryMove(pum.getC());
                controller.sendToNext(pum);
            } else {
                System.out.println("Soy yo: " + pum.getC());
            }
        }
        
        if(arg instanceof PacketGameStart){
            PacketGameStart pgs = (PacketGameStart) arg;
            if(pgs.isStart()){
                activateAllButtons();
                updateGraphics();
                updateHangmanWord();
            }
            controller.sendToNext(pgs);
        }
    }
}
