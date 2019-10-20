package com.buam.nlcsv;

public class Vector3 {

	private float x, y, z;
	
	public Vector3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public static float distance(Vector3 a, Vector3 b) {
		return (float) Math.sqrt(Math.pow(a.getX()-b.getX(), 2) + Math.pow(a.getY()-b.getY(), 2) + Math.pow(a.getZ()-b.getZ(), 2));
	}
	
	public static Vector3 getMiddleValue(Vector3[] node) {
		float x = 0f;
		float y = 0f;
		float z = 0f;
		
		for(int i = 0; i<node.length; i++) {
			x += node[i].getX();
			y += node[i].getY();
			z += node[i].getZ();
		}

		x /= node.length;
		y /= node.length;
		z /= node.length;
		
		return new Vector3(x, y, z);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public static Vector3 getUpVector(Vector3[] node, Vector3 middlePoint) {
		Vector3 topPoint = getMiddleValue(new Vector3[] {node[1], node[2]});
		
		return new Vector3(topPoint.getX()-middlePoint.getX(), topPoint.getY()-middlePoint.getY(), (topPoint.getZ()-middlePoint.getZ())).normalize();
	}

	public static Vector3 getLeftVector(Vector3[] node, Vector3 middlePoint) {
		Vector3 leftPoint = getMiddleValue(new Vector3[] {node[0], node[1]});
		
		return new Vector3(leftPoint.getX()-middlePoint.getX(), leftPoint.getY()-middlePoint.getY(), (leftPoint.getZ()-middlePoint.getZ())).normalize();
	}

	public static float getMagnitude(Vector3 vec) {
		return (float) Math.sqrt(Math.pow(vec.getX(), 2) + Math.pow(vec.getY(), 2) + Math.pow(vec.getZ(), 2));
	}
	
	public static Vector3 normalize(Vector3 vec) {
		float mag = getMagnitude(vec);
		return new Vector3(vec.getX()/mag, vec.getY()/mag, vec.getZ()/mag);
	}
	
	public Vector3 normalize() {
		float mag = getMagnitude(this);
		return new Vector3(getX()/mag, getY()/mag, getZ()/mag);
	}
}
