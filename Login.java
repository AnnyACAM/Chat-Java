//Fonte Princportal: https://www.geeksforgeeks.org/java-swing-simple-user-registration-form/?ref=rp
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.*;


public class Login extends JFrame
implements ActionListener {
	// Componentes do Login
    private JFrame frame;
	private Container container;
	private JLabel loginText;
    private JLabel t_port;
    private JLabel t_nome;
    private JLabel t_serve;
    private JLabel t_senha;
    private JLabel t_adm;
    private JLabel text1;
    private JLabel text2;
	private JTextField nome;
    private JTextField port;
	private JTextField serve;
    private JPasswordField senha;
	private JButton admBt;
	private JButton envBt;
    private JButton userBt;
	private JPanel bg_text;
    //private Chat chat;

    public static String u_nome;
    public static String server;
    public static String s_adm;
    public static int porta;
    public static String fezLogin;
    public static boolean admin;

	public Login()
	{
        frame = new JFrame();
        container = frame.getContentPane();

		setTitle("Registration Form");
		setBounds(300, 90, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		container = getContentPane();
		container.setLayout(null);
        container.setBackground(Color.WHITE);

        //Campo de entrada e legenda NOME
            t_nome = new JLabel("Nome:");     
            nome = new JTextField();               
            //Personalizações Nome
            style_label(t_nome,15);
            t_nome.setLocation(41, 145);
            container.add(t_nome);

            style_input(nome);
            nome.setSize(365, 48);  
            nome.setLocation(41, 170);
            container.add(nome);  
                        

        //Campo de entrada e legenda SERVIDOR
            t_serve = new JLabel("Servidor:");       
            serve = new JTextField();      
            //Personalizações Endereço Servidor
            style_label(t_serve,15);
            t_serve.setLocation(41, 240);
            container.add(t_serve);

            style_input(serve);
            serve.setSize(365, 48);  
            serve.setLocation(41, 265);
            container.add(serve);      


        //Campo de entrada e legenda PORTA
            t_port = new JLabel("Porta:");      
            port = new JTextField();                
            //Personalizações Porta do servidor
            style_label(t_port,15);
            t_port.setLocation(41, 320);
            container.add(t_port);

            style_input(port);
            port.setSize(175, 28);
            port.setLocation(95, 320);
            container.add(port);


        //Botão de IDENTIFICAÇÃO ADM para logar e legenda
            t_adm = new JLabel("Logar como ADM Servidor");    
            admBt = new JButton();                                 
            //Personalizações botão identificação adm         
            style_label(t_adm, 12);
            t_adm.setLocation(152, 455);
            container.add(t_adm);

            admBt.setSize(10, 10);
            admBt.setBackground(Color.GRAY);
            admBt.setLocation(132, 461);
            admBt.addActionListener(this);
            container.add(admBt);  

            userBt = new JButton();   
            userBt.setSize(10, 10);
            userBt.setBackground(Color.GRAY);
            userBt.setLocation(132, 461);
            userBt.setVisible(false);
            userBt.addActionListener(this);
            container.add(userBt);  

            
        //Campo de entrada e legenda SENHA ADM    
            t_senha = new JLabel("Senha ADM:");     
            senha = new JPasswordField();             
            //Personalizações senha adm   
            style_label(t_senha, 15);
            t_senha.setLocation(41, 145);
            t_senha.setVisible(false);
            container.add(t_senha);

            senha.setFont(new Font("Arial", Font.PLAIN, 13));
            senha.setSize(365, 48);  
            senha.setLocation(41, 170);
            senha.setBorder(null);
            senha.setBackground(Color.decode("#E3DCF1"));
            senha.setVisible(false);
            container.add(senha);
            
        //Botão para ENVIO do formulário
            envBt = new JButton("ENVIAR");
            //Personalizações botão de envio
            envBt.setFont(new Font("Arial", Font.BOLD, 15));
            envBt.setSize(190, 45);
            envBt.setLocation(119, 410);
            envBt.setForeground(Color.WHITE);
            envBt.setBackground(Color.decode("#9882CD"));
            envBt.addActionListener(this);
            container.add(envBt);

        //Textos
            textos_in();

		setVisible(true);

        boolean repete = true;

        while (repete == true){

            
            System.out.println("");

            if(fezLogin == "ENVIAR"){
                
                this.dispose();
                repete = false;
                
            }

            System.out.println("");

        }

	}

    public void Version(JLabel legendas, JTextField input, boolean estado) {
        legendas.setVisible(estado);
        input.setVisible(estado);
        input.setEditable(estado);
    }
    
    //obtém a ação executada pelo usuário e age de acordo
	public void actionPerformed(ActionEvent acao)
	{
        if (acao.getSource() == admBt) { 
            senha.setVisible(true);
            t_senha.setVisible(true);
            t_adm.setText("Logar como usuario");
            Version(t_nome, nome, false);
            Version(t_port, port, false);
            t_serve.setText("Porta do Servidor:");
            text2.setText("ADMIN: Insira seus dados e crie um servidor");
            admBt.setVisible(false);
            userBt.setVisible(true);
        }

        if (acao.getSource() == userBt) { 
            senha.setVisible(false);
            t_senha.setVisible(false);
            t_adm.setText("Logar como ADM Servidor");
            Version(t_nome, nome, true);
            Version(t_port, port, true);
            t_port.setText("Porta");
            t_serve.setText("Servidor:");
            text2.setText("Insira seus dados e entre em um bate-papo");
            admBt.setVisible(true);
            userBt.setVisible(false);
        }

            if (acao.getSource() == envBt) {
                if(senha.getPassword().length >= 1){
                    s_adm = new String(senha.getPassword());
        
                t_port.setVisible(true);
                if(s_adm.equals("adm")){
                    admin = true;
                }else{
                    t_port.setText("Senha Incorreta!");
                    serve.setText("");
                    senha.setText("");
                }    
            }

            if(admin == false){
            //pega do campo texto e transfere para uma variável
            u_nome = nome.getText();
            server = serve.getText();
            porta = Integer.parseInt(port.getText());
            fezLogin = envBt.getText();
            
            }else{
                u_nome = "Administrador";
                porta = Integer.parseInt(serve.getText());
                fezLogin = envBt.getText();
                try {
                    server = InetAddress.getLocalHost().getHostAddress(); 
                    } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                
            }   
            
            nome.setText("");
            serve.setText("");
            port.setText("");
            senha.setText("");         
        }
    }

    public void style_label(JLabel legenda, int size){
        legenda.setFont(new Font("Arial", Font.PLAIN, size));     //Fonte
        legenda.setForeground(Color.GRAY);                             //Cor Fonte
        legenda.setSize(180, 24);                         //Tamanho
    }

    public void style_input(JTextField campoT){
        campoT.setFont(new Font("Arial", Font.PLAIN, 13));  //Fonte
        campoT.setBorder(null);                                //Borda
        campoT.setForeground(Color.DARK_GRAY);                        //Cor Fonte
        campoT.setBackground(Color.LIGHT_GRAY);                       //Cor de Fundo
    }

    public void textos_in(){
       //Personalizações Textos 
        loginText = new JLabel("Sign In");
        loginText.setFont(new Font("Arial", Font.BOLD, 30));
        loginText.setSize(300, 33);
        loginText.setLocation(41, 80);
        container.add(loginText);

        text1 = new JLabel("Bem-Vinda(o)!");
        text1.setFont(new Font("Arial", Font.BOLD, 40));
        text1.setForeground(Color.WHITE);
        text1.setSize(340, 87);
        text1.setLocation(530, 215);
        container.add(text1);
        
        text2 = new JLabel("Insira seus dados e entre em um bate-papo");
        text2.setFont(new Font("Arial", Font.PLAIN, 17));
        text2.setForeground(Color.WHITE);
        text2.setSize(390, 80);
        text2.setLocation(505, 260);
        container.add(text2);

        //background Painel Direito
        bg_text = new JPanel();
        bg_text.setSize(450, 600);
        bg_text.setBackground(Color.decode("#9882CD"));
        bg_text.setLocation(450, 0);
        container.add(bg_text);
    }

    public boolean getAdmin(){

        return this.admin;

    }

    public int getPorta(){

        return this.porta;

    }

    public String getNome(){

        return this.u_nome;

    }

    public String getIP(){

        return this.server;

    }

    /*
    public void setMessage(String msg){

        this.chat.setMessage(msg);

    }
    */
}
