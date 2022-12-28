package com.kartik.java.eight;

public class Hosting {
	private int Id;
    private String name;
    private long websites;

    public Hosting(int id, String name, long websites) {
        Id = id;
        this.name = name;
        this.websites = websites;
    }

	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the websites
	 */
	public long getWebsites() {
		return websites;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param websites the websites to set
	 */
	public void setWebsites(long websites) {
		this.websites = websites;
	}
	
	@Override
    public String toString() {
        return "Hosting [id=" + Id + ", name=" + name + ", websites=" + websites + "]";
    }
}
