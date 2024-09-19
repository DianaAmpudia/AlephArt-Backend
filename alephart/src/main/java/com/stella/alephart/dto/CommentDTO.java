package com.stella.alephart.dto;

public class CommentDTO {
    private String commentDate;
    private String commentDescription;
    private Long postId;
    private Long userId;


    public CommentDTO() {
    }

    // Constructor con todos los argumentos
    public CommentDTO(String commentDate, String commentDescription, Long postId, Long userId) {
        this.commentDate = commentDate;
        this.commentDescription = commentDescription;
        this.postId = postId;
        this.userId = userId;
    }

    // Getters y setters
    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentDescription() {
        return commentDescription;
    }

    public void setCommentDescription(String commentDescription) {
        this.commentDescription = commentDescription;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

	@Override
	public String toString() {
		return "CommentDTO [commentDate=" + commentDate + ", commentDescription=" + commentDescription + ", postId="
				+ postId + ", userId=" + userId + "]";
	}
    
}