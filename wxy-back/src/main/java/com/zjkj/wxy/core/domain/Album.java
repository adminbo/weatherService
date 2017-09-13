package com.zjkj.wxy.core.domain;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


/**
 * Album entity. @author MyEclipse Persistence Tools
 */

public class Album  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Classes cla;
     private Grade grade;
     private School school;
     private String name;
     private Integer num;
     private String img;
     private Set photos = new HashSet(0);


    // Constructors

    /** default constructor */
    public Album() {
    }

	/** minimal constructor */
    public Album(Integer id) {
        this.id = id;
    }
    


   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }



    public Classes getCla() {
		return cla;
	}

	public void setCla(Classes cla) {
		this.cla = cla;
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

	public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return this.num;
    }
    
    public void setNum(Integer num) {
        this.num = num;
    }

    public Set getPhotos() {
        return this.photos;
    }
    
    public void setPhotos(Set photos) {
        this.photos = photos;
    }

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
   
    







}