package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Worker {
	@Id
	@Column
	private String id;
	
	@Column
	private String name;
	
	@Column
	private int age;
	
	@Column(name="sal")
	private int pay;

}
