package net.ukr.xena_reg;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ArtGenerator {
	
	public static final int ART_SIZE_SMALL = 12;
    public static final int ART_SIZE_MEDIUM = 18;
    public static final int ART_SIZE_LARGE = 24;
    public static final int ART_SIZE_HUGE = 32;
 
    public static final String DEFAULT_ART_SYMBOL = "*";
    
    public enum ArtFont {
        ART_FONT_DIALOG("Dialog"), ART_FONT_DIALOG_INPUT("DialogInput"), 
        ART_FONT_MONO("Monospaced"),ART_FONT_SERIF("Serif"), ART_FONT_SANS_SERIF("SansSerif");
    
        private String value;
 
        public String getValue() {
            return value;
        }
 
        private ArtFont(String value) {
            this.value = value;
        }
    }
    
    /**
     * Prints ASCII art for you symbol or text. Return String Array you symbol or text. 
     * You can use predefined sizes or custom size and use one of the available fonts.
     * @param artText
     * @param textHeight - Use a predefined size or a custom type
     * @param fontType - Use one of the available fonts
     * @param artSymbol - The character for printing the ascii art
     * @throws Exception
     */
    public String [] textArt(String artText, int textHeight, ArtFont fontType, String artSymbol) throws Exception {
        String fontName = fontType.getValue();
        int imageWidth = findImageWidth(textHeight, artText, fontName);
        String [] text = new String[textHeight];
 
        BufferedImage image = new BufferedImage(imageWidth, textHeight, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Font font = new Font(fontName, Font.TRUETYPE_FONT, textHeight);
        g.setFont(font);
 
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawString(artText, 0, getBaselinePosition(g, font));
 
        for (int y = 0; y < textHeight; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < imageWidth; x++)
                sb.append(image.getRGB(x, y) == Color.WHITE.getRGB() ? artSymbol : " ");
            if (sb.toString().trim().isEmpty())
                continue;
            text[y]=sb.toString();
            //System.out.println(text[y]);
        }
        return text;
    }
    
    public void printArtText(String[] text) {
    	
    	for (String string : text) {
    		
    		System.out.println(string);
			
		} 	
    	
    }
    
    /**
     * Using the Current font and current art text find the width of the full image
     * @param textHeight
     * @param artText
     * @param fontName
     * @return image width
     */
    public int findImageWidth(int textHeight, String artText, String fontName) {
        BufferedImage im = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graphics g = im.getGraphics();
        g.setFont(new Font(fontName, Font.TRUETYPE_FONT, textHeight));
        return g.getFontMetrics().stringWidth(artText);
    }
 
    /**
     * Find where the text baseline should be drawn so that the characters are within image
     * @param g
     * @param font
     * @return
     */
    public int getBaselinePosition(Graphics g, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int y = metrics.getAscent() - metrics.getDescent();
        return y;
    }
 
}
