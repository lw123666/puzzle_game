package puzzle;

public class Player {
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
	
}
