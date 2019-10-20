package com.buam.nlcsv;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class LWOLoader {

	private byte[] data;
	public List<Vector3> vertices;
	public List<Integer> indices;
	
	public LWOLoader(String path) {
		File lwoFile = new File(path);
		vertices = new ArrayList<Vector3>();
		if(lwoFile.exists()) {
			try {
				data = IOUtils.toByteArray(new FileInputStream(lwoFile));
				/*for(byte b : data) {
					System.out.print((char) b);
				}*/
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(data != null) {
				int firstPointIndex = 0;
				int numberPoints = 0;
				for(int i = 0; i<data.length; i++) {
					if((char) data[i] == 'P' && (char) data[i+1] == 'N' && (char) data[i+2] == 'T' && (char) data[i+3] == 'S') {
						firstPointIndex = i+8 /*Skip Number of points*/;
						numberPoints = (new BigInteger(Arrays.copyOfRange(data, i+4, i+8))).intValue()/12;
						System.out.println("\nNumber of vertices: " + numberPoints);
						break;
					}
				}
				byte[] points = Arrays.copyOfRange(data, firstPointIndex, numberPoints*12+firstPointIndex);
				System.out.println("Bytes in PNTS-Chunk: " + points.length);
				for(int i = 0; i<points.length; i+=12) {
					
					float x = GetFloat32(toBinaryString(Arrays.copyOfRange(points, i, i+4)));
					float y = GetFloat32(toBinaryString(Arrays.copyOfRange(points, i+4, i+8)));
					float z = -GetFloat32(toBinaryString(Arrays.copyOfRange(points, i+8, i+12)));
					
					vertices.add(new Vector3(x, y, z));
					//System.out.println(((i/12)+1) + " " + x + " " + y + " " + z);
				}
				
			}
		}
	}
	
	private static float GetFloat32(String Binary)  
    {  
        int intBits = new BigInteger(Binary, 2).intValue();
        float myFloat = Float.intBitsToFloat(intBits);
        return myFloat;
    }
	
	public static char[] toCharArray(byte[] in) {
		char[] out = new char[in.length];
		
		for(int i = 0; i<in.length; i++) {
			out[i] = (char) in[i];
		}
		
		return out;
	}
	
	public static String toBinaryString(byte[] bytes) {
		String s = "";
		
		for(byte b : bytes) {
			s += String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
		}
		
		return s;
	}
	
	public static char[] subCharArray(int startIndex, int endIndex, byte[] bytes) {
		char[] out = new char[endIndex-startIndex+1];
		for(int i = startIndex; i<endIndex-1; i++) {
			out[i] = (char) bytes[i];
		}
		return out;
	}
	
	public static byte[] subByteArray(int startIndex, int endIndex, byte[] bytes) {
		byte[] out = new byte[endIndex-startIndex+1];
		for(int i = startIndex; i<endIndex-1; i++) {
			out[i] = bytes[i];
		}
		return out;
	}
	
	private static float getFloat32(int intBits)  
    { 
        float myFloat = Float.intBitsToFloat(intBits);
        return myFloat;
    } 
     
    // Get 32-bit IEEE 754 format of the decimal value  
    private static String getBinary32( float value )  
    {  
        int intBits = Float.floatToIntBits(value); 
        String binary = Integer.toBinaryString(intBits);
        return binary;
    } 
	
}
