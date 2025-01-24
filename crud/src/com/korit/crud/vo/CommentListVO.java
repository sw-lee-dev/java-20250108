package com.korit.crud.vo;

import java.util.Objects;

public class CommentListVO {

	private String contents;
	private String writerNickname;
	private String writeDatetime;
	
	public CommentListVO(String contents, String writerNickname, String writeDatetime) {
		this.contents = contents;
		this.writerNickname = writerNickname;
		this.writeDatetime = writeDatetime;
	}

	public String getContents() {
		return contents;
	}
	public String getWriterNickname() {
		return writerNickname;
	}
	public String getWriteDatetime() {
		return writeDatetime;
	}

	@Override
	public String toString() {
		return contents + " / " + writerNickname + " / " + writeDatetime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contents, writeDatetime, writerNickname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentListVO other = (CommentListVO) obj;
		return Objects.equals(contents, other.contents) && Objects.equals(writeDatetime, other.writeDatetime)
				&& Objects.equals(writerNickname, other.writerNickname);
	}
}
