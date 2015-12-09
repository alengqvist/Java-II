import javax.swing.*;
import java.awt.*;

public class PaintApplet extends JApplet {

	private static final long serialVersionUID = 1L;
	private PainterGUIPanel output;

	public void init() {
		output = new PainterGUIPanel();
		add(new JScrollPane(output), BorderLayout.CENTER);
	}
}