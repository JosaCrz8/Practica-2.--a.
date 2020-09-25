package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * @author Aureliano Josafat
 *Cuadricula. Pantalla completa, cada cuadro deberá medir 30 unidades por lado, como se
muestra en el ejemplo. Deberá realizar la cuadricula UTILIZANDO SOLAMENTE PUNTOS, NO
LINEAS, NO POLIGONOS, NO FIGURAS. El color de fondo y color de los puntos es libre. 
 * 
 */
public class Practica2 extends JFrame{
    static GL gl;
    static GLU glu;
    
    public Practica2 (){
        setTitle("USO SOLO DE PUNTOS ");
        setSize(1600, 900);
        //Instanciamos la clase Graphic
        GraphicListener listener = new GraphicListener();
        //Creamos el canvas
        GLCanvas canvas = new GLCanvas(new GLCapabilities());
        canvas.addGLEventListener(listener);
        getContentPane().add(canvas);
    } 
    
    public static void main (String args[]){
        Practica2 frame = new Practica2();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
     public class GraphicListener implements GLEventListener{

        public void display(GLAutoDrawable arg0) {
           gl.glClear(GL.GL_COLOR_BUFFER_BIT);
          gl.glColor3f(0,1,1);//funcion para los colores del punto
          gl.glPointSize(30);//el tamaño de los puntos
         
        
         gl.glBegin(GL.GL_POINTS);//la funcion para utilizar los puntos
        //Indicamos que vamos a iniciar a crear los puntos con ciclos uno para la coordenada X y Y.
          for (  double i= -0.9;  i< 1 ; i+=0.05){//indicamos las posiciones de los puntos para x=i
              
                for (double j= -0.81;  j< 0.9; j=j+0.08) {//indicamos las posiciones de los puntos para y=j
                    //indica la posicion
                     gl.glVertex2d(i,j);
                                   
                }
                     
          }            
                          
            //Se acaba el dibujado de puntos
           gl.glEnd();

           gl.glFlush();
           
           
        }

        

        public void init(GLAutoDrawable arg0) {
            glu = new GLU();
            gl = arg0.getGL();
            gl.glClearColor(0, 0, 0, 0);
           
        }

        public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

        }

        public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {

        }

    }
}
