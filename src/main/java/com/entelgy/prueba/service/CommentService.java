package com.entelgy.prueba.service;

import java.util.List;

import com.entelgy.prueba.exception.ServiceException;
import com.entelgy.prueba.model.vo.CommentVo;

/**
 * 
 * @author Jhonatan A.
 *
 */
public interface CommentService {

	List<CommentVo> findAllComments()throws ServiceException;
	
}
