package puzzle;
/**
 * @author Administrator
 * �����
 */
public class Player implements Comparable{
	/*
	 * name: String, �������
	 * time: String, �����Ϸʹ�õ�ʱ�䣬��ʽΪhh:mm:ss
	 */
	private String name;
	private String time;
	private int grade;
	
	public Player() {
		this.name = "";
		this.time = "";
		this.grade = 0;
	}
	
	public Player(String name, String time, int grade) {
		this.name = name;
		this.time = time;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Player p = (Player)o;
		if (this.compare(p)) {
			return -1;
		} else {
			return 1;
		}
	}
	
	public boolean compare(Player p2) {
		String[] t1 = this.time.split(":");
		String[] t2 = p2.getTime().split(":");
		int h1 = Integer.parseInt(t1[0]);
		int m1 = Integer.parseInt(t1[1]);
		int s1 = Integer.parseInt(t1[2]);
		int h2 = Integer.parseInt(t2[0]);
		int m2 = Integer.parseInt(t2[1]);
		int s2 = Integer.parseInt(t2[2]);
		if (h1 > h2) {
			return true;
		} else if(m1 > m2) {
			return true;
		} else if(s1 > s2) {
			return true;
		}
		return false;
	}
	
}
