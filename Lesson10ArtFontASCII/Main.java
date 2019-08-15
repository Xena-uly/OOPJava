package net.ukr.xena_reg;

import java.util.HashMap;
import java.util.Map;
import net.ukr.xena_reg.ArtGenerator.ArtFont;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String alphabet = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
		ArtGenerator artGen = new ArtGenerator();

		Map<String, String[]> map = makeArtMap(alphabet, artGen);

		printArtMap(map);

		String [] artText=artGen.textArt("Hello, World!", ArtGenerator.ART_SIZE_MEDIUM, ArtFont.ART_FONT_DIALOG, "*");
		artGen.printArtText(artText);
	}

	public static Map<String, String[]> makeArtMap(String alphabet, ArtGenerator artGen) throws Exception {

		Map<String, String[]> map = new HashMap<String, String[]>();

		for (String letter : alphabet.split(",")) {
			map.put(letter,
					artGen.textArt(letter, ArtGenerator.ART_SIZE_SMALL, ArtFont.ART_FONT_SERIF, letter.toLowerCase()));

		}
		return map;

	}

	public static void printArtMap(Map<String, String[]> map) throws Exception {

		ArtGenerator artGen = new ArtGenerator();

		for (String letter : map.keySet()) {

			String[] artLetter = artGen.textArt(letter, ArtGenerator.ART_SIZE_SMALL, ArtFont.ART_FONT_SERIF,
					letter.toLowerCase());

			System.out.println(letter + "--> ");

			for (String element : artLetter) {
				System.out.println(element);
			}
			System.out.println();
		}
	}

}
