package com.semtax.application.controller;


import com.semtax.application.dto.PagingDTO;
import com.semtax.application.entity.Post;
import com.semtax.application.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PageController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/post/page")
    public Page<PagingDTO> paging(@PageableDefault(size=5, sort="createdTime") Pageable pageRequest) {

        Page<Post> postList = postRepository.findAll(pageRequest);

        Page<PagingDTO> pagingList = postList.map(
                post -> new PagingDTO(
                    post.getId(),post.getTitle(),
                    post.getCreatedBy(), post.getCreatedTime()
                ));

        return pagingList;
    }
}
