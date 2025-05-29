package com.tka.controller;

import java.util.List;

import com.tka.entity.Player;
import com.tka.service.IPLService;

public class IPLController {

	public static void main(String[] args) {
		//System.out.println("IPL Controller");
		IPLService iplService = new IPLService();
		
		//insert player
		/*Player newPlayer = new Player(78, "hazelwood", 500, 600, "RCB");
        boolean isInserted = iplService.addPlayer(newPlayer);

        if (isInserted) {
            System.out.println(" Player inserted successfully.");
            
            System.out.println("Inserted Player Details:");
            System.out.println("Jno: " + newPlayer.getJno());
            System.out.println("Name: " + newPlayer.getPName());
            System.out.println("Runs: " + newPlayer.getRuns());
            System.out.println("Wickets: " + newPlayer.getWickets());
            System.out.println("Team: " + newPlayer.getTeam());
        } //else {
          //  System.out.println(" Failed to insert player.");
       // }*/

		/*Fetching all players
		//List<Player> allplayersList = iplService.getAllPlayers();
		
		//displaying all players
		//for(Player player : allplayersList) {
			//System.out.println("Player Jno"+player.getJno() + "Player name"+player.getPName()+"Player runs"+player.getRuns()+"Player Wickets"+
		   //    player.getWickets()+"Player team"+player.getTeam());*/
		
		
		//Teams
		System.out.println("RCB Players");
        List<Player> rcbPlayers = iplService.getPlayersByTeam("RCB");
        for (Player player : rcbPlayers) {
            System.out.println("Jno: " + player.getJno()
                + ", Name: " + player.getPName()
                + ", Runs: " + player.getRuns()
                + ", Wickets: " + player.getWickets()
                + ", Team: " + player.getTeam());
        }
        System.out.println("MI PLayers");
        List<Player> MIPlayers = iplService.getPlayersByTeam("MI");
        for (Player player : MIPlayers) {
            System.out.println("Jno: " + player.getJno()
                + ", Name: " + player.getPName()
                + ", Runs: " + player.getRuns()
                + ", Wickets: " + player.getWickets()
                + ", Team: " + player.getTeam());
        }
		
		}
	}
//}

	


