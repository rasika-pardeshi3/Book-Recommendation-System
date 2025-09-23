package org.book.recommend.model;

import java.sql.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookModel {
	private int id;
	private String name;
	private float bprice;
	private String pyear;
	private String briefDesc;

}
