import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class CustomGraphicsGrid extends JPanel {

	private int panel_x = 500;
	private int panel_y = 500;
	private int grid_size = 10;
	private int grid_border_spacing = 50;
	private Point grid_pixel_size;


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
		drawSimpleGrid(g, width, height);
		g2d.dispose(); //<-- Deletes the graphics component, cannot draw after this
	}

	public int drawCustomLine(Point p1, Point p2) {
		if (p1.x < 0 || p1.y < 0 || p2.x < 0 || p2.y <0
			||p1.x > grid_pixel_size.x || p1.y > grid_pixel_size.y
			|| p2.x > grid_pixel_size.x || p2.y > grid_pixel_size.y) {
			System.out.println("Error - line out of bound");
			return 0;
		}
		System.out.println("Success");
		getGraphics().drawLine(p1.x, p1.y, p2.x, p2.y);
		return 1;
	}

	private void drawSimpleGrid (Graphics g, int width, int height) {
		int size = Math.min(width - grid_border_spacing, height - grid_border_spacing) / grid_size;

		int y = (height - (size * grid_size)) / 2;
		for (int horz = 0; horz < grid_size; horz++) {
			int x = (width - (size * grid_size)) / 2;
			for (int vert = 0; vert < grid_size; vert++) {
				g.drawRect(x, y, size, size);
				x += size;
			}
			y += size;
			
			//this.grid_pixel_size = new Point (x,y);
		}
		//System.out.println("The final grid size is:[" + grid_pixel_size.x + "," + grid_pixel_size.y + "]");
	}

	private  void drawSimpleGrid2 (Graphics g, int width, int height) {
		int rows = 20;
		int cols = 30;

		// draw the rows
		int rowHt = height / (rows);
		for (int i = 0; i < rows; i++)
			g.drawLine(0, i * rowHt, width, i * rowHt);

		// draw the columns
		int rowWid = width / (cols);
		for (int i = 0; i < cols; i++)
			g.drawLine(i * rowWid, 0, i * rowWid, height);
	}
}

