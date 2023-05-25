package com.spring.player.dao;

import java.util.List;


import com.spring.player.model.Player;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;





@Repository
public class PlayerDaoImpl implements PlayerDAO {

	@Autowired
	private EntityManager entityManager ;

	public PlayerDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Player> getPlayers() {
		Session session = entityManager.unwrap(Session.class);
		
		//Query<Player> query = session.createQuery("from Player ",Player.class);
		Query<Player> q = session.createQuery("from Player",Player.class);
		return q.getResultList();
	}


	
	@Override
	public void addPlayers(Player player) {

		Session session = entityManager.unwrap(Session.class);

		
		session.saveOrUpdate(player);
		
	}



	@Override
	public Player getPlayer(int id) {
		Session session = entityManager.unwrap(Session.class);
		
	
		return session.get(Player.class,id);
	}



	@Override
	public void deletePlayer(Player player) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(player);
	}

}
