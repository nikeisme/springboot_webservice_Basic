package com.webservice.basic.service;

import com.webservice.basic.domain.posts.Posts;
import com.webservice.basic.domain.posts.PostsRepository;
import com.webservice.basic.web.dto.PostsListResponseDto;
import com.webservice.basic.web.dto.PostsResponseDto;
import com.webservice.basic.web.dto.PostsSaveRequestDto;
import com.webservice.basic.web.dto.PostsUpdateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateResponseDto requestDto) {

        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        posts.update(requestDto.getTitle(),requestDto.getContent());

        return id;

    }

    public PostsResponseDto findById (Long id) {

        Posts entity = postsRepository.findById(id)
                .orElseThrow(()-> new
                        IllegalArgumentException("해당 게시글이 없습니다. id = " + id ));

        return new PostsResponseDto(entity);

    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }
}
