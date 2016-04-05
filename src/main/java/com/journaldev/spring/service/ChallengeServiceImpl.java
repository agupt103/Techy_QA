package com.journaldev.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.ChallengeDAO;
import com.journaldev.spring.dao.QuestionDAO;
import com.journaldev.spring.model.Challenge;

@Service
public class ChallengeServiceImpl implements ChallengeService {
	
	public void setchallengeDAO(ChallengeDAO challengeDAO) {
		this.challengeDAO = challengeDAO;
	}
	
	private ChallengeDAO challengeDAO; 

	@Override
	@Transactional
	public boolean addChallenge(Challenge c){
		challengeDAO.addChallenge(c);
		return true;
	}

	@Override
	@Transactional
	public Challenge getChallenge(int challengeID) {
		return challengeDAO.getChallenge(challengeID);
	}

	@Override
	public List<Challenge> getAllChallenege(int challengeStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public ArrayList<Challenge> getOpenChallenges(int points) {
		// TODO Auto-generated method stub
		ArrayList<Challenge> listchallenges = (ArrayList<Challenge>) challengeDAO.getOpenChallenges(points);
		return listchallenges;
	}
	
}
