package com.anuradha.annexifyadminbff.controller.inbound;


import com.anuradha.annexifyadminbff.dto.FilterDto;
import com.anuradha.annexifyadminbff.dto.PostDto;
import com.anuradha.annexifyadminbff.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping
    public List<PostDto> findAll(@RequestBody FilterDto filter) {
        return postService.findAll(filter);
    }

    @GetMapping("by/id")
    public PostDto findById(@RequestParam String id) {
        return postService.findById(id);
    }


}
