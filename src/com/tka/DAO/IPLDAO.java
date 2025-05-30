package com.tka.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tka.entity.Player;

public class IPLDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	List<Player> playersList = null;
	
	//Driver class path
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/batch7032db";
	String username = "root";
	String password = "soumya86";
	//private boolean ;
	

	public List<Player> getAllPlayers() {
		String query = "Select*From players";
		//step1 Load driver class
		try {
			Class.forName(path);
			//step2 Establish the connection
			
			conn = DriverManager.getConnection(url, username, password);
			
			//step3 Prepared statement
			
			pstmt = conn.prepareStatement(query);
			//step4  Execute query
			rs = pstmt.executeQuery();
			//step5 Process the resultSet
			playersList = new ArrayList<Player>();
			while(rs.next()) {
				
				int Jno = rs.getInt(1);
				String PName =rs.getString(2);
				int runs = rs.getInt(3);
				int wickets = rs.getInt(4);
				String team = rs.getString(5);
				Player player = new Player(Jno,PName,runs,wickets,team);
				
				//ADD players to the list
				playersList.add(player);
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//step6 close the resource
			try {
				if (rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
					conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		//System.out.println("IN IPL DAO");
		return playersList;
	}

     
	//Insert Player
	public boolean insertPlayer(Player player) {
		String insertQuery ="INSERT INTO Players (Jerseyno, PlayerName, Runs, Wickets, Tname) VALUES (?, ?, ?, ?, ?)";
		boolean status= false;
		
		try {
            Class.forName(path);
            conn = DriverManager.getConnection(url, username, password);
            pstmt = conn.prepareStatement(insertQuery);

            pstmt.setInt(1, player.getJno());
            pstmt.setString(2, player.getPName());
            pstmt.setInt(3, player.getRuns());
            pstmt.setInt(4, player.getWickets());
            pstmt.setString(5, player.getTeam());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                status = true;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                pstmt.close();
                if (conn != null) 
                	conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

       
		return status;
    }
	
	//find teams
    public List<Player> getPlayersByTeam(String teamName) {
        List<Player> teamPlayers = new ArrayList<>();
        String query = "SELECT * FROM players WHERE TName = ?";

        try {
            Class.forName(path);
            conn = DriverManager.getConnection(url, username, password);
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, teamName);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int jno = rs.getInt(1);
                String pname = rs.getString(2);
                int runs = rs.getInt(3);
                int wickets = rs.getInt(4);
                String team = rs.getString(5);

                Player player = new Player(jno, pname, runs, wickets, team);
                teamPlayers.add(player);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return teamPlayers;
    }

    
    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean deletePlayerByJno(int jno) {
        String deleteQuery = "DELETE FROM players WHERE Jerseyno = ?";
        boolean Deleted = false;

        try {
            Class.forName(path);
            conn = DriverManager.getConnection(url, username, password);
            pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setInt(1, jno);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                Deleted = true;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return Deleted;
    }
    }





	
