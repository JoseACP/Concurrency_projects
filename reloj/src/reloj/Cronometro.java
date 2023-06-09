
package reloj;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
 
public class Cronometro extends JFrame implements Runnable, ActionListener 
{ 
    public Cronometro()
    {
        setTitle("Cronometro");
        setSize( 300, 200 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLayout( new BorderLayout() );
        tiempo = new JLabel( "00:00:000" );
        tiempo.setFont( new Font( Font.SERIF, Font.BOLD, 50 ) );
        tiempo.setHorizontalAlignment( JLabel.CENTER );
        tiempo.setForeground( Color.BLUE );
        tiempo.setBackground( Color.WHITE );
        tiempo.setOpaque( true );
 
        add( tiempo, BorderLayout.CENTER );
 
        //Boton start
        JButton btn = new JButton( "start" );
        btn.addActionListener( this );
        add( btn, BorderLayout.NORTH );
 
        //Boton restart inicia nuevamente desde 0
        JButton btnP = new JButton( "Restart" );
        btnP.addActionListener( this );
        add( btnP, BorderLayout.SOUTH );
         
        this.setLocationRelativeTo( null );
        setVisible( true );
    }
  
    public void run(){
        Integer hora = 0, minutos = 0 , segundos = 0, milesimas = 0;
        String  hor = "", min="", seg="", mil="";
        try
        {
    
            while( cronometroActivo )
            {
                Thread.sleep( 4 );

                milesimas += 4;
                 

                if( milesimas == 1000 )
                {
                    milesimas = 0;
                    segundos += 1;

                    if( segundos == 60 )
                    {
                        segundos = 0;
                        minutos++;
                        
                        if ( minutos == 60){
                            
                            minutos = 0;
                            hora++;
                        }
                    }
                }
 
                
                
                if( hora < 10 ) hor = "0" + hora;
                else hor = hora.toString();
                if( minutos < 10 ) min = "0" + minutos;
                else seg = minutos.toString();
                
                if( minutos < 10 ) min = "0" + minutos;
                else min = minutos.toString();
                if( segundos < 10 ) seg = "0" + segundos;
                else seg = segundos.toString();
                 
                if( milesimas < 10 ) mil = "00" + milesimas;
                else if( milesimas < 100 ) mil = "0" + milesimas;
                else mil = milesimas.toString();

                tiempo.setText( hor + ":" + min + ":" + seg + ":" + mil );                
            }
        }catch(Exception e){}
        
        tiempo.setText( "00:00:000" );
    }
  
   
    public void actionPerformed( ActionEvent evt ) {
        Object o = evt.getSource();
        if( o instanceof JButton )
        {
            JButton btn = (JButton)o;
            if( btn.getText().equals("start") ) startCronometro();
            if( btn.getText().equals("Restart") ) pararCronometro();
        }
    }

    public void startCronometro() {
        cronometroActivo = true;
        hilo = new Thread( this );
        hilo.start();
    }
  
   
    public void pararCronometro(){
        cronometroActivo = false;
    }
  
    public static void main(String[] args) {
      
        new Cronometro();
    }
  
    JLabel tiempo;
    Thread hilo;
    boolean cronometroActivo;
}