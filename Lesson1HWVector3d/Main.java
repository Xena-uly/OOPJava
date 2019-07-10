package net.ukr.xena_reg;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vector3d v1 = new Vector3d(1, 1, 1);
		System.out.println("v1 = " + v1);
		Vector3d v2 = new Vector3d(3, 3, 3);
		System.out.println("v2 = " + v2);

		System.out.println("Sum vectors = " + Vector3d.sum(v1, v2));

		System.out.println("Vector multiplication = " + Vector3d.vectMultiply(v1, v2));
		
		System.out.println("Scalar multiplication = " + Vector3d.scalarMultiply(v1, v2));

	}

}
