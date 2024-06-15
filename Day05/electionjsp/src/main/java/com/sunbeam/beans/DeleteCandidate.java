package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class DeleteCandidate {
	private int id;
	private int count;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public DeleteCandidate() {
	}
	
	public void deleteCandidate() {
		try (CandidateDao candDao = new CandidateDaoImpl()) {
			count = candDao.deleteById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
