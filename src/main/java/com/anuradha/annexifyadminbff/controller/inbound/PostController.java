package com.anuradha.annexifyadminbff.controller.inbound;


import com.anuradha.annexifyadminbff.dto.PostDto;
import com.anuradha.annexifyadminbff.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostDto> findAll() {
        return postService.findAll();
    }


}
