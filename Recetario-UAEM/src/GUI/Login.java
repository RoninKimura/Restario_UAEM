package GUI;
import javax.swing. *;
import java.awt.*;


/**
 *
 * @author Angel Eliud Martinez Navarrete
 */
public class Login extends JFrame{

    //Declaracion de objetos
    JPanel panel_login;
    JLabel lbl_titulo,lbl_usuario,lbl_contrasenia;
    JTextField txt_usuario;
    JPasswordField psw_contrasenia;
    JButton btn_admin,btn_usuario;
    //Configuracion de la ventana
    public Login(){
        setTitle("RECETARIO");
        setResizable(false);//No permite que se Maximise
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        objetos_login();
        setVisible(true);
    }
    //Creamos los objetos
    public void objetos_login(){
        //Configuracion del Panel 
        panel_login= new JPanel();
        panel_login.setPreferredSize(new Dimension(450,550));
        panel_login.setLayout(null);
        
        //Creacion de las etiquetas
        lbl_titulo=new JLabel("LOGIN");
        lbl_titulo.setBounds(200, 30, 70, 30);
        lbl_usuario= new JLabel("Usuario:");
        lbl_usuario.setBounds(50, 250, 50, 20);
        lbl_contrasenia=new JLabel("Contraseña:");
        lbl_contrasenia.setBounds(50, 315, 80, 20);
        
        txt_usuario=new JTextField();
        txt_usuario.setBounds(50, 275, 350, 30);
        psw_contrasenia=new JPasswordField();
        psw_contrasenia.setBounds(50, 340, 350, 30);
        
        //Creacion de los Botones
        btn_usuario=new JButton("Entrar como Usuario");
        btn_usuario.setBounds(50, 100, 350, 50);
        btn_admin=new JButton("Entrar como Admin");
        btn_admin.setBounds(50, 400, 350, 50);
        
        //Agregamos el Panel al JFrame
        add(panel_login);
        //Agregamos los objetos que tendra el JPane
        panel_login.add(lbl_titulo);
        panel_login.add(lbl_usuario);
        panel_login.add(lbl_contrasenia);
        panel_login.add(txt_usuario);
        panel_login.add(psw_contrasenia);
        panel_login.add(btn_usuario);
        panel_login.add(btn_admin);
        pack();
    }
    
}
