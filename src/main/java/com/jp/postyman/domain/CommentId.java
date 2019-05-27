package com.jp.postyman.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
//@Entity
public class CommentId implements Serializable {
//    @ManyToOne
//    @JoinColumn(name = "post", nullable = false)
    private int post;
    private int primaryCommentId;
}
