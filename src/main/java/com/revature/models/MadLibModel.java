package com.revature.models;

public class MadLibModel {

	public String name;
	public String noun;
	public String adjective;
	public String verb;
	public String adverb;

	public MadLibModel() {

	}

	public MadLibModel(String name, String noun, String adjective, String verb, String adverb) {
		this.name = name;
		this.noun = noun;
		this.adjective = adjective;
		this.verb = verb;
		this.adverb = adverb;
	}

	@Override
	public String toString() {
		return "The mad lib name is " + name + ". One day, a " + noun + " went to the market to " + verb
				+ ". Noticing the day was " + adjective + ", though, the market closed " + adverb + ".";
	}

}