package MVC;

import MVC.Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * @author Fernando Millan
 *
 */
public class View extends javax.swing.JFrame implements Runnable {

    Thread h1;
    public int i = 30;
    public ImageIcon imgs[];
    public JButton btns[];
    public int ran;
    public int err;
    public String res[];
    boolean turnFlag = false;
    public boolean flag ;
    boolean flag2=true;
    public String nxtPlayer;
    public String gameMsg;
    Control con;
    String namePlayer;
    String fallido;
    
    
    
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

  
    public View() throws UnknownHostException {
        
        initComponents();
        boom.setVisible(false);
        con= new Control();
        namePlayer=InetAddress.getLocalHost().getHostName();
        
       
        h1 = new Thread(this);
        imgs = new ImageIcon[6];
        btns = new JButton[27];
      

        //imagenes del joven ahorcado lol
        imgs[0] = new ImageIcon(getClass().getResource("/Ahorcado/im1.jpg"));
        imgs[1] = new ImageIcon(getClass().getResource("/Ahorcado/im2.jpg"));
        imgs[2] = new ImageIcon(getClass().getResource("/Ahorcado/im3.jpg"));
        imgs[3] = new ImageIcon(getClass().getResource("/Ahorcado/im4.jpg"));
        imgs[4] = new ImageIcon(getClass().getResource("/Ahorcado/im5.jpg"));
        imgs[5] = new ImageIcon(getClass().getResource("/Ahorcado/im6.jpg"));

        //botones para las letras
        btns[1] = btnA;
        btns[2] = btnB;
        btns[3] = btnC;
        btns[4] = btnD;
        btns[5] = jButton6;
        btns[6] = jButton7;
        btns[7] = jButton8;
        btns[8] = jButton9;
        btns[9] = jButton10;
        btns[10] = jButton11;
        btns[11] = jButton12;
        btns[12] = jButton13;
        btns[13] = jButton14;
        btns[14] = jButton15;
        btns[15] = jButton16;
        btns[16] = jButton17;
        btns[17] = jButton18;
        btns[18] = jButton19;
        btns[19] = jButton20;
        btns[20] = jButton21;
        btns[21] = jButton22;
        btns[22] = jButton23;
        btns[23] = jButton24;
        btns[24] = jButton25;
        btns[25] = jButton26;
        btns[26] = jButton27;

        //palabras por advinar, para agregar una nueva palabra sera necesario declararla al inicio
    
       

        //se asigna un evento a cada letra para comprobar que exista en la palabra a adivinar
        for (int a = 1; a < 27; a++) {
            btns[a].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {                
                    setI(31);
                    
                    try {
                        checarLetra(e);
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  
                    
        
                }
            });
        }
        
    }
     
    public void run() {
      
        Thread ct = Thread.currentThread();
        
        while (ct == h1 ) {
             i = getI() - 1;
              if(i<=9){
                time.setText("0:0" + i);
            }else{
            time.setText("0:" + i);
            }
                   //marcar mala
              if (i == 0) {
           
              jButton1.setIcon(imgs[++err]);
              if (err != 5){
                        
                  this.nxtPlayer="nxt";
                  JOptionPane.showMessageDialog(this, "Turno de " ); // meter el nick name del siguiente
                    }
                    //SI SE LLEGA A LOS 5 ERRORES ENTONCES SE PIERDE EL JUEGO Y SE MANDA EL MENSAGE DE:
                    if (err == 5) {
                        nxtPlayer="done";
                        JOptionPane.showMessageDialog(this, "Perdieron wey la respuesta es: \n" + con.getWord());
                        jiniciar.setEnabled(true);
                         jLabel2.setVisible(true);
                        time.setVisible(false);
                        boom.setVisible(true);
                        setFlag(false);
                        
                    }
                     setI(31);
            }
             try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
    //funcion para comenzar los parametros del juego o iniciar una nueva partida
    public void iniciar() {
       
        //ERRORES EN 0
        err = 0;
        jButton1.setIcon(imgs[0]);
        jTextPane1.setText("");
        //para activar las letras del tablero
        for (int i = 1; i < 27; i++) {
            btns[i].setEnabled(true);
        }
      
             //para generar una palabra aleatoriamente xD
     //   ran = (int) 0 + (int) (Math.random() * ((con.getWord().length - 1) + 1));
        //SEPARA EL MENSAJE POR PALABRAS
       String pal[] = con.getWord().split(" ");
       
        res = new String[con.getWord().length() + 1];
        int j = 0;
        
        // seran los guiones que van debajo de las letras como una separacion_
        for (String pal1 : pal) {
            for (int i = 0; i < pal1.length(); i++) {
                jTextPane1.setText(jTextPane1.getText() + "_ ");
                res[j++] = "_";
            }
            jTextPane1.setText(jTextPane1.getText() + "\n");
            res[j++] = " ";
       }
        gameMsg=con.getWord();
    }

    //al presionar una letra, esta se buscara si pertenece a la palabra, de lo contrario la marcara como error 
    public void checarLetra(ActionEvent e) throws UnknownHostException {
        
        JButton bt = (JButton) e.getSource();
        
        char c[];
        //busca la letra en la palabra despues de haber sido presionada
        for (int i = 1; i < 27; i++) {
            
            if (bt == btns[i]) {
               
                //la tecla es inicializada
                c = Character.toChars(64 + i);
                
              
                //busca si la letra esta en la frase
                boolean esta = false;
                for (int j = 0; j < con.getWord().length(); j++) {
                    if (c[0] == con.getWord().charAt(j)) {
                        res[j] = c[0] + "";
                        esta = true;
                    }
                }
              
                //SI LA LETRA ESTA EN EL MENSAJE SE MUESTRA EN EL TEXTPANEL
                if (esta) {
                  
                    jTextPane1.setText("");
                    for (String re : res) {
                        if (" ".equals(re)) {
                            jTextPane1.setText(jTextPane1.getText() + "\n");
                        } else {
                            jTextPane1.setText(jTextPane1.getText() + re + " ");
                            System.out.println("respoesta: "+re);//////////////////////////////////////////////
                        }
                        
                    }
                    //hace una comprobacion de las letras restantes y faltantes, en caso de que ya no haya letras sera ganador :D
                    boolean gano = true;
                    for (String re : res) {
                        if (re.equals("_")) {
                            gano = false;
                            break;
                        }else
                              con.setAsiertos(re);
                    }
                    //al ser correcta se muestra un mensaje y se reinicia el juego
                    if (gano) {
                        
                        JOptionPane.showMessageDialog(this, "El Ganador es " +namePlayer); // sacar el nick name del jugador
                         con.setWinner(namePlayer);
                        jiniciar.setEnabled(true);
                        setFlag(false);
                        break;
                    }
                    //SI LA LETRA NO ESTA EN EL MENSAGE, SE INCREMENTA EL ERROR Y SE CAMBIA LA IMAGEN
                } else {
                   
                    jButton1.setIcon(imgs[++err]); 
                    con.setErr(err);
                    if (err != 5){
                         con.setFallido(bt.getText());
                        this.nxtPlayer="nxt";
                        con.setTurn(nxtPlayer);
                         JOptionPane.showMessageDialog(this, "Turno de " ); // meter el nick name del siguiente
                    }
                   
                    //SI SE LLEGA A LOS 5 ERRORES ENTONCES SE PIERDE EL JUEGO Y SE MANDA EL MENSAGE DE:
                    if (err == 5) {
                        this.nxtPlayer="done";
                        JOptionPane.showMessageDialog(this, "Perdieron wey la respuesta es: \n" + con.getWord());
                        jiniciar.setEnabled(true);
                        jLabel2.setVisible(true);
                        time.setVisible(false);
                        boom.setVisible(true);
                        flag=false;
                       
                    
                        break;
                    }
                    
                }
                
                //esta es la linea que desactiva las letras despues de ser usadas :3
                bt.setEnabled(false);
                break;
            }
        }
        gameMsg=con.getWord();
        

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnTest = new javax.swing.JButton();
        boom = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jiniciar = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        time = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnA = new javax.swing.JButton();
        btnB = new javax.swing.JButton();
        btnC = new javax.swing.JButton();
        btnD = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MexicanHangedPerson By Pear Soft&Games");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));
        jPanel1.setForeground(new java.awt.Color(102, 255, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTest.setText("TEST");
        btnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });
        jPanel1.add(btnTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 670, -1, -1));

        boom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tumblr_ltsch6EzUq1qk6usbo1_500.gif"))); // NOI18N
        jPanel1.add(boom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 500, 280));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ahorcado/im1.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 258, 260));

        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jScrollPane1.setViewportView(jTextPane1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 420, 80));

        jiniciar.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jiniciar.setText("Iniciar");
        jiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jiniciarActionPerformed(evt);
            }
        });
        jPanel1.add(jiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 630, 190, -1));

        jButton29.setText("X");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, -1));

        time.setFont(new java.awt.Font("Square721 BT", 0, 48)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setText("00:00");
        jPanel1.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo-de-pantalla-Moment-in-space-CXIII-by-Funerium.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-320, 0, 820, 730));

        btnA.setBackground(new java.awt.Color(255, 255, 255));
        btnA.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        btnA.setText("A");
        jPanel1.add(btnA, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, -1, -1));

        btnB.setBackground(new java.awt.Color(255, 255, 255));
        btnB.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        btnB.setText("B");
        btnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBActionPerformed(evt);
            }
        });
        jPanel1.add(btnB, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, -1, -1));

        btnC.setBackground(new java.awt.Color(255, 255, 255));
        btnC.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        btnC.setText("C");
        jPanel1.add(btnC, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, -1, -1));

        btnD.setBackground(new java.awt.Color(255, 255, 255));
        btnD.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        btnD.setText("D");
        jPanel1.add(btnD, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, -1, -1));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton6.setText("E");
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, -1, -1));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton7.setText("F");
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, -1, -1));

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton8.setText("G");
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 460, -1, -1));

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton9.setText("H");
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, -1, -1));

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton10.setText("I");
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, -1, -1));

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton11.setText("J");
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, -1, -1));

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton12.setText("K");
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 500, -1, -1));

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton13.setText("L");
        jPanel1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 500, -1, -1));

        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton14.setText("M");
        jPanel1.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, -1, -1));

        jButton15.setBackground(new java.awt.Color(255, 255, 255));
        jButton15.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton15.setText("N");
        jPanel1.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, -1, -1));

        jButton16.setBackground(new java.awt.Color(255, 255, 255));
        jButton16.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton16.setText("O");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, -1, -1));

        jButton17.setBackground(new java.awt.Color(255, 255, 255));
        jButton17.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton17.setText("P");
        jPanel1.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, -1, -1));

        jButton18.setBackground(new java.awt.Color(255, 255, 255));
        jButton18.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton18.setText("Q");
        jPanel1.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, -1, -1));

        jButton19.setBackground(new java.awt.Color(255, 255, 255));
        jButton19.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton19.setText("R");
        jPanel1.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, -1, -1));

        jButton20.setBackground(new java.awt.Color(255, 255, 255));
        jButton20.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton20.setText("S");
        jPanel1.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 540, -1, -1));

        jButton21.setBackground(new java.awt.Color(255, 255, 255));
        jButton21.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton21.setText("T");
        jPanel1.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 540, -1, -1));

        jButton22.setBackground(new java.awt.Color(255, 255, 255));
        jButton22.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton22.setText("U");
        jPanel1.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 540, -1, -1));

        jButton23.setBackground(new java.awt.Color(255, 255, 255));
        jButton23.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton23.setText("V");
        jPanel1.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 580, -1, -1));

        jButton24.setBackground(new java.awt.Color(255, 255, 255));
        jButton24.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton24.setText("W");
        jPanel1.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, -1, -1));

        jButton25.setBackground(new java.awt.Color(255, 255, 255));
        jButton25.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton25.setText("X");
        jPanel1.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, -1, -1));

        jButton26.setBackground(new java.awt.Color(255, 255, 255));
        jButton26.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton26.setText("Y");
        jPanel1.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 580, -1, -1));

        jButton27.setBackground(new java.awt.Color(255, 255, 255));
        jButton27.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton27.setText("Z");
        jPanel1.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 580, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo-de-pantalla-Moment-in-space-CXIII-by-Funerium.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-320, 0, 820, 730));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        
    }//GEN-LAST:event_jButton29ActionPerformed

    private void btnBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBActionPerformed

    private void jiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jiniciarActionPerformed
       
       
        time.setText("00:30");
        setFlag(true);
        setI(31);
        run();
        iniciar();
        if (flag2==true) {
        
        h1.start();
        flag2=false;
        }
         con= new Control(true, gameMsg, err, "0");
        
        
        boom.setVisible(false);
         time.setVisible(true);
        jLabel2.setVisible(turnFlag);
        jiniciar.setEnabled(false);
    }//GEN-LAST:event_jiniciarActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void btnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestActionPerformed
        System.out.println(con.toString());
    }//GEN-LAST:event_btnTestActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new View().setVisible(true);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel boom;
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnB;
    private javax.swing.JButton btnC;
    private javax.swing.JButton btnD;
    public javax.swing.JButton btnTest;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton jiniciar;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables


}
