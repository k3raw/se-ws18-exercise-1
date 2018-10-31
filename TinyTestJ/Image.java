
import java.nio.ByteBuffer;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Image {
	public int height ,width;
	public byte[] data;
	public int rgb;
	public int index;
	public int val=255;
	public int valRgb;
	
	public Image(int height, int width) {
	
		this.height = height;
		this.width = width;
		this.data = new byte [height*width*3];
		
	}
	
	public void set(int x, int y, int val) {
		ByteBuffer dbuf = ByteBuffer.allocate(4);
		byte [] rgba = dbuf.putInt(val).array();
		
		int index = this.linearize(x, y) * 3;
		
		this.data[index] = rgba[1];
		this.data[index + 1] = rgba[2];
		this.data[index + 2] = rgba[3];
	}
	
	public void write(String filename) throws IOException {
		//get idea from nikilsss' github
		FileWriter filewriter = new FileWriter(filename);
		BufferedWriter bufferwriter= new BufferedWriter(filewriter);
		
		String exercise1="p6\t" + width + "\t" + height + "\t" ;
		bufferwriter.write(exercise1);
		 for(int i=0;i<height;i++){
			 bufferwriter.newLine();
			 for(int j=0;j<width;j++){
				 int index = this.linearize(i, j)*3;
				 bufferwriter.write((((data[index]))+"\t"));
				 bufferwriter.write((((data[index + 1]))+"\t"));
				 bufferwriter.write((((data[index + 2]))+"\t"));
				 
			 }
	 }
		bufferwriter.close();
		
	}
	
	private int linearize(int x, int y) {
		return x + this.width * y;
	}
 
}