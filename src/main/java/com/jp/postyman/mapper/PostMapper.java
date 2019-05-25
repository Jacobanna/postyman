package com.jp.postyman.mapper;

import com.jp.postyman.domain.Post;
import com.jp.postyman.model.PostDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostDto postToPostDto(Post post);
}
