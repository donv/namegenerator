package net.enusquest.namegenerator.actions;

import org.apache.struts.action.ActionForm;

public class GenerateForm extends ActionForm {
	String combinationName;
	String uniqueness = "none";
	int predictability = 10;
	int tries = 50;
	int count = 1;

	public GenerateForm() {
		super();
	}

	public String getCombinationName() {
		return combinationName;
	}

	public void setCombinationName(String newCombinationName) {
		this.combinationName = newCombinationName;
	}

	/**
	 * Gets the count
	 * 
	 * @return Returns a int
	 */
	public int getCount() {
		return count;
	}
	/**
	 * Sets the count
	 * 
	 * @param newCount
	 *            The count to set
	 */
	public void setCount(int newCount) {
		this.count = newCount;
	}

	/**
	 * Gets the uniqueness
	 * 
	 * @return Returns a String
	 */
	public String getUniqueness() {
		return uniqueness;
	}
	/**
	 * Sets the uniqueness
	 * 
	 * @param newUniqueness
	 *            The uniqueness to set
	 */
	public void setUniqueness(String newUniqueness) {
		this.uniqueness = newUniqueness;
	}

	/**
	 * @return Returns the predictability.
	 */
	public int getPredictability() {
		return predictability;
	}
	/**
	 * @param predictability
	 *            The predictability to set.
	 */
	public void setPredictability(int predictability) {
		this.predictability = predictability;
	}
	/**
	 * @return Returns the tries.
	 */
	public int getTries() {
		return tries;
	}
	/**
	 * @param tries
	 *            The tries to set.
	 */
	public void setTries(int tries) {
		this.tries = tries;
	}
}