package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;

public class VoteBean {

	int candId;
	int userId;
	
			
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public VoteBean() {
	}
	public void vote() {
		try (CandidateDao c = new CandidateDaoImpl()) {
			c.incrementVote(this.candId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setStatus() {
		try (UserDao userDao = new UserDaoImpl()) {
			userDao.updateStatus(userId, true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
