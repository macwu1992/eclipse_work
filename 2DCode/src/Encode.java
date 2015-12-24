import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

/*二维码生成*/
public class Encode {
	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;
	
	public int width =400;
	public int height = 400;
	public String format = "png";
	
	Encode(String content){

		File file = new File("/Users/Tong/Desktop/", System.currentTimeMillis()+"."+format);
		Map hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");	
	
		try{
			BitMatrix matrix = new MultiFormatWriter().encode(
					content, BarcodeFormat.QR_CODE, width, height, hints);
			this.writeToFile(matrix, format, file);
		}catch(Exception e){e.printStackTrace();}
	}
	
	public BufferedImage toBufferedImage(BitMatrix matrix){
		int x = matrix.getWidth();
		int y = matrix.getHeight();
		
		BufferedImage image = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
		for(int i = 0; i<x; i++){
			for(int j = 0; j<y; j++){
				image.setRGB(i, j, matrix.get(i,j)?BLACK:WHITE);
			}
			System.out.println();
		}
		return image;
	}
	
	public void writeToFile(BitMatrix matrix, String format,File file){
		BufferedImage image = toBufferedImage(matrix);
		try{
			ImageIO.write(image, format, file);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String content = "王华小吊毛";

		new Encode(content);
	}
}
