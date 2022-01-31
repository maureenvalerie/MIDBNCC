
public class People {
	
	private String name = null;
	private String gen = null;
	private String jab = null;
	private String id = null;
	private int gaji = 0;
	
	public People(String name, String gen, String jab, String id) {
		super();
		this.name = name;
		this.gen = gen;
		this.jab = jab;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public String getJab() {
		return jab;
	}
	public void setJab(String jab) {
		this.jab = jab;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	private People(String name, String gen, String jab, String id, int gaji) {
		super();
		this.name = name;
		this.gen = gen;
		this.jab = jab;
		this.id = id;
		this.gaji = gaji;
	}
	public int getGaji() {
		return gaji;
	}
	public void setGaji(int gaji) {
		this.gaji = gaji;
	}
	
	
	
	
}
