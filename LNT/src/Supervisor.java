
public class Supervisor extends People{

	private int gaji;

	public Supervisor(String name, String gen, String jab, String id, int gaji) {
		super(name, gen, jab, id);
		this.gaji = gaji;
	}

	public int getGaji() {
		return gaji;
	}

	public void setGaji(int gaji) {
		this.gaji = gaji;
	}

	

}
