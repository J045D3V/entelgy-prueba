package com.entelgy.prueba.web.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.entelgy.prueba.model.vo.CommentVo;
import com.entelgy.prueba.web.client.fallback.CommentClientFallback;

/**
 * 
 * @author Jhonatan A.
 *
 */
@FeignClient(name = "comment-client",url = "${app.client.url}",fallback = CommentClientFallback.class)
public interface CommentClient {

	@GetMapping(value = "/comments")
	ResponseEntity<List<CommentVo>> getAllComments();
	
}
