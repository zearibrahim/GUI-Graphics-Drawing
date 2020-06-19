import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CustomGraphicsGrid extends JPanel {

	private static int panel_x = 500;
	private static int panel_y = 500;
	private static int grid_size = 6;
	private static int grid_border_spacing = 50;

	public CustomGraphicsGrid() {
		//empty constructor
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(panel_x, panel_y);
	}

	//Paint grid according to grid_size by calling the user-defined method
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		int width = getWidth();
		int height = getHeight();
		drawCustomGrid(g, width, height);
		g2d.dispose(); //<-- Deletes the graphics component, cannot draw after this
	}

	private static void drawCustomGrid (Graphics g, int width, int height)
	{
		int size = Math.min(width - grid_border_spacing, height - grid_border_spacing) / grid_size;
		int y = (height - (size * grid_size)) / 2;
		for (int horz = 0; horz < grid_size; horz++) {
			int x = (width - (size * grid_size)) / 2;
			for (int vert = 0; vert < grid_size; vert++) {
				g.drawRect(x, y, size, size);
				x += size;
			}
			y += size;
		}
	}
}