import java.util.*;

public class Main {
	Scanner sc = new Scanner (System.in);
	Vector<People> vpeople = new Vector<>();
	Vector<String> manager = new Vector<>();
	Vector<String> supervisior = new Vector<>();
	Vector<String> admin = new Vector<>();
	Vector<String> ids = new Vector<>();
	
	public Main() {
		
		int choose = 0;
		do {
			do {
				try {
					System.out.println("-PT Musang-");
					System.out.println("1. Insert data karyawan");
					System.out.println("2. View data karyawan");
					System.out.println("3. Update data karyawan");
					System.out.println("4. Delete data karyawan");
					System.out.println("5. Exit");
					System.out.print(">> ");
					choose = sc.nextInt(); 
				} catch (Exception e) {
					System.err.println("Input must be number!");
					System.out.println();
				} sc.nextLine();
			} while (choose < 1 || choose > 5);
			
			switch (choose) {
			case 1:
				Insert();
				System.out.print("\nENTER to return");
				System.out.println();
				sc.nextLine();
				break;

			case 2:
				View();
				System.out.println("ENTER to return");
				System.out.println();
				sc.nextLine();
				break;
			
			case 3:
				Update();
				System.out.println("ENTER to return");
				System.out.println();
				sc.nextLine();
				break;
				
			case 4:
				Delete();
				System.out.println("ENTER to return");
				System.out.println();
				sc.nextLine();
				break;
			
			case 5:
				System.out.println("Thankyou for using this application :>");
				break;
			}
		} while (choose != 5);

	}
	
	String name;
	String gen;
	String jab;
	String id;
	
	void Insert() {
		
		do {
    		System.out.print("Input nama karyawan [>= 3]: ");
    		name = sc.nextLine();
		} while ( name.length() < 3 ) ;
		
		
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			gen = sc.nextLine();
		} while (!gen.equals("Perempuan") && !gen.equals("Laki-laki"));	
		
		
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jab = sc.nextLine();
		} while (!jab.equals("Manager") && !jab.equals("Supervisor") && !jab.equals("Admin"));
		
		do {
			id = randomChar() + randomChar() + "-" + randomNum() + randomNum() + randomNum() +randomNum();
		} while (ids.contains(id));
		
		ids.add(id);
		System.out.println("Berhasil menambahkan karyawan dengan id " + id);
		
		double bonus = 0;
		int bns = 0;
		int gaji = 0;
		if (jab.equals("Manager")) {
			gaji = 8000000;
			bonus = 10;
			manager.add(jab);
			if ((manager.size()-1)%3 == 0) {
				bns = (int) (gaji + (0.1*gaji));
				for (int i = 0; i < vpeople.size(); i++) {
					if (vpeople.get(i) instanceof Manager) {
						Manager manager = (Manager) vpeople.get(i);
						manager.setGaji(bns);
						vpeople.get(index).setGaji(bns);
					}
				}
			}
			if (manager.size()>3 && (manager.size()%3-1) == 0) {
				System.out.print("A bonus of " + bonus + "% has been given to employees with id ");
				System.out.print(vpeople.get(index).getId() + ", ");
				for (int i = 0; i < vpeople.size(); i++) {
					if (vpeople.get(i) instanceof Manager) {
					Manager manager = (Manager) vpeople.get(i);
					System.out.print(manager.getId() + ", ");
					}
				}
			}			
			
			vpeople.add(new Manager(name, gen, jab, id, gaji));
			
		} else if (jab.equals("Supervisor")) {
			gaji = 6000000;
			bonus = 7.5;
			supervisior.add(jab);
			if ((supervisior.size()-1)%3 == 0) {
				bns = (int) (gaji + (0.075*gaji));
				for (int i = 0; i < vpeople.size(); i++) {
					if (vpeople.get(i) instanceof Supervisor) {
					Supervisor supervisor = (Supervisor) vpeople.get(i);
					supervisor.setGaji(bns);
					vpeople.get(index).setGaji(bns);
					}
				}
			} 
			if (supervisior.size()>3 && (supervisior.size()%3-1) == 0) {	
				System.out.print("A bonus of " + bonus + "% has been given to employees with id ");
				System.out.print(vpeople.get(index).getId() + ", ");
				for (int i = 0; i < vpeople.size(); i++) {
					if (vpeople.get(i) instanceof Supervisor) {
					Supervisor supervisor = (Supervisor) vpeople.get(i);
					System.out.print(supervisor.getId() + ", ");
					}
				}
			}
			vpeople.add(new Supervisor(name, gen, jab, id, gaji));
			
		} else if (jab.equals("Admin")) {
			gaji = 4000000;
			bonus = 5;
			admin.add(jab);
			if ((admin.size()-1)%3 == 0) {
				bns = (int) (gaji + (0.05*gaji));
				for (int i = 0; i < vpeople.size(); i++) {
					if (vpeople.get(i) instanceof Admin) {
					Admin admin = (Admin) vpeople.get(i);
					admin.setGaji(bns);
					vpeople.get(index).setGaji(bns);
					}
				}
			} 
			if (admin.size()>3 && (admin.size()%3-1) == 0) {	
				System.out.print("A bonus of " + bonus + "% has been given to employees with id ");
				System.out.print(vpeople.get(index).getId() + ", ");
				for (int i = 0; i < vpeople.size(); i++) {
					if (vpeople.get(i) instanceof Admin) {
					Admin admin = (Admin) vpeople.get(i);
					System.out.print(admin.getId() + ", ");
					}
				}
			}
			vpeople.add(new Admin(name, gen, jab, id, gaji));
		}
		
	} // tutup void 
	
	
	void View() {
		if (vpeople.isEmpty()) {
			System.err.println("-No Data-");
		} else {
			Display ();
			}
	}
	
	void Display() {
		for (int i = 0; i < vpeople.size(); i++) {
		    for (int j = 0; j < vpeople.size()-i-1; j++) {
		    if((vpeople.get(j).getName().compareTo(vpeople.get(j+1).getName())) > 0) {
		      People temp = vpeople.get(j);
		      vpeople.set(j, vpeople.get(j+1));
		      vpeople.set(j+1, temp);
		     }
		    }
		   }
		
		System.out.println("=================================================================================================");
		System.out.printf("| %-4s | %-13s | %-22s | %-13s | %-13s | %-13s |\n", "No.", "Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan", "Gaji Karyawan");
		System.out.println("=================================================================================================");
		
		for (int i = 0; i < vpeople.size(); i++) {
			if (vpeople.get(i) instanceof Manager) {
				Manager manager = (Manager) vpeople.get(i);
				System.out.printf("| %-4s | %-13s | %-22s | %-13s | %-13s | %-13s |\n", (i+1), manager.getId(), manager.getName(), manager.getGen(), manager.getJab(), manager.getGaji());
			} else if (vpeople.get(i) instanceof Supervisor) {
				Supervisor supervisor = (Supervisor) vpeople.get(i);
				System.out.printf("| %-4s | %-13s | %-22s | %-13s | %-13s | %-13s |\n", (i+1), supervisor.getId(), supervisor.getName(), supervisor.getGen(), supervisor.getJab(), supervisor.getGaji());
			} else if (vpeople.get(i) instanceof Admin){
				Admin admin = (Admin) vpeople.get(i);
				System.out.printf("| %-4s | %-13s | %-22s | %-13s | %-13s | %-13s |\n", (i+1), admin.getId(), admin.getName(), admin.getGen(), admin.getJab(), admin.getGaji());
			}
		}
		System.out.println("=================================================================================================");
	}
	
    int index;
	void Update () {
		if (vpeople.isEmpty()) {
			System.err.println("-No Data-");
		} else {
		Display();
		do {
			try {
				System.out.print("Input nomor urutan karyawan yang ingin diupdate : ");
				index = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Input harus angka!");
			}
			sc.nextLine();
		} while (index > vpeople.size());
		
		String name;
		do {
    		System.out.print("Input nama karyawan [>= 3]: ");
    		name = sc.nextLine();
		} while ( name.length() < 3 && !name.equals("0")) ;
		
		String gen;
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			gen = sc.nextLine();
		} while (!gen.equals("Perempuan") && !gen.equals("Laki-laki") && !gen.equals("0"));	
		
		String jab;
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive):");
			jab = sc.nextLine();
		} while (!jab.equals("Manager") && !jab.equals("Supervisor") && !jab.equals("Admin") && !jab.equals("0"));
		
		index -= 1;

		System.out.println("Berhasil mengupdate karyawan dengan id " + vpeople.get(index).getId());
		
		if (name.equals("0")) {
			vpeople.get(index).getName();
		} else {
			vpeople.get(index).setName(name);
		}
		
		if (gen.equals("0")) {
			vpeople.get(index).getGen();
		} else {
			vpeople.get(index).setGen(gen);
		}
		
		if (jab.equals("0")) {
			vpeople.get(index).getJab();
		} else {
			vpeople.get(index).setJab(jab);
			int gaji = 0;
			if (jab.equals("Manager")) {
			manager.add(jab);
			gaji = 8000000;
			vpeople.get(index).setGaji(gaji);
			} else if (jab.equals("Supervisor")) {
			supervisior.add(jab);
			gaji = 6000000;
			vpeople.get(index).setGaji(gaji);
			} else if (jab.equals("Admin")) {
			admin.add(jab);
			gaji = 4000000;
			vpeople.get(index).setGaji(gaji);
			}
		}
		
		}
	}
	
	void Delete() {
		if (vpeople.isEmpty()) {
			System.err.println("-No Data-");
		} else {
			Display();
			do {
				try {
					System.out.print("Input nomor urutan karyawan yang ingin dihapus: ");
					index = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Input harus angka!");
				}
				sc.nextLine();
			} while (index < 1 || index > vpeople.size());
			index -= 1;
			System.out.println("Karyawan dengan kode " + vpeople.get(index).getId() + " berhasil dihapus");
			vpeople.remove(index);
		}

	}
	
	static String randomNum() {
        Random rd = new Random();
        return String.valueOf(rd.nextInt(9));
    }
    
    static String randomChar() {
        Random rd = new Random();
        return String.valueOf((char)(rd.nextInt(90-65+1)+65));
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
