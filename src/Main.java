import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;

class Solution {
    private static final String DENSITY = "@QB#NgWM8RDHdOKq9$6khEPXwmeZaoS2yjufF]}{tx1zv7lciL/\\|?*>r^;:_\"~,'.-`";

    public static void main(String[] args) {
        try {
            char[][] chars = readImage("C:\\Users\\user\\IdeaProjects\\png_to_txt\\src\\123.jpg", 3, 1);
            writeToFile("C:\\Users\\user\\IdeaProjects\\png_to_txt\\src\\image.txt", chars);
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    private static char[][] readImage(String path, int scaleHeight, int scaleWidth) throws IOException {
        BufferedImage image = ImageIO.read(new File(path));
        int height = image.getHeight() / scaleHeight;
        int width = image.getWidth() / scaleWidth;
        char[][] chars = new char[height][width];

        for(int i = 0; i < height; ++i) {
            for(int j = 0; j < width; ++j) {
                int colorRGB = 0;

                int p;
                for(int k = 0; k < scaleHeight; ++k) {
                    for(p = 0; p < scaleWidth; ++p) {
                        colorRGB += image.getRGB(j * scaleWidth + p, i * scaleHeight + k);
                    }
                }

                Color color = new Color(colorRGB / (scaleHeight * scaleWidth));
                p = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                chars[i][j] = getDensity(p);
            }
        }

        return chars;
    }

    private static char getDensity(int value) {
        int charValue = (int)Math.round((double)"@QB#NgWM8RDHdOKq9$6khEPXwmeZaoS2yjufF]}{tx1zv7lciL/\\|?*>r^;:_\"~,'.-`".length() / 255.0 * (double)value);
        charValue = Math.max(charValue, 0);
        charValue = Math.min(charValue, "@QB#NgWM8RDHdOKq9$6khEPXwmeZaoS2yjufF]}{tx1zv7lciL/\\|?*>r^;:_\"~,'.-`".length() - 1);
        return "@QB#NgWM8RDHdOKq9$6khEPXwmeZaoS2yjufF]}{tx1zv7lciL/\\|?*>r^;:_\"~,'.-`".charAt(charValue);
    }

    private static void writeToFile(String path, char[][] chars) throws IOException {
        FileWriter writer = new FileWriter(path);

        try {
            char[][] var3 = chars;
            int var4 = chars.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                char[] row = var3[var5];
                String str = String.valueOf(row);
                writer.append(str).write("\n");
                System.out.println(str);
            }
        } catch (Throwable var9) {
            try {
                writer.close();
            } catch (Throwable var8) {
                var9.addSuppressed(var8);
            }

            throw var9;
        }

        writer.close();
    }
}
