import java.awt.*;
public class OvalsDrawing extends Frame
{
  public OvalsDrawing()
  {
    setTitle("Ovals Drawing");
    setSize(450, 200);
    setVisible(true);    
  }
  public void paint(Graphics g)
  {
    g.drawOval(50, 80, 150, 100);
    g.fillOval(230, 80, 150, 100);
  }
  public static void main(String args[])
  {
    new OvalsDrawing();
  }
}