package com.entelgy.prueba.web.client.fallback;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.entelgy.prueba.model.vo.CommentVo;
import com.entelgy.prueba.web.client.CommentClient;

/**
 * 
 * @author Jhonatan A.
 *
 */
public class CommentClientFallback implements CommentClient{

	
	@Override
	public ResponseEntity<List<CommentVo>> getAllComments() {
		
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}

}
