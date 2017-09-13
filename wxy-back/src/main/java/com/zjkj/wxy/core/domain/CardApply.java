package com.zjkj.wxy.core.domain;


import java.math.BigDecimal;


/**
 * CardApply entity. @author MyEclipse Persistence Tools
 */

public class CardApply  implements java.io.Serializable {


    // Fields    

     private String id;//申请id
     private Classes classes;//班级
     private Grade grade;//年级
     private School school;//学校
     private Student student;//学生
     private String applyer;//申请人
     private String applytime;//申请时间
     private Integer type;//申请类型 2：买卡申请3：退卡申请4：换卡申请
     private Integer isdeal;//是否处理，1：处理0：没
     private Integer num;//申请卡数
     private String card1no;//卡片编码
     private String card2no;
     private String card3no;
     private String card4no;
private String schoolName;
private String gradeName;
private String className;

    // Constructors

    /** default constructor */
    public CardApply() {
    }

	/** minimal constructor */
    public CardApply(String id) {
        this.id = id;
    }
    
    /** full constructor */


   
    // Property accessors

    public String getId() {
        return this.id;
    }
    


	public CardApply(String id, Classes classes, Grade grade, School school, Student student, String applyer,
			String applytime, Integer type, Integer isdeal, Integer num, String card1no, String card2no, String card3no,
			String card4no) {
		super();
		this.id = id;
		this.classes = classes;
		this.grade = grade;
		this.school = school;
		this.student = student;
		this.applyer = applyer;
		this.applytime = applytime;
		this.type = type;
		this.isdeal = isdeal;
		this.num = num;
		this.card1no = card1no;
		this.card2no = card2no;
		this.card3no = card3no;
		this.card4no = card4no;
	}

	public void setId(String id) {
        this.id = id;
    }

    public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getApplyer() {
        return this.applyer;
    }
    
    public void setApplyer(String applyer) {
        this.applyer = applyer;
    }

    public String getApplytime() {
        return this.applytime;
    }
    
    public void setApplytime(String applytime) {
        this.applytime = applytime;
    }


    public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIsdeal() {
		return isdeal;
	}

	public void setIsdeal(Integer isdeal) {
		this.isdeal = isdeal;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getCard1no() {
        return this.card1no;
    }
    
    public void setCard1no(String card1no) {
        this.card1no = card1no;
    }

    public String getCard2no() {
        return this.card2no;
    }
    
    public void setCard2no(String card2no) {
        this.card2no = card2no;
    }

    public String getCard3no() {
        return this.card3no;
    }
    
    public void setCard3no(String card3no) {
        this.card3no = card3no;
    }

    public String getCard4no() {
        return this.card4no;
    }
    
    public void setCard4no(String card4no) {
        this.card4no = card4no;
    }

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
   

}