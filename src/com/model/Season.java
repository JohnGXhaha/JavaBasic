package com.model;

public enum Season {
	SPRING,SUNMMER,FAIL,WINTER;
	
	
	private String name;
	private String desc;

	public static void main(String[] args) {
		System.out.println(Season.values());
		for(Season s:Season.values()){
			System.out.println(s);
		}
		Season season=Enum.valueOf(Season.class, "WINTER");
		season.desc="��������";
		season.name="����";
		System.out.println(season+": ���"+season.name+season.desc);
		System.out.println(season.toString());
	}
}

