package com.ipl.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ipl.dto.Fixtures;
import com.ipl.dto.Points;

public class IplRep {

	private static IplRep iplInstance;
	private Map<Integer,List<String>> iplTeams=new HashMap<>();
	private Map<Integer,Fixtures> fixtures = new HashMap<>();
	private Map<Integer,Points> pointstable = new HashMap<>();
	private Fixtures fix;
	private Points pointrefernce;
	
	List<String> csk = new ArrayList<>(Arrays.asList("Ruturaj","Convey","Moeen Ali","Raydu","Dhoni (C) (WK)","Jadeja","Sivam Dube","Pretorious","Deebak chahar","Mukesh","pathirana"));
	List<String> rcb = new ArrayList<>(Arrays.asList("V-Kohli(C)","Faf","Rajat paditar","Maxwell","Shabash","DK(WK)","Hasaranga","Harshal","Hazzle wood","Siraj","Kaul"));
	List<String> mi = new ArrayList<>(Arrays.asList("Rohit(C)","Ishan(WK)","SKY","Tilak varma","Brevis","TimDavid","Hrithik","Karthi keya","Bumbrah","Archer","Green"));
	List<String> kkr = new ArrayList<>(Arrays.asList("Venkatesh","Jagadeesan","Shreyas(C)","Rana(WK)","Rinku","Russel","Narine","Varun","Vaibhav","Southee","thakur"));
	List<String> punjab= new ArrayList<>(Arrays.asList("Dhawan(c)","Bairstow(WK)","Rajapaksha","Livingstone","Jithesh","Samcurren","Rahul Chahar","Rishi","Arsheep","Rabada"));
	List<String> srh =new ArrayList<>(Arrays.asList("Abhisek","Mayank(c)","Markram","Tripathi","Philips(WK)","Harry Brook","Adhil Rashidh","Markande","Bhuvaneswar","Karthik","Natarajan"));
	List<String> rr = new ArrayList<>(Arrays.asList("Jos butler","Jaishwal","Padikal","Samson(C)(WK)","Hetmeyar","Riyan","Ashwin","Chahal","Boult","Kuldeep","Prasidh"));
	List<String> dc = new ArrayList<>(Arrays.asList("Warner(C)","Prithvi","Sarfraz","Yash dull","Powel","Phil Salt","Lalit","Ripal patel","Kamalesh","Kuldeep","Sakariya"));
	
	private IplRep() {
		
	}
	
	public static IplRep getInstance() {
		if(iplInstance==null) {
			iplInstance=new IplRep();
			iplInstance.setPlayers();
			iplInstance.setFixtures();
			iplInstance.setpointsTable();
		}
		return iplInstance;
	}

	private void setPlayers() {
		iplTeams.put(1, csk);
		iplTeams.put(2, rcb);
		iplTeams.put(3, mi);
		iplTeams.put(4, kkr);
		iplTeams.put(5, srh);
		iplTeams.put(6, punjab);
		iplTeams.put(7, rr);
		iplTeams.put(8, dc);
	}

	public List<String> getPlayers(int opt) {
		if(iplTeams.containsKey(opt)) {
			return iplTeams.get(opt);
		}
		return null;
	}
	public void setFixtures() {
		fix=new Fixtures(1,"CSK","MI","01/02/23","CSK");
		fixtures.put(1, fix);
		fix=new Fixtures(2,"RCB","KKR","02/02/23","RCB");
		fixtures.put(2, fix);
		fix=new Fixtures(3,"Punjab","SRH","03/02/23","SRH");
		fixtures.put(3, fix);
		fix=new Fixtures(4,"DC","RR","04/02/23","RR");
		fixtures.put(4, fix);
		fix=new Fixtures(5,"CSK","RCB","05/02/23","RCB");
		fixtures.put(6, fix);
		fix=new Fixtures(6,"MI","KKR","06/02/23","MI");
		fixtures.put(6, fix);
		fix=new Fixtures(7,"Punjab","DC","07/02/23","Punjab");
		fixtures.put(7, fix);
		fix=new Fixtures(8,"SRH","RR","08/02/23","SRH");
		fixtures.put(8, fix);
		fix=new Fixtures(9,"CSK","KKR","09/02/23","CSK");
		fixtures.put(9, fix);
		fix=new Fixtures(10,"RCB","MI","10/02/23","RCB");
		fixtures.put(10, fix);
		fix=new Fixtures(11,"Punjab","RR","11/02/23","RR");
		fixtures.put(11, fix);
		fix=new Fixtures(12,"DC","SRH","12/02/23","DC");
		fixtures.put(12, fix);
		fix=new Fixtures(13,"CSK","Punjab","13/02/23","CSK");
		fixtures.put(13, fix);
		fix=new Fixtures(14,"RCB","DC","14/02/23","DC");
		fixtures.put(14, fix);
		fix=new Fixtures(15,"MI","SRH","16/02/23","MI");
		fixtures.put(15, fix);
		fix=new Fixtures(16,"KKR","RR","18/02/23","KKR");
		fixtures.put(16, fix);
		fix=new Fixtures(17,"CSK","SRH","19/02/23","SRH");
		fixtures.put(17, fix);
		fix=new Fixtures(18,"RCB","RR","20/02/23","RCB");
		fixtures.put(18, fix);
		fix=new Fixtures(19,"MI","Punjab","21/02/23","Punjab");
		fixtures.put(19, fix);
		fix=new Fixtures(20,"KKR","DC","22/02/23","KKR");
		fixtures.put(20, fix);
		fix=new Fixtures(21,"CSK","DC","23/02/23","DC");
		fixtures.put(21, fix);
		fix=new Fixtures(22,"RCB","Punjab","24/02/23","RCB");
		fixtures.put(22, fix);
		fix=new Fixtures(23,"KKR","SRH","25/02/23","KKR");
		fixtures.put(23, fix);
		fix=new Fixtures(24,"MI","RR","26/02/23","MI");
		fixtures.put(24, fix);
		fix=new Fixtures(25,"CSK","RR","27/02/23");
		fixtures.put(25, fix);
		fix=new Fixtures(26,"RCB","SRH","28/02/23");
		fixtures.put(26, fix);
		fix=new Fixtures(27,"KKR","Punjab","01/03/23");
		fixtures.put(27, fix);
		fix=new Fixtures(28,"MI","DC","02/03/23");
		fixtures.put(28, fix);

	}
	
	public List<Fixtures>  getFixtures(){
		List<Fixtures> allfixtures = new ArrayList<>();
		for(Map.Entry<Integer, Fixtures> entry : fixtures.entrySet()) {
			allfixtures.add(entry.getValue());
		}
		return allfixtures;
	}
    
	public void setpointsTable() {
		pointrefernce = new Points(1,"RCB",10,5);
		pointstable.put(1, pointrefernce);
		pointrefernce = new Points(2,"CSK",8,4);
		pointstable.put(2, pointrefernce);
		pointrefernce = new Points(3,"MI",6,3);
		pointstable.put(3, pointrefernce);
		pointrefernce = new Points(4,"KKR",6,3);
		pointstable.put(4, pointrefernce);
		pointrefernce = new Points(5,"DC",6,3);
		pointstable.put(5, pointrefernce);
		pointrefernce = new Points(6,"Punjab",4,2);
		pointstable.put(6, pointrefernce);
		pointrefernce = new Points(7,"SRH",4,2);
		pointstable.put(7, pointrefernce);
		pointrefernce = new Points(8,"RR",4,2);
		pointstable.put(8, pointrefernce);
	}
	
	public List<Points> getPointsTable(){
		List<Points> currentpointsTable = new ArrayList<>();
		for(Map.Entry<Integer, Points> entry : pointstable.entrySet()) {
			currentpointsTable.add(entry.getValue());
		}
		
		return currentpointsTable;
	}

	public void changePointsTable(String win1) {
		for(int i=1;i<=pointstable.size();i++) {
			if(win1.equalsIgnoreCase(pointstable.get(i).getTeam())) {
				int pointIncrement1=pointstable.get(i).getPoints()+2;
				pointstable.get(i).setPoints(pointIncrement1);
				int wonIncrement=pointstable.get(i).getNoOfWonMatches()+1;
				pointstable.get(i).setNoOfWonMatches(wonIncrement);
				if(1==i) {
					break;
				}
				else {
					Points point1 = null;
					int inc=0;
				    for(int j=i-1;j>0;j--) {
					  
					  if(pointstable.get(i).getPoints()>pointstable.get(j).getPoints()) {
						  point1=pointstable.get(i);
					      inc++;
					  }
					  else if(inc!=0) {
						  j++;
						  for(int k=inc;k>=1;k--) {
							  pointstable.put(j+k, pointstable.get((j+k)-1));
						  }
						  pointstable.put(j, point1);
						  break;
					  }
					  else { 
						  break;
					  }
				  }
				    break;
				}
				
			}
		}
	}

	public void changePosition() {
		 for(int a=1;a<=pointstable.size();a++) {
			  pointstable.get(a).setPosition(a);
		  }
	}

	public List<String> getsemiTeams() {
		List<String> semiteams=new ArrayList<>();
		for(int i=1;i<=pointstable.size()/2;i++) {
			semiteams.add(pointstable.get(i).getTeam());
		}
		return semiteams;
	}
}
