import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Chat extends JFrame
implements ActionListener {
	// Components of the Form
    private JFrame frame;
	private Container container;

    private JLabel t_ola;
    private JLabel t_nome;

    private JLabel t_server;
    private JLabel t_adrres;
	private JLabel t_port;
	private JTextField n_adrres;
	private JTextField n_port;
    private JPanel bg_top;

    private JTextArea chat;
    private JScrollPane scroll;
    private JTextField mensage;
	private JButton m_envBt;

    private String digitado;
    private boolean jaEnviou = false;

    public String nome_user;
    public String adr_server;
    public int port_server;
    public boolean admin;
	// constructor, to initialize the components
	// with default values.
	public Chat(String nome_us, String server, Boolean adm_server, int porta_sv)
	{
        nome_user = nome_us;
        adr_server = server;
        port_server = porta_sv;
        admin = adm_server;

        frame = new JFrame();
        container = frame.getContentPane();

		setTitle("Chat");
		setBounds(300, 90, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		container = getContentPane();
		container.setLayout(null);
        container.setBackground(Color.decode("#DACCDD"));

        //Painel Lateral
        t_ola = new JLabel("Oi,"); 
        t_nome = new JLabel(nome_user + "!");

        t_ola.setFont(new Font("Arial", Font.BOLD, 32));
        t_ola.setSize(165, 40);
        t_ola.setForeground(Color.WHITE);
        t_ola.setLocation(90, 15);
        container.add(t_ola);
       
        t_nome.setFont(new Font("Arial", Font.BOLD, 42));
        t_nome.setForeground(Color.WHITE);
        t_nome.setSize(250, 50);
        t_nome.setLocation(90, 50);
        container.add(t_nome);
        
        //Painel Topo
        t_server = new JLabel("   Servidor"); 

        t_adrres = new JLabel("  Address: ");
        n_adrres = new JTextField(adr_server);
        
        t_port = new JLabel("  Port:"); 
        n_port = new JTextField(String.valueOf(port_server));

        t_server.setFont(new Font("Arial", Font.BOLD, 17));
		t_server.setSize(405, 35);
		t_server.setLocation(360, 15);
        t_server.setOpaque(true);
        t_server.setBackground(Color.WHITE);
        t_server.setForeground(Color.decode("#9882CD"));
		container.add(t_server);

        t_adrres.setFont(new Font("Arial", Font.BOLD, 16));
		t_adrres.setSize(90, 30);
		t_adrres.setLocation(360, 55);
        t_adrres.setForeground(Color.WHITE);
        t_adrres.setOpaque(true);
        t_adrres.setBackground(Color.decode("#CBBFE8"));
		container.add(t_adrres);
     
		n_adrres.setFont(new Font("Arial", Font.BOLD, 15));
		n_adrres.setSize(120, 20);
		n_adrres.setLocation(455, 58);
        n_adrres.setBorder(null);
        n_adrres.setForeground(Color.WHITE);
        n_adrres.setBackground(Color.decode("#9882CD"));
        n_adrres.setEditable(false);
		container.add(n_adrres);
       
        t_port.setFont(new Font("Arial", Font.BOLD, 16));
		t_port.setSize(60, 30);
		t_port.setLocation(600, 55);
        t_port.setForeground(Color.WHITE);
        t_port.setOpaque(true);
        t_port.setBackground(Color.decode("#CBBFE8"));
		container.add(t_port);

		n_port.setFont(new Font("Arial", Font.BOLD, 15));
		n_port.setSize(120, 20);
		n_port.setLocation(665, 60);
        n_port.setBorder(null);
        n_port.setForeground(Color.WHITE);
        n_port.setBackground(Color.decode("#9882CD"));
        n_port.setEditable(false);
		container.add(n_port);
        
        bg_top = new JPanel();
		bg_top.setSize(900, 110);
        bg_top.setBackground(Color.decode("#9882CD"));
		bg_top.setLocation(0, 0);
		container.add(bg_top);

        //Painel main
        mensage = new JTextField();
        m_envBt = new JButton("ENVIAR");

        chat = new JTextArea();
        

		mensage.setFont(new Font("Arial", Font.PLAIN, 13));
		mensage.setSize(620, 45);
		mensage.setLocation(40, 490);
        mensage.setForeground(Color.DARK_GRAY);
        mensage.setBackground(Color.WHITE);
		container.add(mensage);
     
		m_envBt.setFont(new Font("Arial", Font.BOLD, 15));
		m_envBt.setSize(200, 45);
		m_envBt.setLocation(650, 490);
        m_envBt.setForeground(Color.WHITE);
        m_envBt.setBackground(Color.decode("#9882CD"));
		m_envBt.addActionListener(this);
		container.add(m_envBt);
 
		chat.setFont(new Font("Arial", Font.PLAIN, 13));
		chat.setSize(810, 350);
		chat.setLocation(40, 125);
        chat.setBorder(null);
        chat.setForeground(Color.DARK_GRAY);
        chat.setBackground(Color.WHITE);
        chat.setEditable(false);
        
        scroll = new JScrollPane(chat);
        
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        scroll.setBounds(40, 125, 810, 350);


        container.add(scroll);

        if(admin == true){
            mensage.setVisible(false);
            mensage.setEditable(false);
            m_envBt.setText("Fechar Servidor");
            m_envBt.setBackground(Color.decode("#FF7878"));
		    m_envBt.addActionListener(this);
        }

		setVisible(true);

	}
	// method actionPerformed()
	// to get the action performed
	// by the user and act accordingly
	public void actionPerformed(ActionEvent e)
	{

        if(admin == false){
            if (e.getSource() == m_envBt) {
                this.digitado = mensage.getText();
                this.mensage.setText("");
                this.jaEnviou = false;
            }
        }   else{
            if (e.getSource() == m_envBt) {
                //enviar mensagem ao servidor
            }
        }

    }

    public void setMessage(String msg){

        this.chat.append(msg+"\n");

    }

    public String getDigitado(){

        this.jaEnviou = true;
        return this.digitado;

    }

    public boolean foiEnviado(){

        return this.jaEnviou;

    }

}
