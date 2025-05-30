package com.tka.service;

import java.util.List;

import com.tka.DAO.IPLDAO;
import com.tka.entity.Player;

public class IPLService {

	/*diplay players
	 * public List<Player> getAllPlayers() {
		System.out.println("IPL Service");
		IPLDAO iplDao = new IPLDAO();
		List <Player> playersList = iplDao.getAllPlayers();
		
		return playersList;
	}*/

	/*insert player
	 * public boolean addPlayer(Player player) {
        System.out.println("IPL Service - Inserting a new player...");
        IPLDAO iplDao = new IPLDAO();
        return iplDao.insertPlayer(player);
    }*/

	//Team
		public List<Player> getPlayersByTeam(String teamName) {
		    IPLDAO dao = new IPLDAO();
		    return dao.getPlayersByTeam(teamName);
		}
		
		public boolean deletePlayer(int jno) {
		    IPLDAO dao = new IPLDAO();
		    return dao.deletePlayerByJno(jno);
		}
		
	}

