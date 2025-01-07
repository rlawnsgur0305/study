package study.core.member;



public class Member {
	
	// member 클래스의 멤버변수
	private long id;
	private String name;
	private Grade grade;
	
	
	// 멤버 변수를 모두 사용해서 만드는 생성자
	public Member(long id, String name, Grade grade) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	
	// 데이터의 삽입과 조회를 담당하는 게터 / 세터
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
}
