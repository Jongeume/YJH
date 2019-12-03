package kr.yjh.lecture.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
public class TestVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3916784711637328954L;
	private int idx;
	private String name;
	private int age;
}
