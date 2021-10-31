import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;

public class Task2 {

	// Since the image is gray-scale, I only work on the red values

	public static void medianFilter(int size, String outputName, BufferedImage image) throws IOException {
		ArrayList<Integer> a = new ArrayList<>();
		BufferedImage output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		Color c = new Color(0, 0, 0);
		Color c2 = new Color(0, 0, 0);
		int median = 0;
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				a.clear();
				for (int i = x + (-1) * size / 2; i <= x + size / 2; i++) {
					for (int j = y + (-1) * size / 2; j <= y + size / 2; j++) {
						if (i > 0 && i < image.getWidth() - 1 && j > 0 && j < image.getHeight() - 1) {
							c = new Color(image.getRGB(i, j));
							a.add(c.getRed());
						}

					}

				}
				Collections.sort(a);
				median = a.get(a.size() / 2);
				c2 = new Color(median, median, median);
				output.setRGB(x, y, c2.getRGB());
			}

		}
		System.out.println(ImageIO.write(output, "png", new File(outputName + ".png")));
	}

	public static void main(String[] args) throws IOException {

		BufferedImage bi = ImageIO.read(new File("example.png"));
		medianFilter(3, "median3x3", bi);
		medianFilter(7, "median7x7", bi);

	}

}
