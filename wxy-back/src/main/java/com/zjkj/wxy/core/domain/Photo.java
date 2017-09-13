package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;


/**
 * Photo entity. @author MyEclipse Persistence Tools
 */

public class Photo  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Album album;
     private String name;
     private String url;


    // Constructors

    /** default constructor */
    public Photo() {
    }

	/** minimal constructor */
    public Photo(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Photo(Integer id, Album album, String name, String url) {
        this.id = id;
        this.album = album;
        this.name = name;
        this.url = url;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Album getAlbum() {
        return this.album;
    }
    
    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
   








}