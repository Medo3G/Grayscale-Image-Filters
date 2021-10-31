import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Task3 {

	// Since the image is gray-scale, I only work on the red values
	// Values calculated by http://dev.theomader.com/gaussian-kernel-calculator/

	public static void gaussianFilter3(String outputName, BufferedImage image) throws IOException {
		double[][] a = { { 0.077847, 0.123317, 0.077847 }, { 0.123317, 0.195346, 0.123317 },
				{ 0.077847, 0.123317, 0.077847 } };
		BufferedImage output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		Color c = new Color(0, 0, 0);
		Color c2 = new Color(0, 0, 0);
		int value = 0;
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				for (int i = x - 1, g1 = 0; i <= x + 1; i++, g1++) {
					for (int j = y - 1, g2 = 0; j <= y + 1; j++, g2++) {
						if (i > 0 && i < image.getWidth() - 1 && j > 0 && j < image.getHeight() - 1) {
							c = new Color(image.getRGB(i, j));
							value += ((int) c.getRed() * a[g2][g1]);
						}

					}

				}
				c2 = new Color(value, value, value);
				output.setRGB(x, y, c2.getRGB());
				value = 0;
			}

		}
		System.out.println(ImageIO.write(output, "png", new File(outputName + ".png")));
	}

	public static void gaussianFilter7(String outputName, BufferedImage image) throws IOException {
		double[][] a = { { 0.000036, 0.000363, 0.001446, 0.002291, 0.001446, 0.000363, 0.000036 },
				{ 0.000363, 0.003676, 0.014662, 0.023226, 0.014662, 0.003676, 0.000363 },
				{ 0.001446, 0.014662, 0.058488, 0.092651, 0.058488, 0.014662, 0.001446 },
				{ 0.002291, 0.023226, 0.092651, 0.146768, 0.092651, 0.023226, 0.002291 },
				{ 0.001446, 0.014662, 0.058488, 0.092651, 0.058488, 0.014662, 0.001446 },
				{ 0.000363, 0.003676, 0.014662, 0.023226, 0.014662, 0.003676, 0.000363 },
				{ 0.000036, 0.000363, 0.001446, 0.002291, 0.001446, 0.000363, 0.000036 } };
		BufferedImage output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		Color c = new Color(0, 0, 0);
		Color c2 = new Color(0, 0, 0);
		int value = 0;
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				for (int i = x - 3, g1 = 0; i <= x + 3; i++, g1++) {
					for (int j = y - 3, g2 = 0; j <= y + 3; j++, g2++) {
						if (i > 0 && i < image.getWidth() - 1 && j > 0 && j < image.getHeight() - 1) {
							c = new Color(image.getRGB(i, j));
							value += ((int) c.getRed() * a[g2][g1]);
						}

					}

				}
				c2 = new Color(value, value, value);
				output.setRGB(x, y, c2.getRGB());
				value = 0;
			}

		}
		System.out.println(ImageIO.write(output, "png", new File(outputName + ".png")));
	}

	public static void main(String[] args) throws IOException {

		BufferedImage bi = ImageIO.read(new File("example.png"));
		gaussianFilter3("gaussian3x3", bi);
		gaussianFilter7("gaussian7x7", bi);

	}

}
