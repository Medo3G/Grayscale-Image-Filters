import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Task1 {

	// Since the image is gray-scale, I only work on the red values

	public static void meanFilter(int size, String outputName, BufferedImage image) throws IOException {
		int sum = 0;
		int count = 0;
		BufferedImage output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		Color c = new Color(0, 0, 0);
		Color c2 = new Color(0, 0, 0);
		int mean = 0;
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				sum = 0;
				count = 0;
				for (int i = x + (-1) * size / 2; i <= x + size / 2; i++) {
					for (int j = y + (-1) * size / 2; j <= y + size / 2; j++) {
						if (i > 0 && i < image.getWidth() - 1 && j > 0 && j < image.getHeight() - 1) {
							c = new Color(image.getRGB(i, j));
							sum += c.getRed();
							count++;
						}

					}

				}
				mean = sum / count;
				c2 = new Color(mean, mean, mean);
				output.setRGB(x, y, c2.getRGB());
			}

		}
		System.out.println(ImageIO.write(output, "png", new File(outputName + ".png")));
	}

	public static void main(String[] args) throws IOException {

		BufferedImage bi = ImageIO.read(new File("example.png"));
		meanFilter(3, "mean3x3", bi);
		meanFilter(7, "mean7x7", bi);

	}
}
