package puzzle;
/**
 * @author Administrator
 * �����
 */
public class Player{
	/*
	 * name: String, �������
	 * time: int, �����Ϸ��Ҫ��ʱ��
	 * grade: int, ��Ϸ�ȼ�
	 * id: String, �����ļ�ʱ��Ҫ�Ķ���id����name+grade����
	 */
	private String name;
	private int time;
	private int grade;
	private String id;
	
	public Player() {
		this.name = "";
		this.time = 0;
		this.grade = 0;
		this.setId("");
	}
	
	public Player(Player p) {
		this.name = p.getName();
		this.time = p.getTime();
		this.grade = p.getGrade();
		this.id = p.getId();
	}
	
	public Player(String name, int time, int grade) {
		this.name = name;
		this.time = time;
		this.grade = grade;
		this.id = name + String.valueOf(grade);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
