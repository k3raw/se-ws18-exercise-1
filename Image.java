
import java.nio.ByteBuffer;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileOutputStream;

public class Image {
	public int height ,width;
	public byte[] data;
	public int rgb;
	public int colorRgb=0xFFFFFF;
	public int index;
	public int val=255;
	public int valRgb;
	
	public Image(int height, int width) {
	
		this.height = height;
		this.width = width;
		this.data = new byte [height*width*3];
		
	}
	
	public  void set(int x, int y, int val) {
		valRgb = val & colorRgb;
		ByteBuffer valRgb = ByteBuffer.allocate(3);
		byte [] rgba =valRgb.array();
		
		int index = this.linearize(x, y) * 3;
		
		this.data[index] = rgba[0];
		this.data[index + 1] = rgba[1];
		this.data[index + 2] = rgba[2];
		
	}

	
	public void write(String filename) throws IOException{

	    String string = "p6\t" + width + "\t" + height + "\t";
	     
	    FileOutputStream outputStream = new FileOutputStream(filename);
	    byte[] stringtobyte = string.getBytes();
	    outputStream.write(stringtobyte);
	  
	    outputStream.close();
	}
	
	private int linearize(int x, int y) {
		return x + this.width * y;
	}
 
}