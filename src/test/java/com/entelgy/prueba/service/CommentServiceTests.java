package com.entelgy.prueba.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.entelgy.prueba.exception.ServiceException;
import com.entelgy.prueba.model.vo.CommentVo;
import com.entelgy.prueba.service.impl.CommentServiceImpl;
import com.entelgy.prueba.web.client.CommentClient;

/**
 * 
 * @author Jhonatan A.
 *
 */
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("dev")
class CommentServiceTests {
	
	@Mock
	private CommentClient commentClient;
	
	private CommentService commentService;

	@BeforeEach
	void init() {
		commentService = new CommentServiceImpl(commentClient);
	}
	
	
	@Test
	void shouldGetAllComments() throws ServiceException {
		
		CommentVo comment = CommentVo.builder()
				.id(1)
				.name("id labore ex et quam laborum")
				.body("laudantium enim quasi est quidem")
				.email("Eliseo@gardner.biz")
				.build();
		
		
		when(commentClient.getAllComments()).thenReturn(new ResponseEntity<>(Arrays.asList(comment),HttpStatus.OK));
		
		List<CommentVo> listComments = commentService.findAllComments();
		
		assertNotNull(listComments);
	}
	
	@Test
	void shouldGenerateAnError() {
		
		when(commentClient.getAllComments()).thenReturn(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
		
		boolean flag=false;
		
		try {
			commentService.findAllComments();
		} catch (ServiceException e) {
			flag=true;
		}
		
		assertTrue(flag);
	}
}
