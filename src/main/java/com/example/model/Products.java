package com.example.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "products")
public class Products implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Autoincremental.
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "price")
    private Double price;
    
    @Column(name = "units")
    private Integer units;
    
    @Column(name = "packaging")
    private String packaging;
    
    @Column(name = "discount")
    private String discount;
    
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "created_at", updatable = false)
    private Date created_at;
    
    @UpdateTimestamp 
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "update_at", insertable = false)
    private Date update_at;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "deleted_at", nullable = true)
    private Date deleted_at;
}
