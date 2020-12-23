package com.entelgy.prueba.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.CollectionUtils;

import com.entelgy.prueba.model.vo.CommentVo;
import com.entelgy.prueba.web.client.CommentClient;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Jhonatan A.
 *
 */
@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
class CommentClientTests {

	@Autowired
	private CommentClient commentClient;
	
	@Test
	@DisplayName("Deberia obtener todos los comentarios")
	void shouldGetAllComments() {
		
		ResponseEntity<List<CommentVo>> listComment = commentClient.getAllComments();
		
		if(!CollectionUtils.isEmpty(listComment.getBody())) {
			listComment.getBody().stream().forEach(comment -> {
				log.info(comment.toString());
			});
		}
		
		assertEquals(HttpStatus.OK, listComment.getStatusCode());
		assertNotNull(listComment.getBody());
	}
	
}
