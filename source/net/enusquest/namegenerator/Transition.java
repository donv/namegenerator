package net.enusquest.namegenerator;

public class Transition {
	private int weight;
	private Node nextNode;

	public Transition(int newWeight, Node newNextNode) {
		weight = newWeight;
		nextNode = newNextNode;
	}

	public void addWeight() {
		weight++;
	}

	public int getWeight() {
		return weight;
	}

	public Node getNextNode() {
		return nextNode;
	}

}