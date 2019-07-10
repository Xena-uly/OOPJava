ackage net.ukr.xena_reg;

public class Vector3d {

	private int x;
	private int y;
	private int z;

	public Vector3d(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3d() {
		super();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	public static Vector3d sum(Vector3d v1, Vector3d v2) {

		Vector3d v3 = new Vector3d();
		v3.x=v1.x + v2.x;
		v3.y=v1.y + v2.y;
		v3.z=v1.z + v2.z;

		return v3;
	}

	public static Vector3d vectMultiply(Vector3d v1, Vector3d v2) {

		Vector3d v3 = new Vector3d();
		v3.x=v1.y * v2.z - v2.y * v1.z;
		v3.y=v2.x * v1.z - v1.x * v2.z;
		v3.z=v1.x * v2.y - v2.x * v1.y;

		return v3;
	}

	public static int scalarMultiply(Vector3d v1, Vector3d v2) {

		return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
	}

}
