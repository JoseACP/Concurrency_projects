import javax.swing.JFrame;

public class clock implements Runnable{

Thread crono;
javax.swing.JLabel tiempo = new javax.swing.JLabel();

/** Creates new form clock */
public clock() {
JFrame ventana = new JFrame("clock");
ventana.add(tiempo);
ventana.setSize(150,100);
ventana.setVisible(true);

crono = new Thread(this);
crono.start();
}


int minutos=0, segundos=0, horas=0;
public void run()
{ try {
for(;;) {
if(segundos==59) { segundos=0; minutos++; }
if(minutos==59) { minutos=0; horas++; }
segundos++;

tiempo.setText(horas+":"+minutos+":"+segundos);
crono.sleep(1000); }
}
catch (InterruptedException e) { System.out.println(e.getMessage()); }
}

public static void main(String args[])
{
new clock();
}

}