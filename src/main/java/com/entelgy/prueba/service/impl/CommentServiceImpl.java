package com.entelgy.prueba.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.entelgy.prueba.configuration.constant.AppConstant;
import com.entelgy.prueba.exception.ServiceException;
import com.entelgy.prueba.model.vo.CommentVo;
import com.entelgy.prueba.service.CommentService;
import com.entelgy.prueba.web.client.CommentClient;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Jhonatan A.
 *
 */
@Slf4j
@Service
public class CommentServiceImpl implements CommentService{

	private CommentClient commentClient;
	
	public CommentServiceImpl(CommentClient commentClient) {
		this.commentClient=commentClient;
	}
	
	@Override
	public List<CommentVo> findAllComments() throws ServiceException{

		ResponseEntity<List<CommentVo>> listComment = commentClient.getAllComments();
		
		//Si la peticion no tiene status 200 se genera un error
		if(listComment.getStatusCode() != HttpStatus.OK) {
			log.error(AppConstant.getLogFormat("findAllComments"),"status "+listComment.getStatusCode().value());
			throw new ServiceException("Error: status "+listComment.getStatusCode().value());
		}
		
		//Depende del requerimiento. En este caso si no hay comentarios genero un error
		if(CollectionUtils.isEmpty(listComment.getBody())) {
			throw new ServiceException("Error: No existen comentarios");
		}
		
		return listComment.getBody();
	}

}
