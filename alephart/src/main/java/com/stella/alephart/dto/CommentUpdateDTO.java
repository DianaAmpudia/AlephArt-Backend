package com.stella.alephart.dto;

public class CommentUpdateDTO {
	private Long id;
    private String commentDescription;

    public CommentUpdateDTO() {
    }

    public CommentUpdateDTO(Long id, String commentDescription) {
        this.id = id;
        this.commentDescription = commentDescription;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentDescription() {
        return commentDescription;
    }

    public void setCommentDescription(String commentDescription) {
        this.commentDescription = commentDescription;
    }

	@Override
	public String toString() {
		return "CommentUpdateDTO [id=" + id + ", commentDescription=" + commentDescription + "]";
	}
    
    
}

