import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Classe_26_MeuJogodaVelha extends JFrame {

    JLabel placar, xis, bola;
    JButton novojogo, zerar, botaoInfo;

    JButton a, b, c, d, e, f, g, h, i;
    JButton[] botoes = new JButton[9];
    JPanel painel;
    boolean [] click = new boolean[9];
    boolean xo = false;
    int ptx = 0;
    int pto = 0;
    Container tela;

    public Classe_26_MeuJogodaVelha() {

        botao();
        setar();
        inserir();
        zerartudo();
        marcar();
        buttoninformacao();
        newgame();

        //SETANDO PROPRIEDADES DA TELA

        this.setVisible(true);
        this.setSize(600, 400);
        this.setTitle("JOGO DA VELHA");
        this.getContentPane().setLayout(null);// LAYOUT NULL
        this.setResizable(false);// NAO E POSSIVEL REDIMENSIONAR A TELA
        this.setLocationRelativeTo(null); // CRIA A TELA NO CENTRO DO MONITOR
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public static void main(String[] args) {

        new Classe_26_MeuJogodaVelha();

    }

    //SETANDO COMPONENTES ===

    public void setar() {

        placar = new JLabel("PLACAR:");

        xis = new JLabel("X= " + ptx);
        bola = new JLabel("O= " + pto);

        novojogo = new JButton("NOVO JOGO");
        zerar = new JButton("ZERAR PLACAR");

        painel = new JPanel();

        a = new JButton();
        b = new JButton();
        c = new JButton();
        d = new JButton();
        e = new JButton();
        f = new JButton();
        g = new JButton();
        h = new JButton();
        i = new JButton();

    }

    //METODO INSERINDO OS ITENS NO CONTAINER ===

    public void inserir() {

        tela = getContentPane();
        setLayout(null);

        placar.setBounds(425, 50, 50, 20);
        tela.add(placar);

        xis.setBounds(425, 75, 50, 20);
        tela.add(xis);
        bola.setBounds(425, 100, 50, 20);
        tela.add(bola);

        novojogo.setBounds(385, 125, 125, 30);
        tela.add(novojogo);
        zerar.setBounds(385, 175, 125, 30);
        tela.add(zerar);

          tela.add(buttoninformacao());

        // CRIANDO PAINEL COMO GRID LAYOUT 3X3 PARA BOTAR OS BOTOES ===

        botao();

        painel.setLayout(new GridLayout(3, 3));
        painel.setBounds(20, 20, 300, 300);
        painel.setBackground(Color.BLACK);
        painel.add(a);
        painel.add(b);
        painel.add(c);
        painel.add(d);
        painel.add(e);
        painel.add(f);
        painel.add(g);
        painel.add(h);
        painel.add(i);
        tela.add(painel);


    }


    //METODO GERAR AS 9 CASAS ===

    public void botao() {
        for (int i = 0; i == 9; i++) {
            botoes[i] = new JButton();


        }
    }

    // METODO NOVO JOGO ===


    public void newgame() {
        novojogo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent u) {
                a.setText("");
                b.setText("");
                c.setText("");
                d.setText("");
                e.setText("");
                f.setText("");
                g.setText("");
                h.setText("");
                i.setText("");


            }
        });
    }

    //METODO ZERAR O PLACAR ===

    public void zerartudo() {
        zerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xis.setText("X= 0");
                bola.setText("O= 0");
            }
        });
    }

    //METODO X E O ===

    public void marcar() {
        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarx();
                verificatudo(a);
            }
        });
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarx();
                verificatudo(b);
            }
        });
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarx();
                verificatudo(c);
            }
        });

        d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarx();
                verificatudo(d);
            }
        });
        e.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent u) {
                verificarx();
                verificatudo(e);
            }
        });
        f.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarx();
                verificatudo(f);
            }
        });
        g.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarx();
                verificatudo(g);
            }
        });
        h.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent u) {
                verificarx();
                verificatudo(h);
            }
        });

        i.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarx();

                verificatudo(i);


            }
        });
    }

    //METODO QUE VERIFICA SE A CASA JA FOI PREENCHIDA ===

    public void verificatudo(JButton x) {
        if (xo) {
            if (x.getText().isEmpty()) {
                x.setText("O");
                xo = false;
            } else {
                JOptionPane.showMessageDialog(null, "Essa casa ja foi preenchida!");
            }
        } else {
            if (x.getText().isEmpty()) {
                x.setText("X");
                xo = true;
            } else {
                JOptionPane.showMessageDialog(null, "Essa casa ja foi preenchida!");
            }
        }
    }

    //METODO DE VERIFICAR SE ALGUEM GANHOU OU SE DEU VELHA ===

    public void verificarx() {

        if (a.getText().equals("X") && b.getText().equals("X") && c.getText().equals("X")
                || a.getText().equals("X") && d.getText().equals("X") && g.getText().equals("X")
                || a.getText().equals("X") && e.getText().equals("X") && i.getText().equals("X")
                || a.getText().equals("X") && b.getText().equals("X") && c.getText().equals("X")
                || b.getText().equals("X") && e.getText().equals("X") && h.getText().equals("X")
                || c.getText().equals("X") && f.getText().equals("X") && i.getText().equals("X")
                || d.getText().equals("X") && e.getText().equals("X") && f.getText().equals("X")
                || g.getText().equals("X") && h.getText().equals("X") && i.getText().equals("X")
                || g.getText().equals("X") && e.getText().equals("X") && c.getText().equals("X")
                || a.getText().equals("O") && b.getText().equals("O") && c.getText().equals("O")
                || a.getText().equals("O") && d.getText().equals("O") && g.getText().equals("O")
                || a.getText().equals("O") && e.getText().equals("O") && i.getText().equals("O")
                || a.getText().equals("O") && b.getText().equals("O") && c.getText().equals("O")
                || b.getText().equals("O") && e.getText().equals("O") && h.getText().equals("O")
                || c.getText().equals("O") && f.getText().equals("O") && i.getText().equals("O")
                || d.getText().equals("O") && e.getText().equals("O") && f.getText().equals("O")
                || g.getText().equals("O") && h.getText().equals("O") && i.getText().equals("O")
                || g.getText().equals("O") && e.getText().equals("O") && c.getText().equals("O")) {

            if (xo) {

                JOptionPane.showMessageDialog(null, "ACABOU! = X VENCEU");
                ptx++;
                xis.setText("X= " + ptx);

            } else {
                JOptionPane.showMessageDialog(null, "ACABOU! = O VENCEU");
                pto++;
                bola.setText("O= " + pto);
            }

        }

    }
    //CRIACAO BUTTON DE INFORMACAO ===

    private JButton buttoninformacao() {
        if (botaoInfo == null) {
            ImageIcon icone = new ImageIcon(getClass().getResource("/dados1/Informacao.png"));
            botaoInfo = new JButton(icone);
            botaoInfo.setBounds(new Rectangle(550, 5, 40, 40));
            botaoInfo.setToolTipText("Informa��es"); //MENSAGEM AO PASSAR O MOUSE
            botaoInfo.setContentAreaFilled(false); // TIRA O FUNDO DO BOTAO
            botaoInfo.setBorderPainted(false);  // TIRA A BORDA DO BOTAO
            botaoInfo.setFocusable(false);  // TIRA O FOCUS DO BOTAO
            botaoInfo.setCursor(new Cursor(Cursor.HAND_CURSOR)); //O CURSOR VIRA UMA MAO

            //ACAO BOTAO INFO ===

            botaoInfo.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {

                    // BOTANDO IMAGEM DENTRO DA CAIXA DE AVISO/JOPTIONPANE ===
                    Icon duke = new ImageIcon(getClass().getResource("/dados1/Duke.png"));
                    //MENSAGEM AO CLICAR NO BOTAO INFO ===
                    JOptionPane.showMessageDialog(null, "Jogo da velha em java.\n"
                                    + "Autor: Leo Trevisol"
                                    + "\nClick no bot�o NOVO JOGO para come�ar.",
                            "Jogo da velha em Java", 0, duke);
                }
            });
        }
        return botaoInfo;
    }
}

