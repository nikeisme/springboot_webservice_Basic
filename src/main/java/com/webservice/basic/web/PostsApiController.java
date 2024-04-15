package com.webservice.basic.web;

import com.webservice.basic.service.PostsService;
import com.webservice.basic.web.dto.PostsResponseDto;
import com.webservice.basic.web.dto.PostsSaveRequestDto;
import com.webservice.basic.web.dto.PostsUpdateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){ // HTTP 요청 몸체를 자바 객체로 전달
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateResponseDto requestDto){
        return postsService.update(id,requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return  postsService.findById(id);
    }

}
