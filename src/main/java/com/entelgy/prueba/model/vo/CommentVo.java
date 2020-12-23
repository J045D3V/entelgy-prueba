package com.entelgy.prueba.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Jhonatan A.
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CommentVo {
	
	private Integer postId;	
	private Integer id;	
	private String name;
	private String email;	
	private String body;
	
}
