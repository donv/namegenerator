package net.enusquest.namegenerator.actions;

import org.apache.struts.action.ActionForm;

public class GenerateForm extends ActionForm {
  String combinationName;
  String uniqueness;
  int count;

  /**
   * Constructor for generateAction
   */
  public GenerateForm() {
    super();
  }

  /**
   * Gets the combinationName
   * @return Returns a String
   */
  public String getCombinationName() {
    return combinationName;
  }
  /**
   * Sets the combinationName
   * @param combinationName The combinationName to set
   */
  public void setCombinationName(String combinationName) {
    this.combinationName = combinationName;
  }

  /**
   * Gets the count
   * @return Returns a int
   */
  public int getCount() {
    return count;
  }
  /**
   * Sets the count
   * @param count The count to set
   */
  public void setCount(int count) {
    this.count = count;
  }

  /**
   * Gets the uniqueness
   * @return Returns a String
   */
  public String getUniqueness() {
    return uniqueness;
  }
  /**
   * Sets the uniqueness
   * @param uniqueness The uniqueness to set
   */
  public void setUniqueness(String uniqueness) {
    this.uniqueness = uniqueness;
  }

}