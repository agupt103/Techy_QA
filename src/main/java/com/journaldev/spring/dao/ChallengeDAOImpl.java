package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Challenge;
import com.journaldev.spring.model.ChallengeComment;
import com.journaldev.spring.model.ChallengeVote;

@Repository
public class ChallengeDAOImpl implements ChallengeDAO{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}


	@Override
	public void addChallenge(Challenge challenge) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(challenge);
		
		
	}

	@Override
	public Challenge getChallenge(int challengeID) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();

		Challenge challenge = (Challenge) session.createQuery("from Challenge where challengeID=" + challengeID).list().get(0);
		return challenge;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Challenge> getAllChallenege(int challengeStatus) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		
		List<Challenge> listChallenge = session.createQuery("from Challenge where challengeStatus="+challengeStatus).list();
		return listChallenge;
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<Challenge> getOpenChallenges(int points) {
		// TODO Auto-generated method stub
		List<Challenge> listChallenge;
		Session session = this.sessionFactory.getCurrentSession();
		if(points<199){
		listChallenge = session.createQuery("from Challenge where challengeStatus=0 and points between 5 and 30").list();
		}
		else if(points>199 & points<499){
			listChallenge = session.createQuery("from Challenge where challengeStatus=0 and points between 31 and 100").list();
		}
		else{
			listChallenge = session.createQuery("from Challenge where challengeStatus=0 and points between 101 and 150").list();
		}
		return listChallenge;
	}
	

	@Override
	@SuppressWarnings("unchecked")
	public List<Challenge> getUnderReviewChallenges(int points) {
		// TODO Auto-generated method stub
		List<Challenge> listUnderReviewChallenge;
		Session session = this.sessionFactory.getCurrentSession();
		if(points<199){
		listUnderReviewChallenge = session.createQuery("from Challenge where challengeStatus=1 and points between 5 and 30").list();
		}
		else if(points>199 & points<499){
			listUnderReviewChallenge = session.createQuery("from Challenge where challengeStatus=1 and points between 31 and 100").list();
		}
		else{
			listUnderReviewChallenge = session.createQuery("from Challenge where challengeStatus=1 and points between 101 and 150").list();
		}
		return listUnderReviewChallenge;
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<Challenge> getCloseChallenges(int points) {
		// TODO Auto-generated method stub
		List<Challenge> listCloseChallenge;
		Session session = this.sessionFactory.getCurrentSession();
		if(points<199){
		listCloseChallenge = session.createQuery("from Challenge where challengeStatus=2 and points between 5 and 30").list();
		}
		else if(points>199 & points<499){
			listCloseChallenge = session.createQuery("from Challenge where challengeStatus=2 and points between 31 and 100").list();
		}
		else{
			listCloseChallenge = session.createQuery("from Challenge where challengeStatus=2 and points between 101 and 150").list();
		}
		return listCloseChallenge;
	}


	@Override
	public void addVote(ChallengeVote vote) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(vote);
	}

	@Override
	public boolean checkVote(ChallengeVote vote) {
		Session session = this.sessionFactory.getCurrentSession();
		List<ChallengeVote> votes = session.createQuery(
				"from ChallengeVote where reviewer='" + vote.getReviewer() + "' and challengeId=" + vote.getChallengeId())
				.list();
		if (votes == null || votes.size() == 0)
			return false;
		else
			return true;
	}

	@Override
	public int countVote(int challengeId, String vote) {
		Session session = this.sessionFactory.getCurrentSession();
		int numberOfVotes = 0;
		Object[] row = (Object[]) session.createSQLQuery(
				"select count(*) as number from challenge_voting where vote='" + vote + "' and challengeId=" + challengeId)
				.list().get(0);
		numberOfVotes = Integer.parseInt(row[0].toString());
		return numberOfVotes;
	}

	@Override
	public void addComment(ChallengeComment comment) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(comment);
	}

	@Override
	public List<ChallengeComment> getAllCommentToChallengeId(int challengeId) {
		Session session = this.sessionFactory.getCurrentSession();

		List<ChallengeComment> comments = session.createQuery("from ChallengeComment where challengeId=" + challengeId)
				.list();
		return comments;
	}


	@Override
	public void addAnswertoChallenge(Challenge ch) {
		// TODO Auto-generated method stub
		Session session =this.sessionFactory.getCurrentSession();
		System.out.println(ch.getOpponentUser());
		Query query=session.createQuery("update Challenge set challengeStatus=1, opponentUser ='" + ch.getOpponentUser()+"' , endTime='"+ ch.getEndTime()+"', opponentAnswer='"+ ch.getOpponentAnswer()+"' where challengeID=" + ch.getChallengeID());
		int result = query.executeUpdate();
		
		
	}
	
	
}
