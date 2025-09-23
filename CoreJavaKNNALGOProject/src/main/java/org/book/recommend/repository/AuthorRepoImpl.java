package org.book.recommend.repository;

import java.sql.SQLException;

import org.book.recommend.config.DBConfig;
import org.book.recommend.model.AuthorModel;

public class AuthorRepoImpl extends DBConfig implements AuthorRepo {
	public int getAuthorId(String authorName) {
		try {
			stmt = conn.prepareStatement("select aid from author where name=?");
			stmt.setString(1, authorName);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			return -1;

		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return -1;
		}
	}

	@Override
	public boolean isAddNewAuthor(AuthorModel model) {
		try
		{
		 stmt=conn.prepareStatement("insert into author values('0',?,?,?)");
		 stmt.setString(1,model.getName());
		 stmt.setString(2, model.getQual());
		 stmt.setInt(3,model.getExp());
		 int value=stmt.executeUpdate();
		 return value>0?true:false;
		 
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	public int getBookId() {
		try
		{
			int id=0;
			stmt=conn.prepareStatement("select max(aid) from book");
			rs=stmt.executeQuery();
			if(rs.next()) {
				id=rs.getInt(1);
			}
			return id;
		}
		catch(Exception ex) {
			return -1;
		}
	}
	public int getAuthId() {
		try
		{
			int id=0;
			stmt=conn.prepareStatement("select max(aid) from author");
			rs=stmt.executeQuery();
			if(rs.next()) {
				id=rs.getInt(1);
			}
			return id;
		}
		catch(Exception ex) {
			System.out.println("In author id function "+ex);
			return -1;
		}
	}

	public boolean isAssociateAuthorBookPubCat(int catId, int pubId, boolean status, int authid) {
		if(status && authid!=-1) {
			try {
				System.out.println("Within if "+status+"\t"+authid);
				stmt=conn.prepareStatement("insert into bookauthcatjoin(?,?,?,?)");
				stmt.setInt(1, this.getAuthId());
				stmt.setInt(2, this.getBookId());
				stmt.setInt(3, pubId);
				stmt.setInt(4, catId);
				int value=stmt.executeUpdate();
				return value>0?true:false;
			}
			catch(SQLException e) {
				e.printStackTrace();
				System.out.println("within if Error is "+e);
				return false;
				
			}
		}
		else {
			try {
				
				stmt=conn.prepareStatement("insert into bookauthcatjoin values(?,?,?,?)");
				stmt.setInt(1, authid);
				stmt.setInt(2, this.getBookId());
				stmt.setInt(3, pubId);
				stmt.setInt(4, catId);
				int value=stmt.executeUpdate();
				System.out.println("Within else "+status+"\t"+this.getAuthId());
				
				return value>0?true:false;
			}
			catch(SQLException e) {
				e.printStackTrace();
				System.out.println("within else Error is "+e);
				return false;
			}
		}
	}
}
		
	


